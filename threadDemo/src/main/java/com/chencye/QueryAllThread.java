package com.chencye;

import java.util.concurrent.TimeUnit;

public class QueryAllThread {
    public static void main(String[] args) {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            Thread[] allThreads = queryAllThreads();
            System.out.println("Thead Monitor Begin--------------------");
            for (Thread t : allThreads) {
                System.out.println("[T:" + t.getName() + ", ID:" + t.getId() + ", STATUS:" + t.getState() + "]");
            }
            System.out.println("Thead Monitor END--------------------");
        }
    }
    
    /**
     * 查询所有线程数组
     * 
     * @return
     */
    public static Thread[] queryAllThreads() {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = group;
        
        // 遍历线程组树，获取根线程组
        while (group != null) {
            topGroup = group;
            group = group.getParent();
        }
        
        // 激活的线程数加倍
        int estimatedSize = topGroup.activeCount() * 2;
        Thread[] slackList = new Thread[estimatedSize];
        
        // 获取根线程组的所有线程
        int actualSize = topGroup.enumerate(slackList);
        Thread[] list = new Thread[actualSize];
        System.arraycopy(slackList, 0, list, 0, actualSize);
        return list;
    }
}

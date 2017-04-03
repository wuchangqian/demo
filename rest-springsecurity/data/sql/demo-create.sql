-- 账号表
DROP TABLE IF EXISTS account;
CREATE TABLE account (
   id INT PRIMARY KEY auto_increment,
   name VARCHAR (50) NOT NULL UNIQUE,
   PASSWORD VARCHAR (16) NOT NULL,
   STATUS INT DEFAULT 0 COMMENT '0有效，其它无效'
) COMMENT '账号密码表';

-- 角色表
DROP TABLE IF EXISTS role;
CREATE TABLE role (
   id INT PRIMARY KEY auto_increment,
   NAME VARCHAR (50) UNIQUE COMMENT '角色名称',
   LEVEL INT DEFAULT 0 COMMENT '角色级别, 0超级管理员，1-100 特殊角色， 其它普通用户',
   remark VARCHAR (50) COMMENT '备注',
   reverse INT DEFAULT 0 COMMENT '0正常角色，1反向角色(用于取消指定用户的菜单与权限)',
   STATUS INT DEFAULT 0 COMMENT '0有效，其它无效'
) COMMENT '角色表';

-- 账号角色关系表
DROP TABLE IF EXISTS account_role;
CREATE TABLE account_role (
   account_id INT,
   role_id INT,
   PRIMARY KEY (account_id, role_id)
) COMMENT '账号角色关系表';

-- 菜单表
DROP TABLE IF EXISTS menu;
CREATE TABLE menu (
   id INT PRIMARY KEY auto_increment,
   parent_id INT COMMENT '父菜单ID',
   name varchar(50) unique COMMENT '菜单名',
   img varchar(50) comment '菜单图标',
   title VARCHAR (50) COMMENT '菜单标题',
   url VARCHAR (256) COMMENT '菜单链接',
   STATUS INT DEFAULT 0 COMMENT '0有效，其它无效'
) COMMENT '菜单表';

-- 角色菜单表
DROP TABLE IF EXISTS role_menu;
CREATE TABLE role_menu (
   role_id INT,
   menu_id INT,
   PRIMARY KEY (role_id, menu_id)
) COMMENT '角色菜单关系表';

-- 权限表
DROP TABLE IF EXISTS authority;
CREATE TABLE authority (
   id INT PRIMARY KEY auto_increment,
   NAME VARCHAR (50) COMMENT '中文名，用于页面权限配置的显示',
   VALUE VARCHAR (50) UNIQUE COMMENT '值，用于权限校验，命令为模块+功能形式',
   remark VARCHAR (50) COMMENT '备注',
   type INT DEFAULT 0 COMMENT '权限类型，1查询，2增加，3更新，4删除',
   STATUS INT DEFAULT 0 COMMENT '0有效，其它无效'
) COMMENT '权限表';

-- 角色权限表
DROP TABLE IF EXISTS role_authority;
CREATE TABLE role_authority (
   role_id INT,
   auth_id INT,
   PRIMARY KEY (role_id, auth_id)
) COMMENT '角色权限关系表';

-- 权限菜单关系表
DROP TABLE IF EXISTS menu_authority;
CREATE TABLE menu_authority (
   menu_id INT,
   auth_id INT,
   PRIMARY KEY (menu_id, auth_id)
) COMMENT '权限菜单关系表，用于页面权限配置';

-- 资源表
DROP TABLE IF EXISTS resource;
CREATE TABLE resource (
   id INT PRIMARY KEY auto_increment,
   resource VARCHAR (256) COMMENT '资源地址',
   remark VARCHAR (50) COMMENT '备注',
   STATUS INT DEFAULT 0 COMMENT '0有效，其它无效'
) COMMENT '资源表，所有URL';

-- 资源权限表
DROP TABLE IF EXISTS res_authority;
CREATE TABLE res_authority (
   res_id INT,
   auth_id INT,
   PRIMARY KEY (res_id, auth_id)
) COMMENT '资源权限关系表';

-- 配置表
DROP TABLE IF EXISTS conf;
CREATE TABLE conf (
   NAME VARCHAR (50) PRIMARY KEY COMMENT '配置名称',
   value VARCHAR (256) COMMENT '配置值',
   remark VARCHAR (256)
) COMMENT '配置表';

-- 返回码表
DROP TABLE IF EXISTS retcode;
CREATE TABLE retcode (
   CODE VARCHAR (8) NOT NULL,
   message VARCHAR (256)
) COMMENT '返回码表';

-- 正则表
DROP TABLE IF EXISTS regex;
CREATE TABLE regex (
   NAME VARCHAR (32) UNIQUE,
   value VARCHAR (256)
) COMMENT '正则表';

-- 字典表
DROP TABLE IF EXISTS dict;
CREATE TABLE dict (
   id INT PRIMARY KEY auto_increment,
   groupname VARCHAR (256) COMMENT '字典组名',
   NAME VARCHAR (256) COMMENT '字典项名',
   VALUE VARCHAR (256) COMMENT '字典项值',
   remark VARCHAR (256) COMMENT '备注',
   sort INT DEFAULT 0 COMMENT '排序',
   STATUS INT DEFAULT 0 COMMENT '0有效，其它无效'
) COMMENT '字典表';

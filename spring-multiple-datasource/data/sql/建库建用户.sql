-- 登录root
-- mysql -u root

-- 创建数据库
CREATE DATABASE IF NOT EXISTS chencyeDB DEFAULT  CHARSET utf8 COLLATE utf8_general_ci;

-- 创建用户1
CREATE USER chencye IDENTIFIED BY 'chencye';
-- 给新用户1授权
GRANT ALL ON chencyeDB.* TO chencye;


-- 创建数据库2
CREATE DATABASE IF NOT EXISTS chencyeDB2 DEFAULT  CHARSET utf8 COLLATE utf8_general_ci;

-- 创建用户2
CREATE USER chencye2 IDENTIFIED BY 'chencye2';
-- 给新用户1授权
GRANT ALL ON chencyeDB2.* TO chencye2;

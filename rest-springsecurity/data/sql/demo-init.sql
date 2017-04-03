insert into account (name, password) values ('admin', 'test_123');
insert into account (name, password) values ('gzadmin', 'test_123');

insert into role (name, level, remark) values ('systemAdmin', 1, '系统管理员');
insert into role (name, level, remark) values ('admin', 2, '普通管理员');

insert into account_role values ((select id from account where name = 'admin'), (select id from role where name = 'systemAdmin'));
insert into account_role values ((select id from account where name = 'gzadmin'), (select id from role where name = 'admin'));

insert into menu (parent_id, name, img, title, url) values (null, 'authManager', null, '用户管理', null);
insert into menu (parent_id, name, img, title, url) 
select id as parent_id, 'account', null, '账号管理', '/home/system/account' from menu where name = 'authManager' union all
select id as parent_id, 'role', null, '角色管理', '/home/system/role' from menu where name = 'authManager' union all
select id as parent_id, 'menu', null, '菜单管理', '/home/system/menu' from menu where name = 'authManager' union all
select id as parent_id, 'authority', null, '权限管理', '/home/system/authority' from menu where name = 'authManager' union all
select id as parent_id, 'resource', null, '资源管理', '/home/system/resource' from menu where name = 'authManager';

insert into role_menu values ((select id from role where name = 'systemAdmin'), (select id from menu where name = 'authManager' and parent_id is null));
insert into role_menu values ((select id from role where name = 'systemAdmin'), (select id from menu where name = 'account' and url = '/home/system/account'));
insert into role_menu values ((select id from role where name = 'systemAdmin'), (select id from menu where name = 'role' and url = '/home/system/role'));
insert into role_menu values ((select id from role where name = 'systemAdmin'), (select id from menu where name = 'menu' and url = '/home/system/menu'));
insert into role_menu values ((select id from role where name = 'systemAdmin'), (select id from menu where name = 'authority' and url = '/home/system/authority'));
insert into role_menu values ((select id from role where name = 'systemAdmin'), (select id from menu where name = 'resource' and url = '/home/system/resource'));

insert into authority (name, value, type, remark) values ('列表查询', 'account_list', 1, '账号列表查询');
insert into authority (name, value, type, remark) values ('单用户查询', 'account_query', 1, '账号查询');
insert into authority (name, value, type, remark) values ('增加', 'account_add', 2, '增加账号');
insert into authority (name, value, type, remark) values ('更新', 'account_update', 3, '更新账号');
insert into authority (name, value, type, remark) values ('删除', 'account_delete', 4, '删除账号');

insert into role_authority select id, (select id from role where name = 'systemAdmin') from authority;

insert into resource (resource, remark) values ('/account', '账号列表查询');
insert into resource (resource, remark) values ('/account/**', '账号管理API');

insert into res_authority values ((select id from resource where resource = '/account'), (select id from authority where value = 'account_list'));
insert into res_authority values ((select id from resource where resource = '/account/**'), (select id from authority where value = 'account_query'));
insert into res_authority values ((select id from resource where resource = '/account/**'), (select id from authority where value = 'account_add'));
insert into res_authority values ((select id from resource where resource = '/account/**'), (select id from authority where value = 'account_update'));
-- insert into res_authority values ((select id from resource where resource = '/account/**'), (select id from authority where name = 'account_delete'));

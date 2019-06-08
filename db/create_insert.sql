
 DROP TABLE IF EXISTS `role_permission`;
 DROP TABLE IF EXISTS `permission`;
 DROP TABLE IF EXISTS `user_role`;
 DROP TABLE IF EXISTS `role`;
 DROP TABLE IF EXISTS `user`;

 CREATE TABLE `user` (
 `id` VARCHAR(255) PRIMARY KEY,
 `name` VARCHAR(255),
 `password` VARCHAR(255)
 ) engine = InnoDB default charset = utf8 comment = '用户表';

 CREATE TABLE `role` (
 `id` VARCHAR(255) PRIMARY KEY,
 `name` VARCHAR(255)
 ) engine = InnoDB default charset = utf8 comment = '角色表';

 CREATE TABLE `user_role` (
 `id` VARCHAR(255) PRIMARY KEY,
 `user_id` VARCHAR(255),
 `role_id` VARCHAR(255),
 FOREIGN KEY (`user_id`) REFERENCES `user`(id),
 FOREIGN KEY (`role_id`) REFERENCES `role`(id)
 ) engine = InnoDB default charset = utf8 comment = '用户与角色多对多表';

 CREATE TABLE `permission` (
 `id` VARCHAR(255) PRIMARY KEY,
 `name` VARCHAR(255),
 `url` VARCHAR(255)
 ) engine = InnoDB default charset = utf8 comment = '权限表';

 CREATE TABLE `role_permission` (
 `id` VARCHAR(255) PRIMARY KEY,
 `role_id` VARCHAR(255),
 `permission_id` VARCHAR(255),
 FOREIGN KEY (`role_id`) REFERENCES `role`(id),
 FOREIGN KEY (`permission_id`) REFERENCES `permission`(id)
 ) engine = InnoDB default charset = utf8 comment = '角色与权限多对多表';

insert into `user` (`id`, `name`, `password`) values('1','admin','123456');
insert into `user` (`id`, `name`, `password`) values('2','vip','123456');
insert into `user` (`id`, `name`, `password`) values('3','svip','1234');

insert into `role` (`id`, `name`) values('1','user');
insert into `role` (`id`, `name`) values('2','vip');
insert into `role` (`id`, `name`) values('3','svip');

insert into `permission` (`id`, `name`, `url`) values('1','user','user');
insert into `permission` (`id`, `name`, `url`) values('2','vip','vip');
insert into `permission` (`id`, `name`, `url`) values('3','svip','svip');

insert into `user_role` (`id`, `user_id`, `role_id`) values('1','1','1');
insert into `user_role` (`id`, `user_id`, `role_id`) values('2','2','1');
insert into `user_role` (`id`, `user_id`, `role_id`) values('3','2','2');
insert into `user_role` (`id`, `user_id`, `role_id`) values('4','3','1');
insert into `user_role` (`id`, `user_id`, `role_id`) values('5','3','2');
insert into `user_role` (`id`, `user_id`, `role_id`) values('6','3','3');

insert into `role_permission` (`id`, `role_id`, `permission_id`) values('1','1','1');
insert into `role_permission` (`id`, `role_id`, `permission_id`) values('2','2','1');
insert into `role_permission` (`id`, `role_id`, `permission_id`) values('3','2','2');
insert into `role_permission` (`id`, `role_id`, `permission_id`) values('4','3','1');
insert into `role_permission` (`id`, `role_id`, `permission_id`) values('5','3','2');
insert into `role_permission` (`id`, `role_id`, `permission_id`) values('6','3','3');
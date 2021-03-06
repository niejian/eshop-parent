drop table if exists sys_user;
CREATE TABLE `sys_user` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(16) NOT NULL,
  `user_name` varchar(32) NOT NULL,
  `user_nick_name` varchar(32) DEFAULT '',
  `user_password` varchar(64) DEFAULT NULL,
  `avatar` varchar(64) DEFAULT '' COMMENT '头像信息',
  `create_time` datetime(3) NOT NULL,
  `create_by` varchar(32) NOT NULL,
  `modify_time` datetime(3) NOT NULL,
  `modify_by` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';


drop table if exists sys_role;
create table sys_role (
  id bigint(10) primary key auto_increment,
  role_code varchar (32) not null ,
  role_name varchar (32) not null ,
  create_time datetime(3) not null ,
  create_by varchar (32) not null ,
  modify_time datetime(3) not null ,
  modify_by varchar (32) not null

)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色信息表';
drop table if exists sys_user_role;
create table sys_user_role(
  id bigint(10) primary key auto_increment,
  role_id bigint(10) not null ,
  user_id bigint(10) not  null ,
  create_time datetime(3) not null ,
  create_by varchar (32) not null ,
  modify_time datetime(3) not null ,
  modify_by varchar (32) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色信息表';
drop table if exists sys_menus;
CREATE TABLE `sys_menus` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `menu_code` varchar(32) NOT NULL,
  `menu_name` varchar(32) NOT NULL,
  `parent_ids` varchar(64) DEFAULT NULL COMMENT '父菜单id集合',
  `parent_id` bigint(10) DEFAULT NULL COMMENT '父菜单id集合',
  `menu_type` tinyint(1) DEFAULT '0' COMMENT '菜单类型（0：菜单；1：按钮）',
  `leaf` tinyint(1) DEFAULT '0' COMMENT '是否叶子节点（1：叶子节点，1：非叶子节点）',
  `num` tinyint(1) DEFAULT '0' COMMENT '排序',
  `icon` VARCHAR (16) DEFAULT '' comment '菜单图标',
  `menu_url` varchar(32) DEFAULT NULL,
  `create_time` datetime(3) NOT NULL,
  `create_by` varchar(32) NOT NULL,
  `modify_time` datetime(3) NOT NULL,
  `modify_by` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单信息表';


drop table if exists sys_role_menu;
create table sys_role_menu(
  id bigint(10) primary key auto_increment,
  role_id bigint(10) not null ,
  menu_id bigint(10) not  null ,
  create_time datetime(3) not null ,
  create_by varchar (32) not null ,
  modify_time datetime(3) not null ,
  modify_by varchar (32) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单角色信息表';
alter table sys_menus add COLUMN parent_menu_name varchar(32) comment '父菜单名称';
alter table sys_menus add COLUMN parent_menu_code varchar(16) comment '父菜单编码';
ALTER table sys_user add COLUMN delete_flag TINYINT(1) DEFAULT 0 COMMENT '是否删除;1：删除；0:未删除’'
ALTER table sys_user_role add  COLUMN role_code VARCHAR(32) DEFAULT NULL COMMENT '角色编码';
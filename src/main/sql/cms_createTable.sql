/*drop index INDEX_USER_CODE on CMS_USER_INFO;*/
drop table if exists CMS_USER_INFO;

/*==============================================================*/
/* Table: CMS_USER_INFO                                         */
/*==============================================================*/
create table CMS_USER_INFO
(
   ID              integer(10) not null auto_increment comment '用户ID',
   USER_CODE            varchar(20) not null comment '用户编码',
   USER_NAME            varchar(64) not null comment '用户名称',
   USER_PWD             varchar(150) comment '用户密码',
   REMARK               varchar(60) comment '备注',
   CREATE_BY            varchar(20) comment '创建人',
   CREATE_DATE          datetime comment '创建时间',
   MODIFIED_BY          varchar(20) comment '修改人',
   MODIFIED_DATE        datetime comment '修改时间',
   SORTNO               integer(2) default 0 comment '排序',
   STATE                integer(2) comment '数据状态',
   primary key (ID)
);

/*==============================================================*/
/* Index: INDEX_USER_CODE                                       */
/*==============================================================*/
create index INDEX_USER_CODE on CMS_USER_INFO
(
   USER_CODE
);

drop table if exists CMS_ROLE_INFO;

/*==============================================================*/
/* Table: CMS_ROLE_INFO                                         */
/*==============================================================*/
create table CMS_ROLE_INFO
(
   ID                   integer(10) not null auto_increment comment '角色编号',
   ROLE_CODE            varchar(20) not null comment '角色编码',
   ROLE_NAME            varchar(60) not null comment '角色名称',
   CREATE_BY            varchar(20) comment '创建人',
   CREATE_DATE          datetime comment '创建时间',
   MODIFIED_BY          varchar(20) comment '修改人',
   MODIFIED_DATE        datetime comment '修改时间',
   SORTNO               integer(2) default 0 comment '排序',
   STATE                integer(2) comment '数据状态',
   primary key (ID)
);

drop table if exists CMS_FUNCTION_INFO;

/*==============================================================*/
/* Table: CMS_FUNCTION_INFO                                 */
/*==============================================================*/
create table CMS_FUNCTION_INFO
(
   ID                   int not null auto_increment comment '主键',
   FUN_CODE             varchar(10) not null comment '菜单编码',
   FUN_NAME             varchar(100) not null comment '菜单名称',
   FUN_PCODE            varchar(10) not null comment '父编码',
   URL                  varchar(200) comment '菜单地址',
   LEVEL                int not null comment '菜单层级',
   CREATE_BY            varchar(20) comment '创建人',
   CREATE_DATE          datetime comment '创建时间',
   MODIFIED_BY          varchar(20) comment '修改人',
   MODIFIED_DATE        datetime comment '修改时间',
   SORTNO               integer(2) default 0 comment '排序',
   STATE                integer(2) comment '数据状态',
   primary key (ID)
);

/*==============================================================*/
/* Index: INDEX_FUN_CODE                                        */
/*==============================================================*/
create index INDEX_FUN_CODE on T_RFDCS_FUNCTION_INFO
(
   FUN_CODE
);

drop table if exists CMS_USER_ROLE_R;

/*==============================================================*/
/* Table: CMS_USER_ROLE_R                                       */
/*==============================================================*/
create table CMS_USER_ROLE_R
(
   ID                   int not null auto_increment,
   USER_CODE            varchar(10),
   ROLE_CODE            varchar(10),
   CREATE_BY            varchar(20) comment '创建人',
   CREATE_DATE          datetime comment '创建时间',
   MODIFIED_BY          varchar(20) comment '修改人',
   MODIFIED_DATE        datetime comment '修改时间',
   SORTNO               integer(2) default 0 comment '排序',
   STATE                integer(2) comment '数据状态',
   primary key (ID)
);

drop table if exists CMS_ROLE_FUN_R;

/*==============================================================*/
/* Table: CMS_ROLE_FUN_R                                        */
/*==============================================================*/
create table CMS_ROLE_FUN_R
(
   ID                   int not null auto_increment,
   ROLE_CODE            varchar(10),
   FUN_CODE             varchar(10),
   CREATE_BY            varchar(20) comment '创建人',
   CREATE_DATE          datetime comment '创建时间',
   MODIFIED_BY          varchar(20) comment '修改人',
   MODIFIED_DATE        datetime comment '修改时间',
   SORTNO               integer(2) default 0 comment '排序',
   STATE                integer(2) comment '数据状态',
   primary key (ID)
);



create table shopping.school_info
(
    id          int auto_increment,
    name        varchar(30)                           null comment '学院名称',
    student_num int                                   null comment '学生数量',
    created_at  datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    created_by  varchar(30) default ''                not null comment '创建人',
    updated_by  varchar(30)                           not null comment '更新人',
    updated_at  datetime                              not null comment '更新时间',
    valid       tinyint     default 0                 not null,
    constraint idnew_table_UNIQUE
        unique (id)
);

alter table shopping.school_info
    add primary key (id);


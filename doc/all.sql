drop table if exists test1;
create table test1 (
    id bigint not null comment 'id',
    name varchar(100) comment '名称',
    password varchar(50) comment '密码',
    primary key (id)
)engine=innodb default charset =utf8mb4 comment '测试';

insert into test1 (id, name, password)
values (1, 'java', '2134');

create table demo (
    id bigint not null comment 'id',
    name varchar(100) comment '名称',
    primary key (id)
)engine=innodb default charset =utf8mb4 comment '测试';

select * from  test1;
create user spring identified by 1111;

grant dba to spring;

create table users(
    id varchar2(30) primary key,
    password varchar2(64) not null,
    name varchar2(20) not null
);

desc users;
select * from users;

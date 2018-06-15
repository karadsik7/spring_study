
create table products(
    id number primary key,
    name varchar2(15) not null,
    count number(4) not null,
    regdate timestamp not null
);

select * from products;

create sequence seq_products_id;

insert into products values(seq_products_id.nextval, 'µû¸ªÀÌ', 10, systimestamp);

create table in_products(
    id number primary key,
    name varchar2(15) not null,
    count number(4) not null,
    regdate timestamp not null
);

create table out_products(
    id number primary key,
    name varchar2(15) not null,
    count number(4) not null,
    regdate timestamp not null
);

create sequence seq_in_products_id;
create sequence seq_out_products_id;

insert into in_products values(seq_in_products_id.nextval, 'µû¸ªÀÌ', 10, systimestamp);

select * from in_products;  

delete from products;
delete from in_products;
delete from out_products;
select * from out_products;
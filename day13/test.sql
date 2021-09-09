create table bank1(
   bid int primary key,
    name varchar(20),
    balance int
);
create table bank2(
   bid int primary key,
    name varchar(20),
    balance int
);
insert into bank1 values(1001,'아무무',20000);
insert into bank2 values(2001,'티모',10000);

select * from BANK1;
select * from BANK2;

drop table bank1;
drop table bank2;
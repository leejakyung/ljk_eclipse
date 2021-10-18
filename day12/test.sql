select * from all_tables;

create table test2(
	name varchar(20),
	email varchar(30)
);

insert into test2 values('kim','ljk940826@naver.com');
insert into test2 values('lee','codinghelper@naver.com');

select * from test2;

select @@autocommit;
set autocommit=0;
commit;
delete from test where name='a';

set sql_safe_updates=0;

----------------------------------------------------------------------------

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
insert into bank1 values(1001,'아무무',5000);
insert into bank2 values(2001,'티모',1000);

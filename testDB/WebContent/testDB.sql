create table test(
	a varchar(10),
	b int
);
select *from test;

create table mem(
	pk int,
	userID varchar(10),
	userPW varchar(10),
	userName varchar(20)
);

drop table mem;

insert into mem values(1,'애쉬','1234','이사과');
insert into mem values(2,'루시안','76345','정포도');
insert into mem values(3,'아리','4389898','심딸기'); /* 샘플 데이터 */

select *from mem;
select * from mem where userID='?' and userPW='?';
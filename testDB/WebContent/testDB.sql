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

insert into mem values(1,'�ֽ�','1234','�̻��');
insert into mem values(2,'��þ�','76345','������');
insert into mem values(3,'�Ƹ�','4389898','�ɵ���'); /* ���� ������ */

select *from mem;
select * from mem where userID='?' and userPW='?';
select * from all_tables;

create table board2(
	id int primary key,
	title varchar(30),
	writer varchar(15),
	content varchar(100),
	wdate date default sysdate
);

create table member2( --��� ���̺�
	id varchar(15) primary key,
	password varchar(10),
	name varchar(10),
	role varchar(15)
);

insert into member2 values('kim','a1111','��ƹ�','USER');
insert into member2 values('admin','1004','������','ADMIN');

select * from member2;
select * from board2;

insert into board2 (id,title,writer,content) values(1,'����','��ƹ�','���� ���� �޴��� ����?');

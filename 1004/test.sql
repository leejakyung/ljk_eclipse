select * from all_tables;

create table board(
	id int primary key,
	title varchar(30),
	writer varchar(15),
	content varchar(100),
	wdate date default sysdate
);

create table memmem( --��� ���̺�
	id varchar(15) primary key,
	password varchar(10),
	name varchar(10),
	role varchar(15)
);

insert into memmem values('kim','1234','�达','USER');
insert into memmem values('admin','1234','������','ADMIN');

select * from memmem;

insert into board (id,title,writer,content) values(1,'����','�达','�� ����')

select * from b;
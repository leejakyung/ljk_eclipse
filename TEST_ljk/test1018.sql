create table client2( -- ȸ������ ���̺�
	email varchar(50)  primary key,
	userID varchar(20) unique not null, -- �г���
	userPW varchar(20) not null
);

drop table client2;
select * from client2;

create table comments( -- �ڸ�Ʈ ���̺�
	cnum int primary key,
	userID varchar(20) not null,
    title varchar(15) not null,
    content varchar(50) not null,
    cdate date
);

drop table comments;

create table shoes( -- �Ź����� ���̺�
	spk varchar(30) primary key, -- �Ź� ǰ��
	filename varchar(40000) not null,
	brandname varchar(50) not null, -- �귣���
	sname varchar(50) not null, -- �Ź� �̸�
	price int not null, -- �Ź� ����
	sdate date -- �����
); 

create table mine( -- �� ���̺�
	spk varchar(30) primary key,
	email varchar(50) not null
);











insert into client2 values('timo','1234','Ƽ��');
insert into message2 values(1,'timo','����','�� �����Դϴ�',sysdate);


select * from client2;
select * from message2;

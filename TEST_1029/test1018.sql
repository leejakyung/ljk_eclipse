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
	filename varchar(500) not null,
	brandname varchar(50) not null, -- �귣���
	sname varchar(50) not null, -- �Ź� �̸�
	price int not null, -- �Ź� ����
	sdate date -- �����
); 

create table mine( -- �� ���̺�
	mpk int primary key,
	spk varchar(30) not null,
	email varchar(50) not null
);

drop table shoes;
select * from shoes;








insert into client2 values('timo0301@naver.com','Ƽ��','1234');
insert into client2 values('ljk940826@naver.com','rxlo','1234');
insert into message2 values(1,'timo','����','�� �����Դϴ�',sysdate);


select * from client2;
select * from message2;

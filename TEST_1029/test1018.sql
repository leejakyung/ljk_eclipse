create table client2( -- ȸ������ ���̺�
	email varchar(50)  primary key,
	userID varchar(20) unique not null, -- �г���
	userPW varchar(20) not null
);

drop table client2;
select * from client2;

create table comments( -- �ڸ�Ʈ ���̺�
	cnum int primary key,
	spk varchar(30),
	userID varchar(20) not null,
    -- title varchar(15) not null,
    content varchar(2000) not null,
    cdate varchar(50)
);

drop table comments;
select * from comments;

create table shoes( -- �Ź����� ���̺�
	spk varchar(30) primary key, -- �Ź� ǰ��
	filename varchar(500) not null,
	brandname varchar(50) not null, -- �귣���
	sname varchar(100) not null, -- �Ź� �̸�
	price int not null, -- �Ź� ����
	sdate varchar(50) -- �����
); 

create table mine( -- �� ���̺�
	mpk int primary key,
	spk varchar(30) not null,
	email varchar(50) not null
);

create table style(
	snum int primary key,
	spk varchar(30),
	filename varchar(500) not null,
	email varchar(50)
);

drop table style;

select * from style;
drop table shoes;
select * from shoes;
select * from shoes order by spk desc;
insert into shoes values('11','��','��','��',10000,TO_CHAR(TO_DATE('1922-10-13','YYYY-MM-DD'),'YYYY-MM-DD'));
insert into comments(cnum,spk,userID,content,cdate) values (nvl((select max(cnum) from comments),0)+1, ?, ?, ?, to_char(TO_DATE(sysdate,'YY-MM-DD'),'YYYY-MM-DD'));


update shoes set spk=12 where spk=11;
update shoes set spk='12'  where spk='11';


insert into client2 values('admin','������','1234');
insert into client2 values('timo0301@naver.com','Ƽ��','1234');
insert into client2 values('ljk940826@naver.com','rxlo','1234');
insert into message2 values(1,'timo','����','�� �����Դϴ�',sysdate);

select * from style where rownum<=3 order by snum desc;


select * from client2;
select * from mine;
delete mine where mpk = 1;

select *from shoes where spk=(select spk from mine where email='rpsejz12@naver.com');
select * from shoes inner join mine on shoes.spk = mine.spk and mine.email = 'ljk940826@naver.com';

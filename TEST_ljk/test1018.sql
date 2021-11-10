create table client2( -- 회원정보 테이블
	email varchar(50)  primary key,
	userID varchar(20) unique not null, -- 닉네임
	userPW varchar(20) not null
);

drop table client2;
select * from client2;

create table comments( -- 코멘트 테이블
	cnum int primary key,
	userID varchar(20) not null,
    title varchar(15) not null,
    content varchar(50) not null,
    cdate date
);

drop table comments;

create table shoes( -- 신발정보 테이블
	spk varchar(30) primary key, -- 신발 품번
	filename varchar(40000) not null,
	brandname varchar(50) not null, -- 브랜드명
	sname varchar(50) not null, -- 신발 이름
	price int not null, -- 신발 가격
	sdate date -- 출시일
); 

create table mine( -- 찜 테이블
	spk varchar(30) primary key,
	email varchar(50) not null
);











insert into client2 values('timo','1234','티모');
insert into message2 values(1,'timo','제목','글 내용입니다',sysdate);


select * from client2;
select * from message2;

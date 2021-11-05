create table client2( -- 회원정보 테이블
	email varchar(50)  primary key,
	userID varchar(20) unique not null, -- 닉네임
	userPW varchar(20) not null
);

drop table client2;
select * from client2;

create table comments( -- 코멘트 테이블
	cnum int primary key,
	spk varchar(30),
	userID varchar(20) not null,
    -- title varchar(15) not null,
    content varchar(2000) not null,
    cdate varchar(50)
);

drop table comments;
select * from comments;

create table shoes( -- 신발정보 테이블
	spk varchar(30) primary key, -- 신발 품번
	filename varchar(500) not null,
	brandname varchar(50) not null, -- 브랜드명
	sname varchar(100) not null, -- 신발 이름
	price int not null, -- 신발 가격
	sdate varchar(50) -- 출시일
); 

create table mine( -- 찜 테이블
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
insert into shoes values('11','ㅇ','ㅇ','ㅇ',10000,TO_CHAR(TO_DATE('1922-10-13','YYYY-MM-DD'),'YYYY-MM-DD'));
insert into comments(cnum,spk,userID,content,cdate) values (nvl((select max(cnum) from comments),0)+1, ?, ?, ?, to_char(TO_DATE(sysdate,'YY-MM-DD'),'YYYY-MM-DD'));


update shoes set spk=12 where spk=11;
update shoes set spk='12'  where spk='11';


insert into client2 values('admin','관리자','1234');
insert into client2 values('timo0301@naver.com','티모','1234');
insert into client2 values('ljk940826@naver.com','rxlo','1234');
insert into message2 values(1,'timo','제목','글 내용입니다',sysdate);

select * from style where rownum<=3 order by snum desc;


select * from client2;
select * from mine;
delete mine where mpk = 1;

select *from shoes where spk=(select spk from mine where email='rpsejz12@naver.com');
select * from shoes inner join mine on shoes.spk = mine.spk and mine.email = 'ljk940826@naver.com';

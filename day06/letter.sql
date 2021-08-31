create  table letter(
	lnum int primary key,
	writer varchar(15) not null,
	title varchar(15) not null,
	content varchar(100) not null,
	wdate date default sysdate
);

select * from letter;



insert into letter (lnum,writer,title,content,wdate) values((select nvl(max(lnum),0)+1 from letter)1,'lee','안녕','반가워요!',sysdate);
create table message(
   mnum int primary key,
    writer varchar(15) not null,
    title varchar(15) not null,
    content varchar(50) not null,
    wdate date
    -- id varchar(15)
);

insert into message values(1,'kim','Á¦¸ñ','³»¿ë',sysdate);
insert into message values(2,'lee','¾È³ç','¹Ý°¡¿ö!',sysdate);
select * from message;

create table members(
    id varchar(15) primary key,
    pw varchar(15),
    name varchar(15)
);
insert into members values('hi','1234','ÀÌÇÏ´Ã');
insert into members values('apple','12345','±è»ç°ú'); 
select * from members; 

ALTER TABLE MESSAGE
	ADD
		CONSTRAINT FK_MEMBERS_TO_MESSAGE
		FOREIGN KEY (
			id
		)
		REFERENCES MEMBERS (
			id
		);
drop table message;
drop table members;
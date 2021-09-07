drop table message;
drop table members;

create table message(
	mnum int primary key,
	userID varchar(20) not null,
    title varchar(15) not null,
    content varchar(50) not null,
    wdate date
);

select * from message;

create table members(
	userID varchar(20) primary key,
	userPW varchar(20) not null,
	name varchar(20) not null
);

select * from members;
insert into members values ('apple', 'a1234', '이사과');
insert into members values ('hi', '1', '김안녕');


-- membesr의 userID를 message의 참조키로 설정	
ALTER TABLE message
	ADD
		CONSTRAINT FK_members_TO_message
		FOREIGN KEY (
			userID
		)
		REFERENCES members (
			userID
		)
		on delete cascade;
		

	
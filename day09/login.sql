create table login(
	userID varchar(20) primary key,
	userPW varchar(20) not null
);

insert into login values ('kiwi','a1234'); 
select * from login;
drop table login;
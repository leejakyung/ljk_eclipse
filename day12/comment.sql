create table review(
	rpk int primary key,
	rid varchar(20) not null,
	rpw varchar(20) not null,
	review varchar(50) not null,
	rdate date
);

insert into review values(1,'apple','asdf','Á¤¸»Àç¹Õ´Ù!!!');

insert into review values(2,'apple','asdf','Á¤¸»Àç¹Õ´Ù!!!',sysdate);

select * from review;
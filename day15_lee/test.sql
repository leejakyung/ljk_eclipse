create table clients(
	userID varchar(20) primary key,
	upw varchar(20),
	name varchar(15),
	udate date
);

drop table clients;
create table message(
	mid int primary key,
	userID varchar(20),
	msg varchar(100),
	favcount int default 0, 
	replycount int default 0,
    mdate date
);
drop table message;
drop table clients;
drop table reply;

create table reply(
   rid int primary key,
   mid int,
   userID varchar(15),
   rdate date,
   rmsg varchar(50),
   constraint msgrp foreign key (mid) references message (mid) on delete cascade
);


insert into clients values('timo','1234','Æ¼¸ð',sysdate);
insert into message values(1,'timo','±ÛÀÛ¼º',1,2,sysdate);
insert into reply values(1,1,'timo',sysdate,'´ñ±Û1');
insert into reply values(2,1,'timo',sysdate,'´ñ±Û2');
insert into message values(2,'timo','¾å¾ß¾å',2,3,sysdate);
insert into reply values(3,2,'timo',sysdate,'´ñ±Û1');
insert into reply values(4,2,'timo',sysdate,'´ñ±Û2');
insert into reply values(5,2,'timo',sysdate,'´ñ±Û3');
insert into message values(3,'timo','È®ÀÎ',2,0,sysdate);

select * from clients;
select * from reply;
select * from message;

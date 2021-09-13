create table clients(
	userID varchar(20) primary key,
	name varchar(15),
	upw varchar(20),
	udate date
);


create table message(
	mid int primary key,
	userID varchar(20),
	msg varchar(100),
	favcount int,
	replycount int,
    mdate date
);
drop table message;

create table reply(
   rid int primary key,
   mid int,
   userID varchar(15),
   rdate date,
   rmsg varchar(50),
   constraint msgrp foreign key (mid) references message (mid) on delete cascade
);


insert into clients values('timo','Ƽ��','1234',sysdate);
insert into message values(1,'timo','���ۼ�',1,2,sysdate);
insert into reply values(1,1,'timo',sysdate,'���1');
insert into reply values(2,1,'timo',sysdate,'���2');
insert into message values(2,'timo','��߾�',2,3,sysdate);
insert into reply values(3,2,'timo',sysdate,'���1');
insert into reply values(4,2,'timo',sysdate,'���2');
insert into reply values(5,2,'timo',sysdate,'���3');
insert into message values(3,'timo','Ȯ��',2,0,sysdate);


select * from reply;
select * from message;

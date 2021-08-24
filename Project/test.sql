CREATE TABLE HG_AIR 
(
  AIR_NUM VARCHAR2(10) PRIMARY KEY NOT NULL,
  AIR_NAME VARCHAR2(10) NOT NULL,
  DEPARTURE VARCHAR2(30) NOT NULL,
  ARRIVE VARCHAR2(30) NOT NULL,
  FLIGHT_DATE VARCHAR2(20) NOT NULL,
  PRICE NUMBER NOT NULL,
  S_CNT NUMBER DEFAULT 30  -- �¼����� �⺻�� 30���� ����
);
DROP TABLE HG_AIR;
-- �������ȣ, �װ����, �����, ������, ��¥, ����, �����¼�����
insert into hg_air values ('HG1001','H-1','����','����','2021-08-02 12:30',70000, 5);
insert into hg_air values ('HG1002','H-2','����','����','2021-08-02 14:00',50000, 30);
insert into hg_air values ('HG1003','H-3','����','����','2021-08-02 21:00',20000, 30);
insert into hg_air values ('HG1004','H-4','����','����','2021-08-03 08:30',30000, 30);
insert into hg_air values ('HG1005','H-5','����','����','2021-08-03 12:00',80000, 30);
insert into hg_air values ('HG1006','H-6','����','����','2021-08-03 15:00',40000, 30);
insert into hg_air values ('HG1007','H-7','����','����','2021-08-03 20:30',30000, 30);
insert into hg_air values ('HG1008','H-8','����','����','2021-08-04 10:00',40000, 25);
insert into hg_air values ('HG1009','H-9','����','����','2021-08-04 15:30',70000, 30);
insert into hg_air values ('HG10010','H-10','����','����','2021-08-04 19:00',50000, 30);
insert into hg_air values ('HG10011','H-11','����','����','2021-08-04 21:30',20000, 30);

select air_num �������ȣ, air_name �װ����, departure �����, arrive ������, FLIGHT_DATE ��¥, price ����, s_num �¼� from hg_air order by air_num;

----------------------------------------------

CREATE TABLE MEMBER 
(
  ID VARCHAR2(10) PRIMARY KEY NOT NULL, 
  PW VARCHAR2(20) NOT NULL, 
  NAME VARCHAR2(20) NOT NULL, 
  M_POINT NUMBER DEFAULT 0   -- ���� ���ϸ��� �⺻�� 0���� ����
);
DROP TABLE MEMBER;
-- id, pw, �̸�, ���ϸ���
insert into member values ('hong', 'asdf', 'ȫ�浿', 10000);
insert into member values ('moncher', '1234', '����', 500);
insert into member values ('leon', 'leon12', '����', 7000);

-- -----------------------------------------------

create table ticket_info (
    t_num int primary key,
    id varchar2(20) not null,
    air_num varchar2(10) not null,
    payment int default 0,  -- ���� �ݾ� �⺻�� 0���� ����
    use_point int default 0  -- ��� ���ϸ��� �⺻�� 0���� ����
);
DROP TABLE TICKET_INFO;
-- HG_air�� air_num�� ticket_info�� ����Ű�� ����
ALTER TABLE ticket_info
	ADD
		CONSTRAINT FK_HG_air_TO_ticket_info
		FOREIGN KEY (
			air_num
		)
		REFERENCES HG_air (
			air_num
		);
      

-- member�� id�� ticket_info�� ����Ű�� ����	  
ALTER TABLE ticket_info
	ADD
		CONSTRAINT FK_member_TO_ticket_info
		FOREIGN KEY (
			id
		)
		REFERENCES member (
			id
		);

-- Ƽ�Ϲ�ȣ, id, �װ����ȣ, �����ݾ�, ��븶�ϸ���
insert into ticket_info values (1, 'hong', 'HG1001', 50000, 20000);
insert into ticket_info (t_num, id, air_num, payment) values (4, 'moncher', 'HG1010', 50000);  -- ���ϸ��� ���X -> �⺻�� 0���� �ڵ� ������


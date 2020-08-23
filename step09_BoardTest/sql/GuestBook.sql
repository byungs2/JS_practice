drop table gbook;
drop sequence seq_gbook;

create table gbook (
	num number not null,
	title varchar2(50) not null,
	author varchar2(50) not null,
	email varchar2(50) not null,
	content long,
	password varchar2(20) not null,
	writeday date not null,
	readnum number
);
CREATE SEQUENCE seq_gbook START WITH 1 INCREMENT BY 1 ; 

commit;

create database if not exists SSAFYBOARD;
use SSAFYBOARD;

drop table if exists BOARD;

create table BOARD{
	NO int not null primary key auto_increment,
	TITLE varchar(30) not null,
	CONTENT text not null,
	WRITER varchar(10) not null,
	REGDATE timestamp not null
};

insert into BOARD (TITLE, CONTENT, WRITER, REGDATE)
values ("제목-1", "내용-1","작성자-1", now());
insert into BOARD (TITLE, CONTENT, WRITER, REGDATE)
values ("제목-2", "내용-2","작성자-2", now());
insert into BOARD (TITLE, CONTENT, WRITER, REGDATE)
values ("제목-3", "내용-3","작성자-3", now());
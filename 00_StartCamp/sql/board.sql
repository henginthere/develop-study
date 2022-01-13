CREATE DATABASE IF NOT EXISTS SSAFY;

USE SSAFY;

DROP TABLE IF EXISTS BOARD;

CREATE TABLE BOARD(
	NO			INT NOT NULL 	PRIMARY KEY AUTO_INCREMENT,
	TITLE		VARCHAR(30) 	NOT NULL,
	CONTENT 	VARCHAR(255)	NULL,
	WRITER  	VARCHAR(10) 	NOT NULL,
	REGDATE		TIMESTAMP		NOT NULL,
	MODIDATE 	TIMESTAMP
);

INSERT INTO BOARD (title, content, writer, regdate, modidate)
	VALUES ('제목-1', '내용-1', '작성자-1', STR_TO_DATE('26-01-2018','%d-%m-%Y'), NULL);
INSERT INTO BOARD (title, content, writer, regdate, modidate)
	VALUES ('제목-2', '내용-2', '작성자-2', STR_TO_DATE('26-01-2018','%d-%m-%Y'), NULL);
INSERT INTO BOARD (title, content, writer, regdate, modidate)
	VALUES ('제목-3', '내용-3', '작성자-3', STR_TO_DATE('26-01-2018','%d-%m-%Y'), NULL);
	
SELECT * FROM BOARD;


INSERT INTO board (title, content, writer, regdate, modidate)
VALUES ('제목-4', '내용-4', '작성자-4', NOW(), NULL);
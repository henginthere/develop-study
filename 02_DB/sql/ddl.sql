DROP DATABASE IF EXISTS empdept;

CREATE DATABASE empdept;

USE empdept;

DROP TABLE IF EXISTS emp;
DROP TABLE IF EXISTS dept;
DROP TABLE IF EXISTS test;

CREATE TABLE dept(
  deptno INT(2),
  dname  VARCHAR(14),
  loc    VARCHAR(13),
  CONSTRAINT pk_dept PRIMARY KEY (deptno)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
CREATE TABLE emp(
  empno    INT(4),
  ename    VARCHAR(10),
  job      VARCHAR(10),
  mgr      INT(4),
  hiredate DATE,
  sal      DECIMAL(7,2),
  comm     DECIMAL(7,2),
  deptno   INT(2),
  CONSTRAINT pk_emp PRIMARY KEY (empno),
  CONSTRAINT fk_deptno FOREIGN KEY (deptno) REFERENCES dept (deptno)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
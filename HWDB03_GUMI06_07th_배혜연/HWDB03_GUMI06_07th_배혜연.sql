#1
SELECT emp.ename "이름" , emp.job "업무", emp.sal "급여"
from emp
where emp.deptno=
				 (select deptno 
				  from dept 
				  where loc="chicago");

#2
select empno, ename, job, deptno
from emp
where empno not in( select a.empno
					from emp a join emp b
					on a.empno=b.mgr) ;

#3
select ename, job, mgr
from emp
where mgr=
		  (select mgr 
           from emp 
           where ename="blake");
           
#4
select ename
from emp
order by hiredate limit 5;

#5
select emp.ename "이름", emp.job "업무", dept.dname"부서명"
from emp emp join dept dept
on emp.deptno=dept.deptno
where emp.mgr=(select empno
from emp
where ename="jones") ;
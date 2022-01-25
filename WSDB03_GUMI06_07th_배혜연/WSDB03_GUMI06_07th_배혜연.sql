use world;

#1
select a.code, a.name
from country a join city b
where b.name like "%kabul%"
and a.code=b.countrycode;

#2
select a.name, b.language, b.percentage
from country a join countrylanguage b
where b.percentage=100 and b.isofficial = true
and a.code=b.countrycode
order by a.name;

#3
select a.name, b.language, c.name
from city a join countrylanguage b join country c
on a.name="Amsterdam" and a.countrycode=b.countrycode and b.isofficial = true
and a.countrycode = c.code;

#4
select country.name, country.capital, city.name "수도", city.population "수도인구"
from country country join city city
where country.name like "united%" and country.capital is not null and city.id=country.capital;

#5
select country.name, country.capital, ifnull(city.name,"수도없음") "수도", ifnull(city.population,"수도없음") "수도인구"
from (
select country.name, country.capital
from country country
where country.name like "united%") country left outer join city city
on city.id=country.capital;

#6
select distinct count(*) "국가수"
from countrylanguage countrylanguage
where countrylanguage.isofficial=true and countrylanguage.percentage >
(select max(countrylanguage.percentage)
from countrylanguage countrylanguage
where countrylanguage.countrycode="che" and countrylanguage.isofficial = true);

#7
select countrylanguage.language
from countrylanguage countrylanguage join country country
on countrylanguage.isofficial=true and countrylanguage.countrycode = country.code
where country.name="south korea";

#8
select country.name, country.code, count(*) "도시개수"
from country country join city city
on country.code = city.countrycode
where country.name like "bo%"
group by country.code;

#9
select country.name, country.code, 
case when count(city.countrycode) =0 then "단독"
else count(city.countrycode) 
end "도시개수"
from country country left outer join city city
on country.code = city.countrycode
where country.name like "bo%"
group by country.code;

#10
select countrycode, name, population
from city
where population = (select max(population)
					from city);
                    
#11
select country.name, city.countrycode, city.name, city.population
from ( select *
		from city
		where population = (select min(population) from city) ) city join country
on city.countrycode = country.code;

#12
select city.countrycode, city.name, city.population
from city city
where population > 
(select population
from city
where city.countrycode="kor" and city.name="seoul");

#13
select countrylanguage.countrycode, countrylanguage.language
from countrylanguage countrylanguage join (select * from city where name="san miguel") city
on countrylanguage.countrycode = city.countrycode
where countrylanguage.isofficial = true;

#14
select city.countrycode, max(city.population) "population"
from city city, country country
where city.countrycode = country.code
group by city.countrycode
order by city.countrycode;

#15
select city.countrycode, city.name, max(city.population) "population"
from city city, country country
where city.countrycode = country.code
group by city.countrycode
order by city.countrycode;

#16
select country.code , country.name, city.name, max(city.population) "population"
from country left outer join city
on country.code = city.countrycode
group by country.code
order by country.code;

#17
create view summary as
select country.code "code" , country.name "co_name" , city.name "ci_name" , max(city.population) "population"
from country left outer join city
on country.code = city.countrycode
group by country.code
order by country.code;

#18
select code, co_name, ci_name, population
from summary
where code="kor";


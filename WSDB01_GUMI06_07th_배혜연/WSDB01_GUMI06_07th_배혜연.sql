# 1. 
use world;

# 2.
desc city;
desc country;
desc countrylanguage;

# 3.
select * from country where code="KOR";

#4.
select * from country where (gnp-gnpold > 0) order by (gnp-gnpold);

#5
select distinct continent from country order by char_length(continent);

#6
select concat(name, '은 ', region, '에 속하며 인구는 ', population,'명이다.') '정보' from country where continent='asia';

#7
select * from country where indepyear is null and population>=10000 order by population;

#8
select * from country where population between 100000000 and 200000000 order by population desc limit 3;

#9
select * from country where indepyear in(800,1810,1811,1901) order by indepyear, code desc;

#10
select * from country where region like '%asia%' and name like '_o%';

#11
select char_length('홍길동') '한글', char_length('hong') '영문';

#12
select * from country where governmentform like '%public%' and char_length(name)>=10 order by char_length(name) desc limit 10;

#13
select * from country where code regexp '^[AEIOU]' order by name limit 2,3;

#14
select name, concat(rpad(left(name,2), char_length(name)-2,"*") ,right(name,2)) 'guess' 
from country;

#15
select distinct replace(region, ' ', '_') '지역들' from country order by char_length(region);

#16
select name, surfacearea, population,round((surfacearea/population),3)'1인당 점유면적' 
from country where population >= 100000000 order by (surfacearea/population);

#17
select curdate() '오늘', dayofyear(curdate()) '올해 지난 날', date_add(curdate(), interval 100 day) '100일 후';

#18
select name, continent, lifeexpectancy,
	case when lifeexpectancy > 80 then '장수국가'
		 when lifeexpectancy > 60 then '일반국가'
         else '단명국가'
	end '구분'
from country
where continent='asia' and lifeexpectancy is not null
order by lifeexpectancy;

#19
select name, gnp, gnpold,
	case when gnpold is not null then (gnp-gnpold)
		 else '신규'
	end 'gnp 향상'
from country
order by name;

#20
select weekday('2020-05-05'),
	case when weekday('2020-05-05') in (0,1,2,3,4) then '행복'
		 else '불행'
    end '행복여부';
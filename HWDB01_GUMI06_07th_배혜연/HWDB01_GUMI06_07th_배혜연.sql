create database manage;
use manage;

#상품정보 테이블
create table products (
	_code int(5),
    _name char(10),
    _price int(10),
    primary key(_code)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#상품데이터 5개 저장
insert into products values(12345, 'TV', 1000000);
insert into products values(23456, '냉장고', 700000);
insert into products values(34567, '세탁기', 200000);
insert into products values(45678, '에어프라이기', 50000);
insert into products values(56789, '스타일러', 2000000);

select * from products;

#15% 인하 가격 정보
select _code, _name, _price, round(_price*0.85) '세일가' from products;

#TV 관련 상품 가격 20% 인하, 저장
update products set _price=round(_price*0.8) where _name like '%TV%';
select * from products;
commit;
select * from products;

#저장된 상품 가격의 총 금액
select sum(_price) '상품총액' from products;


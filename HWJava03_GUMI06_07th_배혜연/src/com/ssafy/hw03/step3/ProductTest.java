package com.ssafy.hw03.step3;

import com.ssafy.hw03.step3.Tv;
import com.ssafy.hw03.step3.Refrigerator;
import com.ssafy.hw03.step3.Product;

public class ProductTest {

	public static void main(String[] args) {
		
		ProductMgr mg = new ProductMgr();
		
		Tv tv1 = new Tv("12345", "TV1", 500000, 5, 32, "OLED");
		Tv tv2 = new Tv("23415", "TV2", 8000000, 8, 65, "QLED");
		Tv tv3 = new Tv("12534", "TV3", 2000000, 1, 75, "OLED");
		Refrigerator rf1 = new Refrigerator("44256", "RF1", 1600000, 3, 600);
		Refrigerator rf2 = new Refrigerator("45258", "RF2", 800000, 5, 815);
		
		mg.add(tv1);
		mg.add(tv2);
		mg.add(tv3);
		mg.add(rf1);
		mg.add(rf2);
		
		System.out.println("***************************상품 전체 정보***************************");
		for(Product p:mg.viewAll()) {
			System.out.println(p);
		}
		
		System.out.println("***************************상품 번호로 검색: 12534 ***************************");
		
		System.out.println(mg.searchbypNum("12534"));
		
		System.out.println("***************************상품명으로 검색: RF ***************************");

		for(Product p:mg.searchbyName("RF")) {
			System.out.println(p);
		}
		
		System.out.println("***************************TV만 검색 ***************************");

		for(Product p:mg.searchTV()) {
			System.out.println(p);
		}
		
		System.out.println("***************************Refrigerator만 검색 ***************************");

		for(Product p:mg.searchRF()) {
			System.out.println(p);
		}
		
		System.out.println("***************************400L이상 Refrigerator만 검색 ***************************");

		for(Product p:mg.searchOver400()) {
			System.out.println(p);
		}
		System.out.println("***************************50inch이상 TV만 검색 ***************************");

		for(Product p:mg.searchOver50()) {
			System.out.println(p);
		}
		
		System.out.println("***************************12345번 상품 가격수정:450000원 ***************************");

		mg.changePrice("12345", 450000);
		System.out.println(mg.searchbypNum("12345"));
		
//		System.out.println("***************************12345번 상품 삭제 ***************************");
//
//		mg.remove("12345");
//		
		
		System.out.println("상품 재고 가격 총합 : "+mg.getTotalPrice());
		
		
	}
}

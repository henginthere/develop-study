package com.ssafy.hw03.step3;

import java.util.ArrayList;
import java.util.Iterator;

import com.ssafy.hw03.step3.Product;
import com.ssafy.hw03.step3.Tv;
import com.ssafy.hw03.step3.Refrigerator;




public class ProductMgr {
;
	private ArrayList<Product> products = new ArrayList<>();
	public ProductMgr() {}
	
	//상품 추가
	public void add(Product product) {
		products.add(product);
	}
	
	//상품 전체 검색
	public ArrayList<Product> viewAll() {
		return products;
	}
	
	//상품 번호로 검색
	public Product searchbypNum(String pNum) {
		Product tmp = new Product();
		for(Product p : products) {
			if(p.getpNum().equals(pNum)) {
				tmp = p;
			}
		}
		return tmp;
	}
	
	//상품명으로 검색(부분검색가능)
	public ArrayList<Product> searchbyName(String name) {
		ArrayList<Product> tmp = new ArrayList<>();
		for(Product p : products) {
			if(p.getName().contains(name)) {
				tmp.add(p);
			}
		}
		return tmp;
	}
	
	//TV 정보만 검색
	public ArrayList<Product> searchTV() {
		ArrayList<Product> tmp = new ArrayList<>();
		for(Product p : products) {
			if(p instanceof Tv) {
				tmp.add(p);
			}
		}
		return tmp;
	}
	
	//Refrigerator만 검색
	public ArrayList<Product> searchRF() {
		ArrayList<Product> tmp = new ArrayList<>();
		for(Product p : products) {
			if(p instanceof Refrigerator) {
				tmp.add(p);
			}
		}
		return tmp;
	}
	//400L이상의 Refrigerator 검색
	public ArrayList<Product> searchOver400() {
		ArrayList<Product> tmp = new ArrayList<>();
		for(Product p : products) {
			if(p instanceof Refrigerator) {
				if(((Refrigerator) p).getLiter()>=400) {
					tmp.add(p);
				}
			}
		}
		return tmp;
	}
	
	//50inch 이상의 TV검색
	public ArrayList<Product> searchOver50(){
		ArrayList<Product> tmp = new ArrayList<>();
		for(Product p : products) {
			if(p instanceof Tv) {
				if(((Tv) p).getInch()>=50) {
					tmp.add(p);
				}
			}
		}
		return tmp;
	}
	//상품 번호와 가격 입력받아 상품 가격 변경
	public void changePrice(String pNum, int price) {
		for(Product p : products) {
			if(p.getpNum().equals(pNum)) {
				p.setPrice(price);
			}
		}
	}
	//상품 번호로 삭제
	public void remove(String pNum) {
		for(Product p : products) {
			if(p.getpNum().equals(pNum)) {
				products.remove(p);
			}
		}
		
	}
	
	//전체 재고 상품 금액
	public int getTotalPrice() {
		

		int sum=0; 
		for(Product p:products) {
			sum+=p.getPrice();
		}
		return sum;
	}

	
}

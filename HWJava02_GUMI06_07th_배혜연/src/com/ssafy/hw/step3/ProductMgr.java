package com.ssafy.hw.step3;

import com.ssafy.hw.step3.Product;
import com.ssafy.hw.step3.Tv;
import com.ssafy.hw.step3.Refrigerator;;




public class ProductMgr {
	
	int MAX_SIZE=100; //도서정보는 최대 100권을 넘지 않는다.
	int size=0;
	Product[] products = new Product[MAX_SIZE];
	
	public ProductMgr() {}
	
	//상품 추가
	public void add(Product product) {
		
		products[size++]=product;		
	}
	
	//상품 전체 검색
	public Product[] viewAll() {
		Product[] temp=new Product[size];
		
		for(int i=0;i<size;i++) {
			if(products[i]!=null) {
			temp[i]=products[i];
			}
		}
		return temp;
	}
	
	//상품 번호로 검색
	public Product searchbypNum(String pNum) {
		for(int i=0;i<size;i++) {
			if(products[i].getpNum().equals(pNum)) {
				return(products[i]);
			}
		} return null;
	}
	
	//상품명으로 검색
	public Product[] searchbyName(String name) {
		int count=0; 
		Product[] temp = new Product[size];
		for(int i=0;i<size;i++) { 
			if(products[i].getName().contains(name)) {
				temp[count++] = products[i];
				}
			}
		Product[] result = new Product[count];
		for(int i=0;i<count;i++)
			result[i]=temp[i];
		return result; 
	}
	
	//TV 정보만 검색
	public Product[] searchTV() {
		int count=0;
		Product[] temp = new Product[size];
		for(int i=0;i<size;i++) {
			if(products[i] instanceof Tv) { //magazine이 아닌 객체를 가져와야 일반책 객체만 가져올 수 있음(magazine은 book이면서 magazine이기때문)
				temp[count++]=products[i];
			}
		}
		Product[] result = new Product[count];
		for(int i=0;i<count;i++) {
			result[i]=temp[i];
		}
		return result;
	}
	
	//Refrigerator만 검색
	public Product[] searchRF() {
		int count=0;
		Product[] temp = new Product[size];
		for(int i=0;i<size;i++) {
			if(products[i] instanceof Refrigerator) { //magazine이 아닌 객체를 가져와야 일반책 객체만 가져올 수 있음(magazine은 book이면서 magazine이기때문)
				temp[count++]=products[i];
			}
		}
		Product[] result = new Product[count];
		for(int i=0;i<count;i++) {
			result[i]=temp[i];
		}
		return result;
	}
	
	//상품 번호로 삭제
	public void remove(String pNum) {
		Product[] result = new Product[size];
		int resultIndex=-1;
		for(int i=0;i<products.length;i++) {
			if(products[i].getpNum().equals(pNum)) {
				continue;
			}
			result[++resultIndex]=products[i];
		}
		this.products = result;
		this.size = resultIndex;
	}
	
	//전체 재고 상품 금액
	public int getTotalPrice() {
		int sum=0; 
		for(int i=0;i<size;i++) {
			sum+=(products[i].getPrice());
		}
		return sum;
	}

	
}

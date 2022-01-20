package com.ssafy.hw04.step3;

import com.ssafy.hw04.step3.Tv;
import com.ssafy.hw04.step3.Refrigerator;
import com.ssafy.hw04.step3.Product;

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
		
		mg.saveData();
		
		
		
	}
}

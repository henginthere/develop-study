package com.ssafy.day03.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MapTestDrive {
	public static void main(String[] args) {
		/*
		 * HashMap 사용법
		 */

		// HashMap 선언 및 초기화
		Map<String, String> hashMap = new HashMap<String, String>();

		// HashMap에 객체 저장
		hashMap.put("city", "seoul");
		hashMap.put("country", "korea");
		hashMap.put("zipcode", "32457");
		hashMap.put("country2", "korea");

		// 반복문 1: Iterator 활용
		System.out.println("*** HashMap - Iterator 활용 ***");
		Iterator<String> keys1 = hashMap.keySet().iterator();
		while (keys1.hasNext()) {
			String key = keys1.next();
			System.out.println("key: " + key + " / " + "value: " + hashMap.get(key));
		}

		// 반복문 2: entrySet 활용
		System.out.println("*** HashMap - entrySet 활용 ***");
		for (Map.Entry<String, String> element : hashMap.entrySet()) {
			System.out.println("key: " + element.getKey() + " / " + "value: " + element.getValue());
		}

		// 반복문 3: for each 문
		System.out.println("*** HashMap - for each 문 ***");
		for (String key : hashMap.keySet()) {
			System.out.println("key: " + key + " / " + "value: " + hashMap.get(key));
		}

		/*
		 * Hashtable 사용법
		 */

		// Hashtable 선언 및 초기화
		Map<String, String> hashtable = new Hashtable<String, String>();

		// Hashtable에 객체 저장
		hashtable.put("city", "seoul");
		hashtable.put("country", "korea");
		hashtable.put("zipcode", "32457");
		hashtable.put("country2", "korea");

		// 반복문 1: Iterator 활용
		System.out.println("*** Hashtable - Iterator 활용 ***");
		Iterator<String> keys2 = hashtable.keySet().iterator();
		while (keys2.hasNext()) {
			String key = keys2.next();
			System.out.println("key: " + key + " / " + "value: " + hashtable.get(key));
		}

		// 반복문 2: entrySet 활용
		System.out.println("*** Hashtable - entrySet 활용 ***");
		for (Map.Entry<String, String> element : hashtable.entrySet()) {
			System.out.println("key: " + element.getKey() + " / " + "value: " + element.getValue());
		}

		// 반복문 3: for each 문
		System.out.println("*** Hashtable - for each 문 ***");
		for (String key : hashtable.keySet()) {
			System.out.println("key: " + key + " / " + "value: " + hashtable.get(key));
		}

		/*
		 * TreeMap 사용법
		 */

		// TreeMap 선언 및 초기화
		Map<String, String> treeMap = new TreeMap<String, String>();

		// TreeMap에 객체 저장
		treeMap.put("city", "seoul");
		treeMap.put("country", "korea");
		treeMap.put("zipcode", "32457");
		treeMap.put("country2", "korea");

		// 반복문 1: Iterator 활용
		System.out.println("*** TreeMap - Iterator 활용 ***");
		Iterator<String> keys3 = treeMap.keySet().iterator();
		while (keys3.hasNext()) {
			String key = keys3.next();
			System.out.println("key: " + key + " / " + "value: " + treeMap.get(key));
		}

		// 반복문 2: entrySet 활용
		System.out.println("*** TreeMap - entrySet 활용 ***");
		for (Map.Entry<String, String> element : treeMap.entrySet()) {
			System.out.println("key: " + element.getKey() + " / " + "value: " + element.getValue());
		}

		// 반복문 3: for each 문
		System.out.println("*** TreeMap - for each 문 ***");
		for (String key : treeMap.keySet()) {
			System.out.println("key: " + key + " / " + "value: " + treeMap.get(key));
		}
	}
}

package com.ssafy.day03.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListTestDrive {
	public static void main(String[] args) {
		/*
		 * List 사용법
		 */

		// List 선언 및 초기화
		List<String> list = new ArrayList<String>();
		//List<String> list = new LinkedList<String>();
		//List<String> list = new Vector<String>();

		// List에 객체 저장
		list.add("inchon");
		list.add("pusan");
		list.add("seoul");
		list.add("kwangju");
		list.add("seoul");

		// 정렬하기
		Collections.sort(list); //오름차순 정렬
		//Collections.reverse(list);	// 현재 리스트에 저장된 객체 순서를 뒤집는다.

		// 반복문 1: Iterator 활용
		System.out.println("*** List - Iterator 활용 ***");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next);
		}

		// 반복문 2: for each 문
		System.out.println("*** List - for each 문 ***");
		for (String string : list) {
			System.out.println(string);
		}

		// 반복문 3: for 문
		System.out.println("*** List - for 문 ***");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}

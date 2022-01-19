package com.ssafy.day03.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetTestDrive {
	public static void main(String[] args) {

		/*
		 * HashSet 사용법
		 */

		// HashSet 선언 및 초기화
		Set<String> hashSet = new HashSet<String>();

		// HashSet에 객체 저장
		hashSet.add("inchon");
		hashSet.add("pusan");
		hashSet.add("seoul");
		hashSet.add("kwangju");
		hashSet.add("seoul");

		// 반복문 1: Iterator 활용
		System.out.println("*** HashSet - Iterator 활용 ***");
		Iterator<String> iterator1 = hashSet.iterator();
		while (iterator1.hasNext()) {
			String next = iterator1.next();
			System.out.println(next);
		}

		// 반복문 2: for each 문
		System.out.println("*** HashSet - for each 문 ***");
		for (String string : hashSet) {
			System.out.println(string);
		}

		/*
		 * TreeSet 사용법
		 */

		// TreeSet 선언 및 초기화
		Set<String> treeSet = new TreeSet<String>();

		// HashSet에 객체 저장
		treeSet.add("inchon");
		treeSet.add("pusan");
		treeSet.add("seoul");
		treeSet.add("kwangju");
		treeSet.add("seoul");

		// 반복문 1: Iterator 활용
		System.out.println("*** TreeSet - Iterator 활용 ***");
		Iterator<String> iterator2 = treeSet.iterator();
		while (iterator2.hasNext()) {
			String next = iterator2.next();
			System.out.println(next);
		}

		// 반복문 2: for each 문
		System.out.println("*** TreeSet - for each 문 ***");
		for (String string : treeSet) {
			System.out.println(string);
		}
	}
}

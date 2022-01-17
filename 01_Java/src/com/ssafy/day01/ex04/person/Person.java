package com.ssafy.day01.ex04.person;

public class Person {
    String name;
    String gender;
    int age;
    
    // Default Constructor를 생략한 것이다.
    // 기본 생성자: argument가 없는 생성자
    Person() {}
    
    Person(String name, String gender, int age){ //return 타입 없음
    	this.name=name;
    	this.gender=gender;
    	this.age=age;
    }
    void walk() {
        System.out.println(name + " 걷기");
        return;
    }
    
    void order() {
        System.out.println(name + " 주문하기");
        return;
    }
    
    void eat() {
        System.out.println(name + " 냠냠");
        return;
    }
}

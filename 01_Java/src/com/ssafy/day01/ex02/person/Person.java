package com.ssafy.day01.ex02.person;

public class Person {
    String name;
    String gender;
    int age;
    
    // 1. 필드를 초기화하는 생성자 만들기
    Person(String _name, String _gender, int _age){ //return 타입 없음
    	name=_name;
    	gender=_gender;
    	age=_age;
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

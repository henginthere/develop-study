package com.ssafy.day01.ex02.person;

public class PersonTest {
    public static void main(String[] args) {
    	
    	// 1. 클래스와 생성자를 활용하여 사람 객체를 만들기 ("정모씨", "남", 37)
        Person p = new Person("정모씨","남",37);
        // 2. 객체에 저장한 속성(필드)들을 출력해보자
    	System.out.println(p.name);
    	System.out.println(p.gender);
    	System.out.println(p.age);
    	// 3. 객체에 작성한 기능(메서드)들을 호출해보자
    	p.walk();
    	p.order();
    	p.eat();
    	// 4. 1 ~ 3번 과정을 거쳐서 ("김싸피", "여", 24) 속성을 가지는 사람을 만들어보자
    	
    }
}

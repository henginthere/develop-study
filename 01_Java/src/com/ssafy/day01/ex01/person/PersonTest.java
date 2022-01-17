package com.ssafy.day01.ex01.person;

public class PersonTest {
    public static void main(String[] args) {
    	
    	// 1. 클래스를 활용하여 사람 객체를 만들기
    	Person hyeyeon = new Person();
    	// 2. 1번에서 만든 객체를 초기화 하기 ("정모씨", "남", 37)
    	hyeyeon.name="배혜연";
    	hyeyeon.gender = "여";
    	hyeyeon.age=25;
        // 3. 객체에 저장한 속성(필드)들을 출력해보자
    	System.out.println(hyeyeon.name);
    	// 4. 객체에 작성한 기능(메서드)들을 호출해보자
    	hyeyeon.walk();
    	hyeyeon.order();
    	hyeyeon.eat();
    	// 5. 1 ~ 4번 과정을 거쳐서 ("김싸피", "여", 24) 속성을 가지는 사람을 만들어보자
    	
    }
}

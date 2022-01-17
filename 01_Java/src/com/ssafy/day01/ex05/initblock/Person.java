package com.ssafy.day01.ex05.initblock;

public class Person {
    String name;
    String gender;
    int age;
    
    // static initialize block
    static {
    	System.out.println("call static initialize block !!");
    }
    
    // instance initialize block
    {
    	System.out.println("call instance initialize block");
    }
    
    public Person(String name, String gender, int age) {
    	System.out.println("call constructor !!");
    	
		this.name = name;
		this.gender = gender;
		this.age = age;
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

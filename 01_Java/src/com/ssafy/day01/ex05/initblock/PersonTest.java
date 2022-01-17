package com.ssafy.day01.ex05.initblock;

public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person("정모씨", "남", 37);
        System.out.printf("name: %s, gender: %s, age: %d%n", person1.name , person1.gender, person1.age);
        person1.walk();
        person1.order();
        person1.eat();

        Person person2 = new Person("김싸피", "여", 24);
        System.out.printf("name: %s, gender: %s, age: %d%n", person2.name , person2.gender, person2.age);
        person2.walk();
        person2.order();
        person2.eat();
    }
}

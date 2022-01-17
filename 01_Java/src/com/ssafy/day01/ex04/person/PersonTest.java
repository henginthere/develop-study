package com.ssafy.day01.ex04.person;

public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.name = "정모씨";
        person1.gender = "남";
        person1.age = 37;
        System.out.printf("name: %s, gender: %s, age: %d%n", person1.name , person1.gender, person1.age);
        person1.walk();
        person1.order();
        person1.eat();

        Person person2 = new Person();
        person2.name = "김싸피";
        person2.gender = "녀";
        person2.age = 24;
        System.out.printf("name: %s, gender: %s, age: %d%n", person2.name , person2.gender, person2.age);
        person2.walk();
        person2.order();
        person2.eat();
    }
}

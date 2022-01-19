package com.ssafy.day03.excep;

import java.util.Random;

public class ExceptionHandlingFlow1 {
    public static void main(String[] args) {
        int num = new Random().nextInt(2);
        try {
            System.out.println("code 1, num: " + num);
            int i = 1 / num;
            System.out.println("code 2 - 예외 없음");
            return;
        } catch (ArithmeticException e) {
            System.out.println("code 3 - 예외 처리 완료");
        }
        System.out.println("code 4");
    }
}



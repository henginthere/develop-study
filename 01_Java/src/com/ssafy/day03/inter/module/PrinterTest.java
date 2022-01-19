package com.ssafy.day03.inter.module;

public class PrinterTest {
    
    public static void main(String[] args) {
        PrintClient client = new PrintClient();
        client.setPrinter(new DotPrinter());
        // TODO: client가 LazerPrinter를 사용하도록 하고 클래스의 변화를 확인하시오.
        // END:
        client.printThis("myfile");

        
    }
}

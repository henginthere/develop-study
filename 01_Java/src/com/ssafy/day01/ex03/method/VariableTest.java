package com.ssafy.day01.ex03.method;

public class VariableTest {
    public static void main(String[] args) {
        VariableTest vt = new VariableTest();
        vt.variableArgs(1, 2, 3);
        vt.variableArgs(1, 2, 3, 4, 5);
        vt.variableArgs(1, 2);
    }

    public void variableArgs(int... params) {
        int sum = 0;
        for (int i : params) {
            sum += i;
        }
        System.out.println(sum);
    }

}

package com.ssafy.day03.collection.generics.wild;

import com.ssafy.day03.collection.generics.box.GenericBox;

public class UseWildCardTest3 {

    // 넘겨받은 gbox는 어떤 기반으로 만들어져있을까?
    public static void useGenericList(GenericBox<?> box) {
        System.out.println(box.hashCode());
        System.out.println(box.getSome());
        //box.setSome(100);
        //box.setSome("Hello");
    }

    public static void main(String[] args) {
        GenericBox<Integer> l1 = new GenericBox<>();
        l1.setSome(100);
        useGenericList(l1);

        GenericBox<String> l2 = new GenericBox<>();
        l2.setSome("Hello");
        useGenericList(l2);
    }
}

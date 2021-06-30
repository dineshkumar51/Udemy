package com.collections;

import java.util.Iterator;
import java.util.TreeSet;

public class Test {


    public static void main(String[] args) {
        TreeSet<Integer> tree = new TreeSet<>();

        tree.add(5);
        tree.add(10);
        tree.add(5);

        Iterator itr = tree.descendingIterator();

        while(itr.hasNext())
        {

        }

        System.out.println(tree);



    }
}

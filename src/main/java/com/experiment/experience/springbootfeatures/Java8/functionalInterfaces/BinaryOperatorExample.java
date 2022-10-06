package com.experiment.experience.springbootfeatures.Java8.functionalInterfaces;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.function.BinaryOperator;
//This as Bi Functional Interface but accepts 2 parameters and same return type and consists 2 static methods max and min which takes comparator reference and do comparison based on that
@Slf4j
public class BinaryOperatorExample {
    static BinaryOperator<Integer> multiple=(i,j)->i*j;

    static Comparator<Integer>   comparator=(a,b)->a.compareTo(b);

    public static void main(String[] args) {
        System.out.println(multiple.apply(2,3));
        System.out.println(BinaryOperator.maxBy(comparator).apply(1,7));
        System.out.println(BinaryOperator.minBy(comparator).apply(7,77));
    }



}

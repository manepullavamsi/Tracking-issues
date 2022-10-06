package com.experiment.experience.springbootfeatures.Java8.functionalInterfaces;

import lombok.extern.slf4j.Slf4j;

import java.util.function.UnaryOperator;
//This is similar to Function but here return also same as where input parameter, and it extends Functional Interface
@Slf4j
public class UnaryOperatorExample {
    static UnaryOperator<Integer> unaryMultiple=a->a*a;
    public static void main(String[] args) {
        System.out.println("Unary Operator Example"+unaryMultiple.apply(7));
    }
}

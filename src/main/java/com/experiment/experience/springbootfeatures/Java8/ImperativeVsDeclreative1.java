package com.experiment.experience.springbootfeatures.Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImperativeVsDeclreative1 {

    public static void main(String[] args) {
        /*
        Calaculate sum of Integers from 1 - 100
        * Imperative way of writing code
        * */
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        log.info("Sum of 1-100 : " + sum);
        /*
        Calaculate sum of Integers from 1 - 100
        * Declrative way of writing code by JAva8
        * */
        int sumStream = IntStream.rangeClosed(1, 100).sum();
        log.info("Sum of 1-100 by sumStream: " + sumStream);

        /*
        Remove duplicates from List
        * Imperative way of writing code by JAva8
        * */
        List<Integer> duplicateList = Arrays.asList(1, 2, 3, 3, 4, 5, 6, 7, 7);
        List<Integer> uniqueList = new ArrayList<>();
        for (Integer i : duplicateList) {
            if (!uniqueList.contains(i)) uniqueList.add(i);
        }
        log.info("Imperative Approach" + uniqueList);

        /*
        Remove duplicates from List
        * Declrative way of writing code by JAva8
        * */
        List<Integer> duplicateList1 = Arrays.asList(1, 2, 3, 3, 4, 5, 6, 7, 7);
        List<Integer> uniqueList1 = duplicateList1.stream().distinct().collect(Collectors.toList());
        log.info("Declrative Approach" + uniqueList1);
    }
}

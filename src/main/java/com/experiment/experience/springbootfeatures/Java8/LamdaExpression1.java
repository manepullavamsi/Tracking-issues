package com.experiment.experience.springbootfeatures.Java8;

import java.util.Comparator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LamdaExpression1 {
    public static void main(String[] args) {

        /*
         * Tradiationl approach of  Functional Interface
         * Runnable Interface consist of run method
         * */

        Runnable runnable =
                new Runnable() {
                    @Override
                    public void run() {
                        log.info("Traditional Runnable Interface");
                    }
                };
        new Thread(runnable).start();

        /*
         * Lamda approach of functional Interface
         * Runnable Interface consist of run method
         * */

        Runnable runnable1 =
                () -> {
                    log.info("Runnable Interface inside Lambda Interface");
                };

        new Thread(runnable1).start();

        /*
                 * Lamdba Expression while using Comprator
                 * Compares two int values numerically. The value returned is identical to what would be returned by:
             Integer.valueOf(x).compareTo(Integer.valueOf(y))

        Params:
        x – the first int to compare y – the second int to compare
        Returns:
        the value 0 if x == y; a value less than 0 if x < y; and a value greater than 0 if x > y
                 * */

        Comparator<Integer> comprator =
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1.compareTo(o2);
                    }
                };

        log.info("Tradtional Approach:  " + comprator.compare(3, 2));

        /*
         *Lamda Expression usage with Comparator
         *  */

        Comparator<Integer> comparator = (a, b) -> a.compareTo(b);

        log.info("Lamda Expression for Comparator: " + comparator.compare(3, 4));
        log.info("Lamda Expression for Comparator: " + comparator.compare(7, 7));
    }
}

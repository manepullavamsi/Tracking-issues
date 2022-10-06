package com.experiment.experience.springbootfeatures.Java8.functionalInterfaces;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.function.Function;
//function which exist inside compose will execute first and then return type would be passed as parameter to next function
//and Then method executes in sequence how we declared.
@Slf4j
public class FunctionExample {
    static Function<String ,String > upperCaseFunction= String::toUpperCase;
    static Function<String,String> nullCheckFunction=(string)-> StringUtils.hasText(string)?string:"default";
    static Function<String,Integer> stringIntegerFunction= String::length;
    public static void main(String[] args) {

        Print();

    }
    public static void Print()
    {
        log.info(" compose Upper case function : "+upperCaseFunction.compose(nullCheckFunction).apply("Hello"));
        log.info("compose Upper case function : "+upperCaseFunction.compose(nullCheckFunction).apply(""));
        log.info("andThen Example "+nullCheckFunction.andThen(upperCaseFunction).andThen(stringIntegerFunction).apply("Venkateshwara"));
        log.info("andThen Example "+ upperCaseFunction.andThen(nullCheckFunction).apply("Venkateshwara"));
        log.info("andThen Example "+nullCheckFunction.andThen(upperCaseFunction).apply(""));
    }
}

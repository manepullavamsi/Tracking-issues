package com.experiment.experience.springbootfeatures.Java8.localVariable;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
//local variable we can't use inside lambda expression as it is by default final
//but static and non-static variables we can access, and we are good modify those
@Slf4j
public class LocalVariableLambda {
    static  int k=7;
    public static void main(String[] args) {
//    int i=0;
        Consumer<Integer> test=(j)->
        {
//            log.info(String.valueOf(i+j));
//            i=4;
                        log.info(String.valueOf(k+j));
            k=4;
        };
    }
}

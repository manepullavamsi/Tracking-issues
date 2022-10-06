package com.experiment.experience.springbootfeatures.Java8.functionalInterfaces;

import java.util.List;
import java.util.function.Predicate;

import com.experiment.experience.springbootfeatures.utility.Student;
import com.experiment.experience.springbootfeatures.utility.StudentDataBase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PerdicatesExample {
    static Predicate<Integer> even = (i) -> i % 2 == 0;
    static Predicate<Integer> multipleOf5 = (i) -> i % 5 == 0;

    static Predicate<Student> filterGrade=(student)->student.getGradeLevel()>=3.6;
    static Predicate<Student> filterGpa=(student)->student.getGpa()>=3.7;


    public static void main(String[] args) {
        log.info("even 4 : " + even.test(4));
        log.info("even negate 4 : " + even.negate().test(4));
        log.info("multipleOf5 35 : " + multipleOf5.test(35));
        log.info("even.and(multipleOf5).test(10)  : " + even.and(multipleOf5).test(10));
        log.info("+ even.and(multipleOf5).test(25)) : " + even.and(multipleOf5).test(25));
        log.info("even.or(multipleOf5).test(25) :  " + even.or(multipleOf5).test(25));
        log.info("even.or(multipleOf5).test(3)  : " + even.or(multipleOf5).test(3));
        log.info(
                "even.and(multipleOf5).negate().test(10) : "
                        + even.and(multipleOf5).negate().test(10));
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach((student) -> {
           if(filterGrade.test(student))
               log.info(""+student);
    });
    }

}

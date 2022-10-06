package com.experiment.experience.springbootfeatures.Java8.functionalInterfaces;

import com.experiment.experience.springbootfeatures.utility.Student;
import com.experiment.experience.springbootfeatures.utility.StudentDataBase;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Predicate;
@Slf4j
public class BiFunctionalExample {
    static BiFunction<List<Student>, Predicate<Student>, Map<String,Double>> listPredicateMapBiFunction=
            (students, studentPredicate) -> {
                Map<String,Double> studentMap=new HashMap<>();
                students.forEach(student -> {
                    if(studentPredicate.test(student))
                        studentMap.put(student.getName(),student.getGpa());
                });
                return studentMap;
            };

   static BiConsumer<String,Double> biConsumer=(name,gpa)->log.info("Name : "+name+" and Gpa : "+gpa);

    public static void main(String[] args) {
        Map<String,Double> studentMap=listPredicateMapBiFunction.apply(StudentDataBase.getAllStudents(),PerdicatesExample.filterGpa);
        studentMap.forEach(biConsumer);
    }
}

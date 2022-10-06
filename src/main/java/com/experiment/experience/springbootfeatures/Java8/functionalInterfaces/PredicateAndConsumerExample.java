package com.experiment.experience.springbootfeatures.Java8.functionalInterfaces;

import com.experiment.experience.springbootfeatures.utility.Student;
import com.experiment.experience.springbootfeatures.utility.StudentDataBase;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

@Slf4j
public class PredicateAndConsumerExample {
    static BiPredicate<Double,Integer> biPredicate=(gpa,gradeLevel)->gpa>=1&&gradeLevel>2;
     static BiConsumer<String, List<String>> biConsumer=(name,activities) -> log.info("Name: "+name+"Activities : "+activities);

    public static void main(String[] args) {
        predicateAndConsumer();
    }

    public static void predicateAndConsumer()
    {
        List<Student> studentList= StudentDataBase.getAllStudents();
        studentList.forEach((student)->{
            if(biPredicate.test(student.getGpa(),student.getGradeLevel()))
                biConsumer.accept(student.getName(),student.getActivities());
        });
    }




}

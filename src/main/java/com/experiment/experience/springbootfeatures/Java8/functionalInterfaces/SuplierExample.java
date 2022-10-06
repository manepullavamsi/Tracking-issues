package com.experiment.experience.springbootfeatures.Java8.functionalInterfaces;

import com.experiment.experience.springbootfeatures.utility.Student;
import com.experiment.experience.springbootfeatures.utility.StudentDataBase;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.function.Supplier;

@Slf4j
public class SuplierExample {

    static Supplier student=()->new Student(
            "Sophia",
            4,
            3.5,
            "female",
            Arrays.asList("swimming", "dancing", "football"));

    static Supplier getStudents=()-> StudentDataBase.getAllStudents();

    public static void main(String[] args) {
        System.out.println(student.get());
        System.out.println(getStudents.get());
    }


}

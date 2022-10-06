package com.experiment.experience.springbootfeatures.Java8.methodreference;

import com.experiment.experience.springbootfeatures.utility.Student;
import com.experiment.experience.springbootfeatures.utility.StudentDataBase;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;

@Slf4j
public class MethodReferenceConsumer {
    static Consumer<Student> printStudent= System.out::println;
    public static void main(String[] args) {
        List<Student> studentList= StudentDataBase.getAllStudents();
        studentList.forEach(printStudent);
    }

}

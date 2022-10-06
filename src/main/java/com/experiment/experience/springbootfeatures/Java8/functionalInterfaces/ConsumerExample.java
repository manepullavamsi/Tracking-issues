package com.experiment.experience.springbootfeatures.Java8.functionalInterfaces;

import com.experiment.experience.springbootfeatures.utility.Student;
import com.experiment.experience.springbootfeatures.utility.StudentDataBase;
import java.util.List;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsumerExample {
    static Consumer<Student> printStudent = s -> log.info("Student Details : " + s);
    static Consumer<Student> printStudentName = s -> log.info("Student Name: " + s.getName());
    static Consumer<Student> printStudentGpa = s -> log.info("\rStudent Gpa: " + s.getGpa());

    public static void main(String[] args) {
        Consumer<Integer> square = (i) -> log.info("Square of i " + i + " = " + i * i);
        square.accept(7);
        //        printStudent();
        printStudentWithCondition();
    }

    public static void printStudent() {
        Consumer<Student> printStudent = s -> log.info("Student : " + s);
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(printStudent);
    }

    public static void printStudentWithCondition() {
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(
                (student) -> {
                    if (student.getGradeLevel() >= 3)
                        printStudentName
                                .andThen(printStudentGpa)
                                .accept(student); // This concept is called construtor Chaning
                });
    }
}

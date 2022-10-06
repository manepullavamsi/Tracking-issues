package com.experiment.experience.springbootfeatures.Java8.functionalInterfaces;

import com.experiment.experience.springbootfeatures.utility.Student;
import com.experiment.experience.springbootfeatures.utility.StudentDataBase;
import java.util.List;
import java.util.function.BiConsumer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BiConsumerExample {
    // This we can use when we want pass 2 parameters for consumer there is no performance
    // difference b/w Consumer and Bi Consumer
    static BiConsumer<Integer, Integer> sum = (a, b) -> log.info("Sum of values : " + (a + b));

    static BiConsumer<Integer, Integer> division =
            (a, b) -> log.info("Division of two values : " + (a / b));
    static BiConsumer<String, String> studentDetails =
            (name, gender) -> log.info("Student Details Name: " + name + " and Gender: " + gender);

    public static void main(String[] args) {

        sum.accept(1, 2);
        division.accept(25, 5);
        sum.andThen(division)
                .accept(
                        30,
                        6); // This is chaining concept of Consumer when we want to apply multiple
        displayStudentDetails();
    }

    public static void displayStudentDetails() {
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(
                (student) -> studentDetails.accept(student.getName(), student.getGender()));
    }
}

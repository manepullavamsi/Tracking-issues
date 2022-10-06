package com.experiment.experience.springbootfeatures.Java8.streamsapi;

import com.experiment.experience.springbootfeatures.utility.Student;
import com.experiment.experience.springbootfeatures.utility.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
//Inorder Debug Streams we can use peek as it accepts consumer, and we got to know stream perform all operation for one element then it will go for next index element
public class DebuggingStreams {
    static Predicate<Student> gpaFilter=(student)->student.getGpa()>3;
    static Predicate<Student> gradeFilter=(student)->student.getGradeLevel()>3;
    //   static Function<Student,String> nameFunction= student -> student.getName();
//   static Function<Student,Double> gpaFunction= student -> student.getGpa();
    static Function<Student,String> nameFunction= Student::getName;
    static Function<Student,Double> gpaFunction= Student::getGpa;

    public static void main(String[] args) {
        List<Student> studentList= StudentDataBase.getAllStudents();
        Map<String,Double> studentMap=studentList.stream().peek(student -> System.out.println("Before Filter"+student)).filter(gpaFilter).peek(student -> System.out.println("After 1st Filter"+student)).filter(gradeFilter).peek(student -> System.out.println("After 2 nd Filter"+student)).collect(Collectors.toMap(nameFunction,gpaFunction));
//        System.out.println("Student Map : "+studentMap);
    }
}

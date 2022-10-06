package com.experiment.experience.springbootfeatures.Java8.streamsapi;

import com.experiment.experience.springbootfeatures.utility.Student;
import com.experiment.experience.springbootfeatures.utility.StudentDataBase;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class StreamsExample1 {
   static Predicate<Student> gpaFilter=(student)->student.getGpa()>3;
   static Predicate<Student> gradeFilter=(student)->student.getGradeLevel()>3;
//   static Function<Student,String> nameFunction= student -> student.getName();
//   static Function<Student,Double> gpaFunction= student -> student.getGpa();
        static Function<Student,String> nameFunction= Student::getName;
       static Function<Student,Double> gpaFunction= Student::getGpa;

    public static void main(String[] args) {
        List<Student> studentList= StudentDataBase.getAllStudents();
        Map<String,Double> studentMap=studentList.stream().filter(gpaFilter.and(gradeFilter)).collect(Collectors.toMap(nameFunction,gpaFunction));
        System.out.println("Student Map : "+studentMap);
    }

}

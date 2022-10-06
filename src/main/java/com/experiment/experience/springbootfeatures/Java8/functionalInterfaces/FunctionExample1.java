package com.experiment.experience.springbootfeatures.Java8.functionalInterfaces;

import com.experiment.experience.springbootfeatures.utility.Student;
import com.experiment.experience.springbootfeatures.utility.StudentDataBase;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class FunctionExample1 {
   static Predicate<Student> gradeEvaluation=student -> student.getGpa()>3.5;
    static  Function<List<Student>, Map<String,Double>> listMapFunction=(students)->{
        Map<String,Double> studentNameGrade=new HashMap<>();
        students.forEach((student)->
        {
            if(gradeEvaluation.test(student))
                studentNameGrade.put(student.getName(),student.getGpa());
        });
        return studentNameGrade;
    };
    public static void main(String[] args) {
        Map<String,Double> stringDoubleMap =listMapFunction.apply(StudentDataBase.getAllStudents());
        stringDoubleMap.forEach((name,gpa)->{
            log.info("Name : "+name +" and GPA : "+gpa);
        });
    }


}

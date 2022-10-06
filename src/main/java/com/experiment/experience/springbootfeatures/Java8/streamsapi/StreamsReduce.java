package com.experiment.experience.springbootfeatures.Java8.streamsapi;

import com.experiment.experience.springbootfeatures.utility.Student;
import com.experiment.experience.springbootfeatures.utility.StudentDataBase;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
public class StreamsReduce {


    public static void main(String[] args) {
        List<Integer> li= Arrays.asList(1,2,3,4,5,6,7);

        System.out.println("Reduce Amount : "+ li.stream().reduce((a,b)->a+b));
        Optional<Student> student=getHighestGpa();
        System.out.println("Highest Student with highest Gpa"+student.get());
    }

    public static Optional<Student> getHighestGpa()
    {
        List<Student> studentList=StudentDataBase.getAllStudents();
       return  studentList.stream().reduce((s1,s2)->{
          return  s1.getGpa()>=s2.getGpa()?s1:s2;
                }
        );
    }




}

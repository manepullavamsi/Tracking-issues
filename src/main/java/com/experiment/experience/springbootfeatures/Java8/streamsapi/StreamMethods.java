package com.experiment.experience.springbootfeatures.Java8.streamsapi;

import com.experiment.experience.springbootfeatures.utility.Student;
import com.experiment.experience.springbootfeatures.utility.StudentDataBase;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class StreamMethods {

    public static void main(String[] args) {
    log.info("studentCount : "+studentCount());
    studentDistinctAndSort();

    }
    public static long studentCount()
    {
        List<Student> s=StudentDataBase.getAllStudents();
      return   s.stream().count();
    }
    public static void studentDistinctAndSort()
    {
        List<Student> s=StudentDataBase.getAllStudents();
        List<String> Dl= s.stream().map(student -> student.getActivities()).flatMap(a->a.stream()).distinct().collect(Collectors.toList());
        log.info("Distinct List "+Dl);
        s.stream().map(Student::getName).sorted().collect(Collectors.toList()).stream().forEach(name->log.info("\rStudent Name : "+name));
    }


}

package com.experiment.experience.springbootfeatures.Java8.streamsapi;

import com.experiment.experience.springbootfeatures.utility.StudentDataBase;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class StreamMapFilterReduce {

    public static void main(String[] args) {
        StudentDataBase.getAllStudents().stream().filter(student -> student.getGpa()>=3).map(student -> student.getNoNotes()).forEach(a->log.info("Notes : "+a));
     log.info("Student Sum Notes : "+StudentDataBase.getAllStudents().stream().filter(student -> student.getGpa()>=3).map(student -> student.getNoNotes()).filter(i->i<70).reduce(0,(a,b)->a+b));
        getMaxNumber();
        getMinNumber();
    }

    public static void getMaxNumber()
    {
        log.info("Student Max Notes Value : "+StudentDataBase.getAllStudents().stream().filter(student -> student.getGpa()>=3).map(student -> student.getNoNotes()).reduce((x,y)->x>y?x:y));
    }
    public static void getMinNumber()
    {
        log.info("Student Min Notes Value : "+StudentDataBase.getAllStudents().stream().filter(student -> student.getGpa()>=3).map(student -> student.getNoNotes()).reduce((x,y)->x<y?x:y));
    }
}

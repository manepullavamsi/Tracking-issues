package com.experiment.experience.springbootfeatures.Java8.streamsapi;

import com.experiment.experience.springbootfeatures.utility.StudentDataBase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamMatchExample {

    public static boolean anyMatch()
    {
        return StudentDataBase.getAllStudents().stream().anyMatch(student ->student.getNoNotes()>=7);
    }
    public static boolean allMatch()
    {
        return StudentDataBase.getAllStudents().stream().allMatch(student ->student.getNoNotes()>=2);
    }
    public static boolean noneMatch()
    {
        return StudentDataBase.getAllStudents().stream().noneMatch(student ->student.getNoNotes()>=100);
    }

    public static void main(String[] args) {
        log.info("anyMatch : "+anyMatch());
        log.info("allMatch : "+allMatch());
        log.info("noneMatch : "+noneMatch());
    }
}

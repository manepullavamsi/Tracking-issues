package com.experiment.experience.springbootfeatures.Java8.streamsapi;

import com.experiment.experience.springbootfeatures.utility.StudentDataBase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamSkipLimit {

    public static void main(String[] args) {
       log.info(" Limit Example"+ StudentDataBase.getAllStudents().stream().map(student -> student.getNoNotes())
                .limit(5).reduce((a,b)->
               {
                   log.info("a : "+a+" & b : "+b);
                  return a+b;
               }));


        log.info(" Skip Example"+ StudentDataBase.getAllStudents().stream().map(student -> student.getNoNotes())
                .skip(2).limit(5).reduce((a,b)->
                {
                    log.info("a : "+a+" & b : "+b);
                    return a+b;
                }));
    }

}

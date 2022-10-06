package com.experiment.experience.springbootfeatures.Java8.streamsapi;

import com.experiment.experience.springbootfeatures.utility.StudentDataBase;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//Flat Map come into picture when we are transforming at that if we have stream of collections then our collect won't work
//Flat map we can use transform from one type to another.
//Inorder to overcome for that we use flatmap
@Slf4j
public class FlatMapExample {


    public static void main(String[] args) {
     List<String> studentActivities=  StudentDataBase.getAllStudents().stream().map(student -> student.getActivities()).flatMap(activites->activites.stream()).collect(Collectors.toList());
//     studentActivities.forEach(a->log.info(a));
        Set<String> studentActivitiesSet=  StudentDataBase.getAllStudents().stream().map(student -> student.getActivities()).flatMap(activites->activites.stream()).collect(Collectors.toSet());
        log.info(" Activity Example : "+studentActivities);
        List<String> studentActivitiesDistinct= StudentDataBase.getAllStudents().stream().map(student -> student.getActivities()).flatMap(activites->activites.stream()).distinct().collect(Collectors.toList());
        log.info("Distint Activities "+studentActivitiesDistinct);
        Long count=StudentDataBase.getAllStudents().stream().map(student -> student.getActivities()).flatMap(activites->activites.stream()).distinct().count();
    log.info("Count of Unique Activities "+count);
        List<String> studentActivitiesDistinctSorted= StudentDataBase.getAllStudents().stream().map(student -> student.getActivities()).flatMap(activites->activites.stream()).distinct().sorted().collect(Collectors.toList());
        log.info("Distint Activities "+studentActivitiesDistinct);
    }
}

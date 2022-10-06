package com.experiment.experience.springbootfeatures.Java8.streamsapi;

import com.experiment.experience.springbootfeatures.utility.StudentDataBase;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

//Collection MAp and this Streams map are different
//These are  used to transform from one form of stream into another
// lets we can transform Student stream into String
@Slf4j
public class StreamsMap {

    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(3,3,3,2,2,5,5,1,0);
        numbers.sort((a,b) -> a>b?-1:(a==b)?0:1);
        log.info("List : " +numbers);



   /*     for(int i=0;i<numbers.size();i++)
        {

        }*/
//        numbers.stream().filter((n)->n==numbers.get(i))
        LinkedHashMap<Integer,Integer> numberMaps=new LinkedHashMap<>();
         numbers.stream().map((p1)->numberMaps.containsKey(p1)?numberMaps.put(p1,numberMaps.get(p1)+1):numberMaps.put(p1,1))
                 .sorted();


         log.info("number Map Before Sort : " +numberMaps);

        List<Map.Entry<Integer, Integer> > list
                = new LinkedList<Map.Entry<Integer, Integer> >(
                numberMaps.entrySet());

        // Sort the list using lambda expression
        Collections.sort(
                list,
                (i1,
                 i2) -> i1.getValue()>i2.getValue()?-1:(i1.getValue()==i2.getValue())?0:1);

        // put data from sorted list to hashmap
        LinkedHashMap<Integer, Integer> temp
                = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        log.info("Temp Map  After Sort : " +temp);
  /*              .map((n)->{
            TreeMap<Integer,Integer> numberMap=new TreeMap<Integer,Integer>();
            if(numberMap.containsKey(n))
                numberMap.put(n,numberMap.get(n)+1);
            numberMap.put(n,1);
            return numberMap;
        }).collect(Collectors.toList());*/



        /*li.forEach(a->{log.info("MapList :  "+a);});*/






/*        List<String> studentNames= StudentDataBase.getAllStudents().stream()
                .map(student -> student.getName())    //Here we are transforming String student into String
                .collect(Collectors.toList());//to list
        studentNames.forEach(name->log.info("Student Name : "+name));

        Set<String> setStudentNames= StudentDataBase.getAllStudents().stream()
                .map(student -> student.getName())    //Here we are transforming String student into String
                .collect(Collectors.toSet());//to Set
        System.out.println("Set NAmes : "+setStudentNames);*/

    }



}

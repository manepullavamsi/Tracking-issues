package com.experiment.experience.springbootfeatures.utility;

import java.util.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CollectionsPlayGround {
    public static void main(String[] args) {
        ArrayList<Integer> Al = new ArrayList<>();
        Al.add(10);
        Al.add(2);
        Al.add(30);

        Al.sort((i, j) -> i > j ? -1 : 1);

        log.info(Al.toString());
    }
}

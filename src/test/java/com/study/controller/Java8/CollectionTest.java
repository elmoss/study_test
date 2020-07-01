package com.study.controller.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xinfei.wang on 2019/11/7.
 */
public class CollectionTest {

    public static void main(String[] args) {
        collectionToMap();
    }

    public static void collectionToMap() {
        Integer[] i = new Integer[]{2,3,4,7,3,3,5,7};
        List<Integer> ints = Arrays.asList(i);
        Map<Integer, Integer> collect = ints.stream().map(p -> Integer.valueOf(p))
            .collect(Collectors.groupingBy(p -> p, Collectors.summingInt(l -> +1)));
        System.out.println(collect);
    }
}

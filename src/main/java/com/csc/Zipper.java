package com.csc;

import java.util.ArrayList;
import java.util.List;

public class Zipper {
    public static <T> List<T> zip(List<T> list1, List<T> list2){
        List<T> result = new ArrayList<>();
        int min = Math.min(list1.size(), list2.size());
        int i = 0;

        while (i < min){
            result.add(list1.get(i));
            result.add(list2.get(i));
            i++;
        }

        for (int j = i; j < list1.size(); j++){
            result.add(list1.get(j));
        }

        for (int j = i; j < list2.size(); j++){
            result.add(list2.get(j));
        }
        return result;
    }
}

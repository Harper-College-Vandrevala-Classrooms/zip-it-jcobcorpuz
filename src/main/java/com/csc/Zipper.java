package com.csc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static <T> Map<String, T> hashmapify(List<String> keys, List<T> values){
        if (keys.size()!= values.size()){
            throw new IllegalArgumentException("Lists must be the same size");
        }
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < keys.size(); i++){
            map.put(keys.get(i), values.get(i));
        }
        return map;
    }
}

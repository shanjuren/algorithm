package com.algorithm.manacher;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author ght
 * @date 2022.04.15 5:11 PM
 * @description
 */
public class Manacher {

    public static void main(String[] args) {

        LinkedHashMap<Integer,String> test1 = new LinkedHashMap(16,0.75F,true);
        test1.put(1,"11");
        test1.put(2,"22");
        test1.put(3,"33");
//        test1.get(1);

        for (Map.Entry<Integer, String> entry : test1.entrySet()) {
            System.out.print("key is{"+entry.getKey()+"},value is{"+entry.getValue()+"}\n");
        }

    }
}

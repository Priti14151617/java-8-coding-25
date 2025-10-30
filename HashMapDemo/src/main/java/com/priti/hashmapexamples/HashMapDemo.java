package com.priti.hashmapexamples;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<Integer, String> hashmap = new HashMap<>();
        hashmap.put(1,"Apple");
        hashmap.put(2,"Ball");
        hashmap.put(3,"Cat");

        System.out.println("hashmap : "+hashmap +"\n");  //hashmap : {1=Apple, 2=Ball, 3=Cat}
//entryset
        Set<Map.Entry<Integer,String>> entrysets  = hashmap.entrySet();

        System.out.println("entrysets : "+entrysets + "\n"); // entryset : [1=Apple, 2=Ball, 3=Cat]
        System.out.println(
                "Key" + "|"+"value"
        );
        for(Map.Entry<Integer, String > entryset : entrysets){
            System.out.println(entryset.getKey() + "|"+ entryset.getKey());
        }


        //keyset
        for(Integer key : hashmap.keySet())
        {
           /* System.out.println("key : "+key);
            System.out.println("\n");*/
            System.out.println("key : "+key +"," +" value : "+hashmap.get(key));
        }
    }
}

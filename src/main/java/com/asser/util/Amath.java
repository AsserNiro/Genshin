package com.asser.util;

import java.util.List;

public class Amath {

    public static String createIdAfter(int id){
        System.out.println("原有"+id);
        id += 1;
        String ID = Integer.toString(id);
        int wei = 0;
        System.out.println(id+"有");
        while(id > 0){
            id /= 10;
            wei++;
        }
        System.out.println(wei+"位");
        wei = 4 - wei;
        String ans = "";
        while(wei > 0){
            ans += "0";
            wei--;
        }
        ans += ID;
        return ans;
    }


}

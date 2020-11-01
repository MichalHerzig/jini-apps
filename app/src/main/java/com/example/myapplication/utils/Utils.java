package com.example.myapplication.utils;

import com.example.myapplication.model.Num;

import java.util.List;

public  class Utils {
    public static String findItemsThatSumTozero(List<Num> list) {
        String s="";
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getNumber() + list.get(j).getNumber() == 0) {
                    s=s+i+","+j+",";
                }
            }
        }
        return s;
    }
}

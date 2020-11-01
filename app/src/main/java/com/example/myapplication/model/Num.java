package com.example.myapplication.model;

public class Num implements Comparable<Num>{
    private int number;
    public  Num(int num)
{
    this.number=num;
}
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    @Override
    public int compareTo(Num o) {
        if (number > o.number) {
            return 1;
        }
        else if (number <  o.number) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

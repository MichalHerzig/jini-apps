package com.example.myapplication.model;

import com.example.myapplication.model.Num;

import java.util.ArrayList;

public class Numbers {
    private ArrayList<Num> numbers;

    public  Numbers(ArrayList<Num> numbers)
    {
        this.numbers=numbers;
    }
    public ArrayList<Num> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Num> numbers) {
        this.numbers = numbers;
    }
}

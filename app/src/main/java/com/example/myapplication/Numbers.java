package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

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

package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://pastebin.com/raw/";

    @GET("8wJzytQX")
    Call<Numbers> getNumbers();
}

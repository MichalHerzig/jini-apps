package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.SortedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NumbersViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Num>> numbersList;

    public LiveData<ArrayList<Num>> getNumbers() {
        if (numbersList == null) {
            numbersList = new MutableLiveData<ArrayList<Num>>();
            loadNumbers();
        }

      /*  if(numbersList.getValue()== null){
            ArrayList<Num> n=new ArrayList<>();
            n.add(new Num(1));
            n.add(new Num(2));
            n.add(new Num(7));
            n.add(new Num(4));
            n.add(new Num(5));
            numbersList.setValue(n);
        }*/
  Collections.sort(numbersList.getValue(), new Comparator<Num>() {
            @Override
            public int compare(Num o1, Num o2) {
                return o2.getNumber()-o1.getNumber();
            }
        });
        return numbersList;
}

    private void loadNumbers() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Api.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Api api = retrofit.create(Api.class);
            Call<Numbers> call = api.getNumbers();


            call.enqueue(new Callback<Numbers>() {
                @Override
                public void onResponse(Call<Numbers> call, Response<Numbers> response) {

                    numbersList.setValue(response.body().getNumbers());
                }

                @Override
                public void onFailure(Call<Numbers> call, Throwable t) {
                    t.getStackTrace();
                    //  call.request().body().toString();
                }
            });
    }
    
}

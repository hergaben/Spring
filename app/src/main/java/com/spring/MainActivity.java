package com.spring;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Stats> SpringList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpringList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycleView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://hleby6ek.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SpringApi springApi = retrofit.create(SpringApi.class);

        Call<List<Stats>> call = springApi.getSpring();

        call.enqueue(new Callback<List<Stats>>() {
            @Override
            public void onResponse(Call<List<Stats>> call, Response<List<Stats>> response) {
                List<Stats> stat = response.body();

                for (Stats stats:stat){
                    SpringList.add(stats);
                    Log.d("!!!!!!", "Norm!");
                }
                PutDataIntoRecyclerView(SpringList);

            }

            @Override
            public void onFailure(Call<List<Stats>> call, Throwable t) {
                Log.d("!!!!!!", "Ne Norm!");

            }
        });
    }

    private void PutDataIntoRecyclerView(List<Stats> SpringList) {
        Adapter adapter = new Adapter(this, SpringList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

}


























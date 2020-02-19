package com.example.retrofitproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private static final String TAG = "MainActivity";
    private static final String  BASE_URL="http://starlord.hackerearth.com/";

//    private List<RetroSong> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetSongService service= RetrofitClientInstance.getRetrofitInstance().create(GetSongService.class);

        Call<List<RetroSong>> call=service.getAllSongs();
        call.enqueue(new Callback<List<RetroSong>>() {


            @Override
            public void onResponse(Call<List<RetroSong>> call, Response<List<RetroSong>> response) {
               generateDataList(response.body());
                Log.i(TAG, "onResponse: "+response.body().toString());
                Toast.makeText(MainActivity.this, "all is well", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<RetroSong>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<RetroSong> songList) {
        recyclerView = findViewById(R.id.recycler);
        myAdapter = new MyAdapter(songList,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);
    }
    }


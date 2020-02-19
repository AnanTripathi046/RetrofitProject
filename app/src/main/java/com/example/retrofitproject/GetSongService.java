package com.example.retrofitproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetSongService {

    @GET("/studio")
    Call<List<RetroSong>> getAllSongs();
}

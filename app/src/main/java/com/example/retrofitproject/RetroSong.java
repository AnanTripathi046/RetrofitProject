package com.example.retrofitproject;

import com.google.gson.annotations.SerializedName;

public class RetroSong {
    @SerializedName("song")
    private String song;
    @SerializedName("url")
    private String url;
    @SerializedName("artists")
    private String artists;
    @SerializedName("cover_image")
    private String imgUrl;

    public RetroSong(String song, String url, String artists, String imgUrl) {
        this.song = song;
        this.url = url;
        this.artists = artists;
        this.imgUrl = imgUrl;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "RetroSong{" +
                "song='" + song + '\'' +
                ", url='" + url + '\'' +
                ", artists='" + artists + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}

package com.myapplicationdev.android.ourndpsongs;

import java.io.Serializable;

import androidx.annotation.NonNull;

public class Song implements Serializable {

	private int id;
	private String title;
	private String singers;
	private String date;
	private int stars;

    public Song(int id, String title, String singers, String date, int stars) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.date = date;
        this.stars = stars;

    }

    public int getId() {
        return id;
    }

    public Song setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Song setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSingers() {
        return singers;
    }

    public Song setSingers(String singers) {
        this.singers = singers;
        return this;
    }

    public String getYearReleased() {
        return date;
    }

    public Song setDate(String date) {
        this.date = date;
        return this;
    }

    public int getStars() {
        return stars;
    }

    public Song setStars(int stars) {
        this.stars = stars;
        return this;
    }

    @NonNull
    @Override
    public String toString() {
        String starsString = "";
        for(int i = 0; i < stars; i++){
            starsString += "*";
        }
        return title + "\n" + singers + " - " + date + "\n" + starsString;

    }
}

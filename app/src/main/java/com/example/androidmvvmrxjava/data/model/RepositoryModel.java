package com.example.androidmvvmrxjava.data.model;

import com.google.gson.annotations.SerializedName;

public class RepositoryModel {

    private long id;
    private String name;
    private String description;
    private UserModel user;
    @SerializedName("stargazers_count")
    private long stars;
    @SerializedName("forks_count")
    private long forks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public long getStars() {
        return stars;
    }

    public void setStars(long stars) {
        this.stars = stars;
    }

    public long getForks() {
        return forks;
    }

    public void setForks(long forks) {
        this.forks = forks;
    }
}

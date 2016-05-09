package com.example.aditya.daggerretrofitokhttp_tutorial;

import java.util.List;

import retrofit2.http.GET;

/**
 * Created by Aditya on 09-May-16.
 */
public interface Restapi {

    @GET("/posts")
    List<Post> getPosts();
}

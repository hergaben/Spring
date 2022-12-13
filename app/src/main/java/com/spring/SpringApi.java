package com.spring;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SpringApi {

    @GET("stats")
    Call<List<Stats>> getSpring();

}

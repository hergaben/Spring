package com.spring;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SpringApi {

    @GET("stats?rapidapi-key=02e3aad88dmsh200fff7930d9119p1a6a70jsn14ce6533a67a")
    Call<List<Stats>> getSpring();

}

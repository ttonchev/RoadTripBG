package com.roadtripbg.http;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface RoadTrip {

	@GET("/city")
    void cities(Callback<List<City>> callback);
}

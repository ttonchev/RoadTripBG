package com.roadtripbg.activities;

import retrofit.http.GET;



public interface RoadTrip {
	@GET("/city")
    void cities();
}

package com.roadtripbg.http;

import retrofit.RestAdapter;

public class RoadTripService {

	private static String API_URL = "http://192.168.0.100:8080/RoadTripServer";

    public static RoadTrip getService() {
        return new RestAdapter.Builder()
                    .setEndpoint(API_URL)
                    .build()
                    .create(RoadTrip.class);
    }
}

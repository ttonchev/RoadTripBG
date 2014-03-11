package com.roadtripbg.activities;

import retrofit.RestAdapter;

public class RoadTripService {
	private static String API_URL = "https://api.github.com";

    public static RoadTrip getService() {
        return new RestAdapter.Builder()
                    .setServer(API_URL)
                    .build()
                    .create(RoadTrip.class);
    }
}

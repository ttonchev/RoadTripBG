package com.roadtripbg.activities;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import com.roadtripbg.R;
import com.roadtripbg.http.City;
import com.roadtripbg.http.RoadTripService;

public class MainActivity extends Activity {
	
	@InjectView(R.id.potka) TextView text;

	private RoadTrip api;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        
        RoadTripService.getService().cities(new Callback<List<City>>() {

			@Override
			public void failure(RetrofitError arg0) {
				text.setText("NO INTERNET");
			}

			@Override
			public void success(List<City> cities, Response arg1) {
				String a = "";
				for (City city : cities) {
					a += city.name;
				}
				text.setText(a);
			}
        });
//        text.setText("KOR");
    }
    
    @OnClick(R.id.potka) void setPishka() {
    	text.setText("Pishka");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void setApi(RoadTrip roadTripApi) {
    	api = roadTripApi;
    }
}

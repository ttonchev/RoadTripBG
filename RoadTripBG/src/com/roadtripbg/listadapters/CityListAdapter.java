package com.roadtripbg.listadapters;

import java.util.ArrayList;
import java.util.List;

import com.roadtripbg.R;
import com.roadtripbg.http.City;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

public class CityListAdapter extends BaseAdapter {

	private Context mContext;
	private List<City> mCities = new ArrayList<City>();

	public CityListAdapter(Context context) {
		super();

		this.mContext = context;
	}

	public void setCities(List<City> cities) {
		mCities = cities;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return mCities.size();
	}

	@Override
	public Object getItem(int arg0) {

		return mCities.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		if (row == null) {

			 LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			 row = inflater.inflate(R.layout.city_item_row, null);
			 
			CityHolder holder = new CityHolder();
			holder.name = (EditText) row.findViewById(R.id.pleaseChooseId);
			row.setTag(holder);
		}

		CityHolder holder = (CityHolder) row.getTag();
		City city = mCities.get(position);
		holder.name.setText(city.name);

		return row;
	}

	static class CityHolder {
		EditText name;

	}
}

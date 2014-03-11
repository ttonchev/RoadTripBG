package com.roadtripbg.activities;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import com.roadtripbg.R;
import com.roadtripbg.listadapters.CityListAdapter;

public class SearchActivity extends FragmentActivity {

	@InjectView(R.id.fromId)
	TextView text;
	@InjectView(R.id.dateId)
	TextView date;

    private CityListAdapter mAdapter;


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_layout);
		ButterKnife.inject(this);
		
		//TODO: Figure out how to populate the lister view

	}

	@OnClick(R.id.fromId)
	void setFromCity() {
		Intent mainIntent = new Intent(SearchActivity.this, MainActivity.class);
		startActivity(mainIntent);
		finish();
	}

	
	@OnClick(R.id.pleaseChooseId)
	public void selectDate(View view) {
		DialogFragment newFragment = new SelectDateFragment();
		newFragment.show(getSupportFragmentManager(), "DatePicker");
	}
	
	public void populateSetDate(int year, int month, int day) {
		TextView mEdit = (EditText) findViewById(R.id.pleaseChooseId);
		mEdit.setText(month + "/" + day + "/" + year);
	}

	@SuppressLint("ValidFragment")
	public class SelectDateFragment extends DialogFragment implements
			DatePickerDialog.OnDateSetListener {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			final Calendar calendar = Calendar.getInstance();
			int yy = calendar.get(Calendar.YEAR);
			int mm = calendar.get(Calendar.MONTH);
			int dd = calendar.get(Calendar.DAY_OF_MONTH);
			return new DatePickerDialog(getActivity(), this, yy, mm, dd);
		}

		public void onDateSet(DatePicker view, int yy, int mm, int dd) {
			populateSetDate(yy, mm + 1, dd);
		}
	}

}

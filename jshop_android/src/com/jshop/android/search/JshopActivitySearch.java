package com.jshop.android.search;

import com.jshop.android.index.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class JshopActivitySearch extends Activity {

	private AutoCompleteTextView searchautoCompleteTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.setContentView(R.layout.jshop_activity_index_search);
		searchautoCompleteTextView=(AutoCompleteTextView)this.findViewById(R.id.searchautoCompleteTextView);
		String []strs={"食品","饰品","服装"};
		ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,strs);
		searchautoCompleteTextView.setAdapter(adapter);
		super.onCreate(savedInstanceState);
	}
	
	
}

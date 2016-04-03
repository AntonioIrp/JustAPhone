package com.selfdevel.justaphone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class PhoneFragment extends Fragment{

	View view;
	
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		 view =  inflater.inflate(R.layout.phone_fragment, container, false);
		 
		 RelativeLayout phoneLayout = (RelativeLayout)view.findViewById(R.id.phone_container);
		 phoneLayout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onPhoneButton(v);				
			}
		});
		 
		return view;
	}
	
	public void onPhoneButton(View v){
		//abrir lista de contactos
		Intent contactListActivity = new Intent(view.getContext(), ContactListActivity.class);
		contactListActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(contactListActivity);
	}

}

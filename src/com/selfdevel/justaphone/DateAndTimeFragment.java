package com.selfdevel.justaphone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DateAndTimeFragment extends Fragment {
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		DateFormat df = new SimpleDateFormat("EEEE d MMMM yyyy");
		String date = df.format(Calendar.getInstance().getTime());
		
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.date_and_time_fragment, container, false);
        TextView d = (TextView) view.findViewById(R.id.dateText);
        d.setText(date);
                
        return view;
   }	

}

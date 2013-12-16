package com.itse1701.awt;

import java.applet.*;
import java.awt.*;
import java.util.*;

@SuppressWarnings("serial")
public class Labels2 extends Applet {
	public void init() {
		Label label = new Label();
		Calendar calendar = Calendar.getInstance();
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		if(hours < 12) 
			label.setText("Good morning");
		else if (hours < 18) 
			label.setText("Good Afternoon");
		else
			label.setText("Good Evening");
		add(label);
	}
}

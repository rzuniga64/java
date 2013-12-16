package com.itse1701.awt;

import java.awt.*;

@SuppressWarnings("serial")
public class CreateFields extends java.applet.Applet {
	Label yourName = new Label("Name");
	TextField nameField = new TextField(30);
	Label email = new Label("Email");
	TextField emailField = new TextField(30);
	Label pass = new Label("Password");
	TextField passField = new TextField(30);
	
	public void init() {
		add(yourName);
		add(nameField);
		add(email);
		add(emailField);
		add(pass);
		passField.setEchoChar('*');
		add(passField);
	}
}

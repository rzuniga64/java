package java_lessons.lesson32_graphics.applet;

import java.awt.*;

@SuppressWarnings("serial")
public class CreateFields extends java.applet.Applet {
	Label yourName = new Label("Name:");
	TextField nameField = new TextField(30);
	Label email = new Label("Email: ");
	TextField emailField = new TextField(30);
	Label pass = new Label("password: ");
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

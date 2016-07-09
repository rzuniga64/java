package java_lessons.lesson31_graphics.awt;

import java.awt.*;

@SuppressWarnings("serial")
public class CreateFields extends java.applet.Applet {
	private Label yourName = new Label("Name");
	private TextField nameField = new TextField(30);
	private Label email = new Label("Email");
	private TextField emailField = new TextField(30);
	private Label pass = new Label("Password");
	private TextField passField = new TextField(30);
	
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

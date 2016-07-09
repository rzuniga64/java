package java_lessons.lesson31_graphics.awt;

import java.awt.*;

@SuppressWarnings("serial")
public class Labels extends java.applet.Applet {
	private Label one = new Label("Label One", Label.LEFT);
	private Label two = new Label("Label Two", Label.CENTER);
	private Label three = new Label("Label Three", Label.RIGHT);

	 private Font thefont = new Font("Verdana", Font.BOLD, 12);
	
	public void init() {
		setFont(thefont);
		add(one);
		add(two);
		add(three);
	}

}

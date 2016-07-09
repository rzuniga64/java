package java_lessons.lesson31_graphics.awt;

import java.awt.*;

@SuppressWarnings("serial")
public class Borderlayout extends java.applet.Applet {
	private BorderLayout myborder = new BorderLayout();
	private Button top = new Button("Top");
	private Button bottom = new Button("Bottom");
	private Button right = new Button("Right");
	private Button center = new Button("Center");
	private Button left = new Button("Left");
	
	public void init() {
		setLayout(myborder);
		add("North", top);
		add("South", bottom);
		add("East", right);
		add("West", left);
		add("Center", center);
	}

}

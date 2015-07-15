package java_lessons.lesson32_graphics.awt;

import java.awt.*;

@SuppressWarnings("serial")
public class Borderlayout extends java.applet.Applet {
	BorderLayout myborder = new BorderLayout();
	Button top = new Button("Top");
	Button bottom = new Button("Bottom");
	Button right = new Button("Right");
	Button center = new Button("Center");
	Button left = new Button("Left");
	
	public void init() {
		setLayout(myborder);
		add("North", top);
		add("South", bottom);
		add("East", right);
		add("West", left);
		add("Center", center);
	}

}

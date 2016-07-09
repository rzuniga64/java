package java_lessons.lesson31_graphics.awt;

import java.awt.*;

@SuppressWarnings("serial")
public class Choices extends java.applet.Applet {
	private Choice myList = new Choice();
	
	public void init() {
		myList.add("Choice 1");
		myList.add("Choice 2");
		myList.add("Choice 3");
		add(myList);
	}
}

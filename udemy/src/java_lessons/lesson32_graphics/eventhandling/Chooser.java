package java_lessons.lesson32_graphics.eventhandling;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Chooser extends Applet implements ItemListener {
 Cars Panel1;
 Options Panel2;

 public void init() {
	 setLayout(new GridLayout(1, 2));
	 Panel1 = new Cars();
	 Panel2 = new Options();
	 add(Panel1);
	 Panel1.Ford.addItemListener(this);
	 Panel1.Toyota.addItemListener(this);
	 Panel1.Mazda.addItemListener(this);
	 add(Panel2);
 }

 public void itemStateChanged(ItemEvent e) {
	 if(e.getItemSelectable() == Panel1.Ford) {
		 Panel2.Option1.setState(true);
		 Panel2.Option2.setState(true);
		 Panel2.Option3.setState(false);
		 Panel2.Option4.setState(false);
		 Panel2.Price.setText("Price: $22,679.95");
	 }
		 if(e.getItemSelectable() == Panel1.Toyota) {
		 Panel2.Option1.setState(false);
		 Panel2.Option2.setState(true);
		 Panel2.Option3.setState(false);
		 Panel2.Option4.setState(false);
		 Panel2.Price.setText("Price: $34,599.95");
	}
		 if(e.getItemSelectable() == Panel1.Mazda) {
		 Panel2.Option1.setState(true);
		 Panel2.Option2.setState(false);
		 Panel2.Option3.setState(true);
		 Panel2.Option4.setState(true);
		 Panel2.Price.setText("Price: $23,877.00");
	}
 }
}

@SuppressWarnings("serial")
class Cars extends Panel {
 CheckboxGroup CGroup;
 Checkbox Ford, Toyota, Mazda;


 Cars() {
	 CGroup = new CheckboxGroup();
	 add(Ford = new Checkbox("Ford", CGroup, false));
	 add(Toyota = new Checkbox("Toyota", CGroup, false));
	 add(Mazda = new Checkbox("Mazda", CGroup, false));
 }
}

@SuppressWarnings("serial")
class Options extends Panel {
	Checkbox Option1, Option2, Option3, Option4;
	TextField Price;

	Options() {
	add(Option1 = new Checkbox("Automatic Transmission"));
	add(Option2 = new Checkbox("Automatic Moonroof"));
	add(Option3 = new Checkbox("Leather Seats and Trim"));
	add(Option4 = new Checkbox("Turbo 240 Horsepower Engine"));
	Price = new TextField(15);
	add(Price);
 }
}

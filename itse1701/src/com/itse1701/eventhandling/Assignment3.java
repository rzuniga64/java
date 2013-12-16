package com.itse1701.eventhandling;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Assignment3 extends Applet implements ActionListener {
	
	Font thefont = new Font("Verdana", Font.BOLD, 12);
	Label label = new Label("Please enter age: ", Label.LEFT);
	TextField textfield = new TextField(5);
	Button button = new Button("Display age characteristics");
	
	Checkbox run;
	Checkbox burgers;
	Checkbox glasses;
	Checkbox sit;
	Checkbox toys;
	Checkbox prunes;
	
	public void init() {
		
		setFont(thefont);
		
		// Set layout manager
		setLayout(new BorderLayout());
		
		// Create a panel for "North"
		// Add the label, text field and button to the layout
		Panel pn = new Panel();
		pn.setLayout(new FlowLayout(FlowLayout.LEFT));
		pn.setBackground(Color.LIGHT_GRAY);
		
		pn.add(label);
		pn.add(textfield);
		// Add an ActionListener to the button
		button.addActionListener(this);
		pn.add(button);
		add(pn, "North");
		
		// Create a panel for "Center"
		// Add 6 check boxes to the layout
		Panel pc = new Panel();
		pc.setLayout(new GridLayout(6,1,7,7));
		run = new Checkbox("Likes to run");
		burgers = new Checkbox("Eats burgers");
		glasses = new Checkbox("Needs reading glasses");
		sit = new Checkbox("Likes to sit");
		toys = new Checkbox("Likes toys");
		prunes = new Checkbox("Eats prunes");
		
		pc.add(run);
		pc.add(burgers);
		pc.add(glasses);
		pc.add(sit);
		pc.add(toys);
		pc.add(prunes);
		add(pc, "Center");
	}

	public void actionPerformed(ActionEvent ae) {
//		ae.getActionCommand();
		int age = Integer.parseInt(textfield.getText());
		
		// Initialize the state of the check boxes
		// to false each time the button is pressed
		run.setState(false);
		burgers.setState(false);
		glasses.setState(false);
		sit.setState(false);
		toys.setState(false);
		prunes.setState(false);
		
		if(age < 21) {
			run.setState(true);
			toys.setState(true);
			burgers.setState(true);
		}
		else if ((age >= 21) && (age<=35)) {
			run.setState(true);
			toys.setState(true);
			burgers.setState(true);
		}
		else if ((age >= 36) && (age<=60)) {
			burgers.setState(true);
			glasses.setState(true);
			sit.setState(true);
			toys.setState(true);
		}
		else {
			glasses.setState(true);
			sit.setState(true);
			toys.setState(true);
			prunes.setState(true);
		}
		
		textfield.setText("");
	}
}

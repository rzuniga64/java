package com.caveofprogramming.designpatterns.mvc.view;

import javax.swing.JFrame;

import com.caveofprogramming.designpatterns.mvc.model.Model;

public class View extends JFrame {
	
	private Model model;

	public View(Model model) {
		super("MVC Demo");
		
		this.model = model;
	}
	
	

}

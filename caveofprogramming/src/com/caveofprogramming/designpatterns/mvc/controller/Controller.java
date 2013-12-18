package com.caveofprogramming.designpatterns.mvc.controller;

import com.caveofprogramming.designpatterns.mvc.model.Model;
import com.caveofprogramming.designpatterns.mvc.view.View;

public class Controller {
	private View view;
	private Model model;
	
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	
}

package com.caveofprogramming.designpatterns.mvc;

import javax.swing.SwingUtilities;

import com.caveofprogramming.designpatterns.mvc.controller.Controller;
import com.caveofprogramming.designpatterns.mvc.model.Model;
import com.caveofprogramming.designpatterns.mvc.view.View;

public class Application {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				runApp();
			}
			
		});
	}
	
	public static void runApp() {
		Model model = new Model();
		View view = new View(model);

		Controller controller = new Controller(view, model);
	}

}

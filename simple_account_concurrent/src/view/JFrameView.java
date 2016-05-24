package view;

import controller.Controller;
import model.AbstractModel;
import model.Model;
import model.ModelListener;

import javax.swing.*;

/**
 * The type J frame view.
 */
abstract public class JFrameView extends JFrame implements View, ModelListener {
	private Model model;
	private Controller controller;

	/**
	 * Instantiates a new J frame view.
	 *
	 * @param model      the model
	 * @param controller the controller
	 */
	public JFrameView(Model model, Controller controller){
		setModel(model);
		setController(controller);
	}
	private void registerWithModel(){
		((AbstractModel)model).addModelListener(this);
	}
	public Controller getController(){return controller;}
	
	public void setController(Controller controller){this.controller = controller;}
	
	public Model getModel(){return model;}
	
	public void setModel(Model model) {
		this.model = model;
		registerWithModel();
	}
}

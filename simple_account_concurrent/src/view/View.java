package view;

import controller.Controller;
import model.Model;

/**
 * The interface View.
 */
public interface View {
	/**
	 * Gets controller.
	 *
	 * @return the controller
	 */
	Controller getController();

	/**
	 * Sets controller.
	 *
	 * @param controller the controller
	 */
	void setController(Controller controller);

	/**
	 * Gets model.
	 *
	 * @return the model
	 */
	Model getModel();

	/**
	 * Sets model.
	 *
	 * @param model the model
	 */
	void setModel(Model model);
}

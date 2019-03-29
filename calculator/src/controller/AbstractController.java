package controller;
import model.Model;
import view.View;

/**
 * The type Abstract controller.
 */
public abstract class AbstractController implements Controller {
	private View view;
	private Model model;

	/**
	 * Set model.
	 * @param model the model
	 */
	public void setModel(Model model){this.model = model;}

	/**
	 * Get model model.
	 * @return the model
	 */
	public Model getModel(){return model;}

	/**
	 * Get view view.
	 * @return the view
	 */
	public View getView(){return view;}

	/**
	 * Set view.
	 * @param view the view
	 */
	public void setView(View view){this.view = view;}

}

package calculator.controller;
import calculator.model.Model;
import calculator.view.View;

public interface Controller {

	void setModel(Model model);
	Model getModel();
	View getView();
	void setView(View view);
}

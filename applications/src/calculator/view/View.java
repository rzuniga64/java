package calculator.view;
import calculator.model.Model;
import calculator.controller.Controller;

public interface View {
	Controller getController();
	void setController(Controller controller);
	Model getModel();
	void setModel(Model model);
}

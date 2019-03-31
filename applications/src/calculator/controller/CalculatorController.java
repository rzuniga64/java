package calculator.controller;
import calculator.model.Digit5;
import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;
import calculator.view.JFrameView;

public class CalculatorController extends AbstractController {

	public CalculatorController(){
		setModel(new CalculatorModel());
		setView(new CalculatorView((CalculatorModel)getModel(), this));
		((JFrameView)getView()).setVisible(true);
	}

	public void operation(String option){

		switch (option) {
			case CalculatorView.MINUS:
				((CalculatorModel) getModel()).subtract();
				break;
			case CalculatorView.MULP:
				((CalculatorModel) getModel()).mulp();
				break;
			case CalculatorView.PLUS:
				try {
					((CalculatorModel) getModel()).add();
				} catch (Digit5 ex) {
					System.out.println(ex.getMessage());
				}
				break;
			case CalculatorView.CLEAR:
				((CalculatorModel) getModel()).clear();
				break;
			case CalculatorView.EQUALS:
				((CalculatorModel) getModel()).equals();
				break;
			default:
				((CalculatorModel) getModel()).store(Integer.parseInt(option));
				break;
		}
	}
}

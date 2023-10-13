package calculatorBasicJava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
	
	private String operator = "";	// Field to save operator
	private int x = 0;
	private Cal cal = new Cal();	// Create Object to calculate
	
	@FXML TextField func, result;
	@FXML
	private void operand(ActionEvent e) {
		func.setText(func.getText() + (((Button) e.getSource()).getText()));
	}
	
	// 버튼 텍스트값 받아 수식의 아이디인 func 에 저장
	@FXML
	private void operator(ActionEvent e) {
		// if value of button is "계산"
		if(((Button) e.getSource()).getText().equals("계산"))
		{
			result.setText(cal.calculate(operator, x,
					Integer.parseInt(func.getText()))+"");
			func.setText(""); 	// After calculating, delete content in oper.
		}
		// if value of button is "CE"
		else if(((Button) e.getSource()).getText().equals("CE"))
		{
			func.setText("0");
		}
		// else operator
		else {
			operator = ((Button) e.getSource()).getText();
			x = Integer.parseInt(func.getText());
			func.setText("");
		}
	}
}

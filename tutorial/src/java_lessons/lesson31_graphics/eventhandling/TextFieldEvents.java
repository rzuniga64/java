package java_lessons.lesson31_graphics.eventhandling;


import java.applet.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class TextFieldEvents extends Applet implements ActionListener, TextListener {
	private TextField tf;
	private TextArea ta;
	
	public void init() {
		tf = new TextField(20);
		tf.addActionListener(this);
		tf.addTextListener(this);
		add(tf);
		ta = new TextArea(10,20);
		add(ta);
	}
	
	public void actionPerformed(ActionEvent ae) {
		ta.append("ActionEvent: " + ae.getActionCommand() + "\n");
		tf.setText("");
	}
	
	public void textValueChanged(TextEvent te) {
		ta.append("TextEvent:" + tf.getText() + "\n");
	}
}

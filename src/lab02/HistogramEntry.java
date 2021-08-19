package lab02;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HistogramEntry {
	public static JPanel createPanel(HistogramComponent histComponent) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2));
		JTextField row1 = new JTextField();
		JTextField row2 = new JTextField();
		JTextField row3 = new JTextField();
		JTextField row4 = new JTextField();
		ActionListener listener = event -> histComponent.report(row1.getText(), row2.getText(), row3.getText(),
				row4.getText());
		row1.addActionListener(listener);
		row2.addActionListener(listener);
		row3.addActionListener(listener);
		row4.addActionListener(listener);
		panel.add(new JLabel("Row 1 quantity:"));
		panel.add(row1);
		panel.add(new JLabel("Row 2 quantity:"));
		panel.add(row2);
		panel.add(new JLabel("Row 3 quantity:"));
		panel.add(row3);
		panel.add(new JLabel("Row 4 quantity:"));
		panel.add(row4);
		return panel;
	}
}

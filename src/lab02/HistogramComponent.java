package lab02;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

// HistogramComponent extends the functionality of a JComponent
// in order to draw a histogram.
public class HistogramComponent extends JComponent {

	private static final long serialVersionUID = -1482284798298563216L;

	int row1Number = 1;
	int row2Number = 1;
	int row3Number = 1;
	int row4Number = 1;

	public void report(String row1, String row2, String row3, String row4) {
		try {
			row1Number = Integer.parseInt(row1.trim());
			row2Number = Integer.parseInt(row2.trim());
			row3Number = Integer.parseInt(row3.trim());
			row4Number = Integer.parseInt(row4.trim());
			repaint();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Invalid entry in a text field");
		}
	}

	// Paints a histogram with three bins
	@Override
	public void paintComponent(Graphics g) {
		// Cast to Graphics2D
		Graphics2D graphicsObj = (Graphics2D) g;

		int total = row1Number + row2Number + row3Number + row4Number;
		int width1 = (int) (400.0 * row1Number / total);
		int width2 = (int) (400.0 * row2Number / total);
		int width3 = (int) (400.0 * row3Number / total);
		int width4 = (int) (400.0 * row4Number / total);
		System.out.println(width1 + " " + width2 + " " + width3 + " " + width4);

		// change the height of each bin from 50 -> 25; inteval between bins is 15
		// change the offset (Y position of upper left point) of each bin
		/*
		 * 10--> 35 || 50 -> 75 || 90 -> 115 || 130 -> 155
		 */
		// Draw 1st bin as an olive colored rectangle at (10,10)
		Rectangle binRectangle1 = new Rectangle(10, 10, width1, 25);
		Color binColor1 = new Color(128, 128, 0);
		graphicsObj.setColor(binColor1);
		graphicsObj.fill(binRectangle1);

		// Draw 2nd bin as a teal blue rectangle at (10,50)
		Rectangle binRectangle2 = new Rectangle(10, 50, width2, 25);
		Color binColor2 = new Color(0, 200, 200);
		graphicsObj.setColor(binColor2);
		graphicsObj.fill(binRectangle2);

		// Draw 3rd bin as a gray rectangle at (10,90)
		Rectangle binRectangle3 = new Rectangle(10, 90, width3, 25);
		Color binColor3 = new Color(100, 100, 100);
		graphicsObj.setColor(binColor3);
		graphicsObj.fill(binRectangle3);

		// Draw 4th bin as a red rectangle at (10,130)
		Rectangle binRectangle4 = new Rectangle(10, 130, width4, 25);
		Color binColor4 = new Color(255, 0, 0);
		graphicsObj.setColor(binColor4);
		graphicsObj.fill(binRectangle4);
	}
}
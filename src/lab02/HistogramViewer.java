package lab02;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class HistogramViewer {
	public static void main(String[] args) {
		JFrame appFrame = new JFrame();
		HistogramComponent histogramComponent = new HistogramComponent();

		appFrame.setSize(450, 300);
		appFrame.setTitle("Histogram Viewer");
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add the HistogramComponent object to the frame
		appFrame.add(histogramComponent);
		appFrame.add(HistogramEntry.createPanel(histogramComponent), BorderLayout.PAGE_START);

		// Set the frame and its contents visible
		appFrame.setLocationRelativeTo(null);
		appFrame.setVisible(true);
	}
}
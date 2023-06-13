package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TimerPanel extends JPanel {

	private int seconds;
	public JLabel timerLabel;
	public Timer timer;
	private static final TimerPanel timerPanel = new TimerPanel();
	public static TimerPanel getInstance() {
		return timerPanel;
	}

	private TimerPanel() {
		this.setPreferredSize(new Dimension(900, 100));
		timerLabel = new JLabel();
		timerLabel.setSize(this.getPreferredSize());
		timerLabel.setFont(new Font("Arial", Font.BOLD, 50));
		timerLabel.setHorizontalAlignment(JLabel.CENTER);
		timerLabel.setVerticalAlignment(JLabel.CENTER);

		this.add(timerLabel, BorderLayout.CENTER);

		// Jede Sekunden, mach...
		ActionListener actionListener = e -> {
			seconds++;
			timerLabel.setText(seconds + " ");
		};

		timer = new Timer(1000, actionListener);
	}
	public int getSeconds() {
		return seconds;
	}
	public void resetTimer() {
		this.timer.stop();
		this.seconds = 0;
	}
}

package UI;

import GameLogic.BermudaSpiel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButton extends JButton {

	public ResetButton() {
		this.setText("Restart Game");
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TimerPanel.getInstance().timerLabel.setVisible(false);
				TimerPanel.getInstance().resetTimer();

				BermudaSpiel.getInstance().resetFlotte();

				BermudaPanel.getInstance().resetSpielfelder();

				Point test = new Point();

				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 7; j++) {
						test.setLocation(i, j);
						BermudaSpiel.getInstance().search(test);
					}
				}
			}
		});
	}
}

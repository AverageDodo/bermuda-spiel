package UI;

import GameLogic.BermudaSpiel;
import GameLogic.Scores;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Objects;

public class Spielfelder extends JPanel {
	@SuppressWarnings("FieldMayBeFinal")
	public JLabel label;
	public Point panelPosition = new Point();
	public MouseListener mouseListener;
	public ArrayList<Point> revealOnClick = new ArrayList<>();
	public int clickCounter;

	public Spielfelder(int x, int y) {
		this.clickCounter = 0;
		this.panelPosition.setLocation(x, y);
		revealOnClick.add(0, panelPosition);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.white);

		mouseListener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickCounter++;
				if (clickCounter == 1) {
					TimerPanel.getInstance().timer.start();
					TimerPanel.getInstance().timerLabel.setVisible(true);
				}

				if (Objects.equals(label.getText(), "X")) {
					BermudaSpiel.getInstance().getFlotte().setSchiffGefunden(panelPosition);

				}

				if (e.getButton() == MouseEvent.BUTTON1) {
					if (clickCounter / 2 == 0) {
						for (Point p : revealOnClick) {
							revealPanel(p);
						}
					}
				} else {
					if (getBackground() == Color.red) {
						deselectPanel(panelPosition);
					} else {
						selectPanel(panelPosition);
					}
				}
				if (BermudaSpiel.getInstance().getFlotte().gewonnen()) {
					TimerPanel.getInstance().timer.stop();
					String name = JOptionPane.showInputDialog(BermudaPanel.getInstance(), "Please enter your name!");
					Scores.getInstance().addScore(TimerPanel.getInstance().getSeconds(), name);
					JOptionPane.showMessageDialog(BermudaPanel.getInstance(), Scores.getInstance().printScores());
				}
			}
		};

		this.addMouseListener(mouseListener);

		this.setBorder(new LineBorder(Color.BLACK, 2, true));
		this.setVisible(true);

		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(label, BorderLayout.CENTER);
		label.setVisible(false);
	}
	public void setLabel(String str) {
		label.setText(str);
	}
	public void revealPanel(Point p) {
		BermudaPanel.getInstance().getPanel(p).setBackground(Color.red);
		BermudaPanel.getInstance().getPanel(p).label.setVisible(true);
	}
	public void hidePanel(Point p) {
		BermudaPanel.getInstance().getPanel(p).setBackground(Color.white);
		BermudaPanel.getInstance().getPanel(p).label.setVisible(false);
	}
	public void selectPanel(Point p) {
		BermudaPanel.getInstance().getPanel(p).setBackground(Color.red);
	}
	public void deselectPanel(Point p) {
		BermudaPanel.getInstance().getPanel(p).setBackground(Color.white);
	}
	public void givePanels(ArrayList<Point> arrayList) {
		if (arrayList != null) {
			this.revealOnClick.addAll(arrayList);
		}
	}
	public void resetPanel() {
		this.setBackground(Color.white);
		this.label.setText("");
		this.label.setVisible(false);
		this.revealOnClick.clear();
	}
}

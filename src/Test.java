import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame {
	private JLabel timerLabel;
	private int seconds;

	public Test() {
		super("Timer Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setLocationRelativeTo(null);

		JPanel contentPane = new JPanel(new BorderLayout());

		timerLabel = new JLabel("0");
		timerLabel.setFont(new Font("Arial", Font.BOLD, 50));
		timerLabel.setHorizontalAlignment(JLabel.CENTER);

		contentPane.add(timerLabel, BorderLayout.CENTER);

		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seconds++;
				timerLabel.setText(Integer.toString(seconds));
			}
		};

		Timer timer = new Timer(1000, actionListener);
		timer.start();

		setContentPane(contentPane);
	}

	public static void main(String[] args) {
		Test example = new Test();
		example.setVisible(true);
	}
}

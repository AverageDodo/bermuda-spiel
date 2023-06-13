package UI;

import javax.swing.*;

public class BermudaFrame extends JFrame {
    public JPanel mainPanel;
    private static final BermudaFrame frameInstance = new BermudaFrame();
    public static BermudaFrame getInstance() {
        return frameInstance;
    }

    private BermudaFrame() {
        this.setSize(900, 700);
        this.setTitle("Bermudaspiel");
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.add(TimerPanel.getInstance());
        topPanel.add(new ResetButton());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(BermudaPanel.getInstance());

        mainPanel.add(topPanel);
        mainPanel.add(bottomPanel);

        this.add(mainPanel);
        this.setVisible(true);
    }
}
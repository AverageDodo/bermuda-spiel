package UI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BermudaFrame extends JFrame {
    public JPanel mainPanel;
    public JLayeredPane layeredPane;
    private static BermudaFrame frameInstance = new BermudaFrame();
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
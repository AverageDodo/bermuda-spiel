package UI;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("CanBeFinal")
public class BermudaPanel extends JPanel {

    private Spielfelder[][] spielfelders;
    private static final BermudaPanel panelInstance = new BermudaPanel();
    public static BermudaPanel getInstance() {
        return panelInstance;
    }

    private BermudaPanel() {
        this.setPreferredSize(new Dimension(900, 700));
        this.setLayout(new GridLayout(9, 7, 1, 1));
        spielfelders = new Spielfelder[9][7];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                spielfelders[i][j] = new Spielfelder(i, j);
                this.add(spielfelders[i][j]);
            }
        }
    }

    public Spielfelder getPanel(Point p) {
        return this.spielfelders[p.x][p.y];
    }

    public void resetSpielfelder() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                spielfelders[i][j].resetPanel();
            }
        }
    }

}

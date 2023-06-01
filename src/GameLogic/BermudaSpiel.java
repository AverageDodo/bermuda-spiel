package GameLogic;

import UI.BermudaPanel;
import UI.BermudaFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BermudaSpiel {
    private Flotte flotte;
    public static BermudaSpiel getInstance() {
        return spielInstance;
    }
    private static BermudaSpiel spielInstance = new BermudaSpiel();

    private BermudaSpiel() {
        flotte = new Flotte(4);
    }
    private ArrayList<Point> checkedPanels = new ArrayList<>();

    public void search(Point point) {
        if (flotte.istHierSchiff(point)) {
            BermudaPanel.getInstance().getPanel(point).setLabel("X");

        } else {
            checkedPanels.clear();
            int inSicht = 0;

            inSicht += directionalSearch(point, -1, -1);
            inSicht += directionalSearch(point, -1, 0);
            inSicht += directionalSearch(point, -1, 1);
            inSicht += directionalSearch(point, 0, -1);
            inSicht += directionalSearch(point, 0, 1);
            inSicht += directionalSearch(point, 1, -1);
            inSicht += directionalSearch(point, 1, 0);
            inSicht += directionalSearch(point, 1, 1);

            BermudaPanel.getInstance().getPanel(point).setLabel(String.valueOf(inSicht));
            if (inSicht == 0) {
                BermudaPanel.getInstance().getPanel(point).givePanels(checkedPanels);
            }
        }
    }

    public int directionalSearch(Point p, int dx, int dy) {
        int anzahlGefunden = 0;
        Point b = new Point(p.x + dx, p.y + dy);

        while (b.x >= 0 && b.x < 9 && b.y >= 0 && b.y < 7) {
            if (flotte.istHierSchiff(b)) {
                anzahlGefunden += 1;
            }
            checkedPanels.add(new Point(b));
            b.translate(dx, dy);
        }
        return anzahlGefunden;
    }
    public Flotte getFlotte() {
        return flotte;
    }

    public void resetFlotte() {
        this.flotte = new Flotte(4);
    }
}

package GameLogic;

import java.awt.*;
import java.util.Random;

public class Schiff {
    
    private boolean gefunden;
    final Point p;

    public Schiff() {
        Random ran = new Random();
        p = new Point(ran.nextInt(9), ran.nextInt(7));
        gefunden = false;
    }

    public Schiff(Point point) {
        p = new Point(point);
    }

    public boolean istGefunden() {
        return this.gefunden;
    }

    public void setGefunden() {
        this.gefunden = true;
    }

}
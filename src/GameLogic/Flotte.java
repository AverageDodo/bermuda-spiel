package GameLogic;

import java.awt.*;
import java.util.Vector;

public class Flotte extends Schiff {

    private final Vector<Schiff> flotte;

    public Flotte(int Anzahl) {
        super();

        flotte = new Vector<>();
        for (int i = 0; i < Anzahl; i++) {
            flotte.add(new Schiff());

            for (int j = 0; j < i; j++) {
                //noinspection ConstantValue
                if (i != 0 && flotte.elementAt(i).equals(flotte.elementAt(j))) {
                    i -= 1;
                }
            }
        }
    }

    public Vector<Schiff> getFlotte() {
        return flotte;
    }

    public boolean gewonnen() {
        for (Schiff s : flotte) {
            if(!s.istGefunden()) {
                return false;
            }
        }
        return true;
    }

    public boolean istHierSchiff(Point suchPunkt) {
        for (Schiff schiff : flotte) {
            if (schiff.p.equals(suchPunkt)) {
                return true;
            }
        }
        return false;
    }
    public void setSchiffGefunden(Point point) {
        for (Schiff s : flotte) {
            if (s.p.equals(point)) {
                s.setGefunden();
                return;
            }
        }
    }
}
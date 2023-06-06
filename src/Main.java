import GameLogic.BermudaSpiel;
import GameLogic.Scores;
import UI.BermudaFrame;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        BermudaFrame frame = BermudaFrame.getInstance();
        BermudaSpiel spiel = BermudaSpiel.getInstance();
        Scores scores = Scores.getInstance();

        Point test = new Point();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                test.setLocation(i, j);
                spiel.search(test);
            }
        }

        Runtime.getRuntime().addShutdownHook(new Thread(scores::saveScores));
    }
}

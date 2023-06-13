package GameLogic;

import UI.BermudaPanel;

import javax.swing.*;
import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Scores {

	private final static Scores scoresInstance = new Scores();
	public static Scores getInstance() {
		return scoresInstance;
	}
	//Bestimmt den Speicherort für die Scores-Datei
	private final String fileName = System.getProperty("user.dir") + "/src/scores.txt";
	private final Map<Integer, String> sortedScores = new TreeMap<>();

	private Scores() {
		loadScores();
	}

	private void loadScores() {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("=");
				sortedScores.put(Integer.parseInt(split[0]), split[1]);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(BermudaPanel.getInstance(), "Error loading scores");
		}
	}

	public void addScore(int score, String name) {
		sortedScores.put(score, name);
	}

	public void saveScores() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			for (Map.Entry<Integer, String> entry : sortedScores.entrySet()) {
				writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(BermudaPanel.getInstance(), "Error saving scores");
		}
	}

	public String printScores() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			sb.append(sortedScores.keySet().toArray()[i]).append("=").append(sortedScores.get(sortedScores.keySet().toArray()[i])).append("\n");
		}
		return sb.toString();
	}
}

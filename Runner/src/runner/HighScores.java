package runner;

import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class HighScores
{
	private static String name = "";
	private static float passed = Paint.passed;
	private static float effic = Paint.score;

	public static void writeScores() {
		try
		{
			// open file to write to
			FileOutputStream saveFile = new FileOutputStream(
					"resources/Scores.sav");

			// object output stream to put objects into save file
			ObjectOutputStream save = new ObjectOutputStream(saveFile);

			// add to save file
			save.writeObject(name);
			save.writeObject(passed);
			save.writeObject(effic);

			save.close();
		} catch (Exception exc)
		{
			exc.printStackTrace(); // If there was an error, print the info.
		}
	}

	public static void readScores() {
		try
		{

			// open the file to read from
			FileInputStream saveFile = new FileInputStream(
					"resources/Scores.sav");

			// get objects from the save
			ObjectInputStream save = new ObjectInputStream(saveFile);

			name = (String) save.readObject();
			passed = (float) save.readObject();
			effic = (float) save.readObject();

			save.close();

		} catch (Exception exc)
		{
			exc.printStackTrace(); // If there was an error, print the info.

		}

		System.out.println("Name: " + name);
		System.out.println("Passed: " + passed);
		System.out.println("Efficiency: " + effic);

	}

	public static void addScore(String n, float pass, float e) {
		if(pass > passed)
		{
			name = n;
			passed = pass;
			effic = e;
		}

	}

	public static void highScore(Graphics g) {
		g.drawString("High Score: " + name, 10, 20);
		g.drawString(passed + " obstacles", 10, 40);
		g.drawString("Efficiency: " + effic + "%", 10, 60);
	}

}

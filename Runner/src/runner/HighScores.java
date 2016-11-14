package runner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class HighScores
{
	private static ArrayList<String> names = new ArrayList<String>();
	private static ArrayList<Float> passed = new ArrayList<Float>();
	private static ArrayList<Float> effic = new ArrayList<Float>();

	public static void writeScores() {
		try
		{
			// open file to write to
			FileOutputStream saveFile = new FileOutputStream("Scores.sav");

			// object output stream to put objects into save file
			ObjectOutputStream save = new ObjectOutputStream(saveFile);

			// add to save file
			save.writeObject(names);
			save.writeObject(passed);
			save.writeObject(effic);

			save.close();
		} catch (Exception exc)
		{
			exc.printStackTrace(); // If there was an error, print the info.
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void readScores() {
		try
		{
			// open the file to read from
			FileInputStream saveFile = new FileInputStream("Scores.sav");

			// get objects from the save
			ObjectInputStream save = new ObjectInputStream(saveFile);

			names = (ArrayList<String>) save.readObject();
			passed = (ArrayList) save.readObject();
			effic = (ArrayList) save.readObject();

			save.close();
		} catch (Exception exc)
		{
			exc.printStackTrace(); // If there was an error, print the info.
		}

		System.out.println("Names: " + names);
		System.out.println("Passed: " + passed);
		System.out.println("Efficiency: " + effic);

	}

	public static void addScore(String name, float pass, float e) {
		if(names.size() <= 5)
		{
			names.add(name);
		}

		if(passed.size() <= 5)
		{
			passed.add(pass);
		}

		if(effic.size() <= 5)
		{
			effic.add(e);
		}
	}
}

package runner.obstacles;

import java.util.Random;

/*
 * This class will create the obstacles that get spawned into the screen
 */
public class CreateObstacles
{
	// x size
	private static int sx = 0;

	// getter for size x
	public static int getSX() {
		return sx;
	}

	private static Random rn = new Random();

	// pick the shape to spawn
	public static int pickShape() {
		int num = rn.nextInt(2 - 0 + 1) + 0;
		getShape(num);
		return sx;
	}

	// get the shape that corresponds to the index
	private static void getShape(int ind) {
		switch(ind)
		{
		case 0:
			smSq();
			break;

		case 1:
			medSq();
			break;

		case 2:
			larSq();
			break;
		}
	}

	// small square 30 * 30
	private static void smSq() {

		sx = 30;
	}

	// med square 60 * 30
	private static void medSq() {

		sx = 60;
	}

	// large square 120 * 30
	private static void larSq() {
		sx = 120;
	}

}

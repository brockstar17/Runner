package runner.player;

import runner.Runner;

/*
 * These methods will track the changes to the player's
 * block, 
 */
public class Player
{

	private static int pYPos = 425; // starting y pos
	// where to stop dec
	public static int stopD = 425; // to start

	private static int dVel = 0; // downward velocity

	public static void jump() {
		pYPos -= 50;
	}

	// changes the down vel to vel parameter
	public static void fall(int vel) {
		dVel = vel;
	}

	// used for decreasing the player block position
	public static void decPos(int decrement) {
		if(pYPos <= stopD)
			pYPos += decrement;
		else if(pYPos > stopD)
		{
			dVel = 0;
			pYPos = stopD;
		}

	}

	// return the y pos of the player block
	public static int getPlayer() {
		if(Runner.getDucking())
			return pYPos + 10;
		else
			return pYPos;
	}

	// returns the downward velocity (falling speed)
	public static int getDVel() {
		return dVel;
	}

	// set the stop pos
	public static void setStopD(int Y) {
		stopD = Y;
	}

	public static int duck() {
		if(Runner.getDucking())
			return 20;
		else
			return 30;
	}
}

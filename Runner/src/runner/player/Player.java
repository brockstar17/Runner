package runner.player;

import runner.Paint;
import runner.Runner;

/*
 * These methods will track the changes to the player's
 * block, 
 */
public class Player
{

	private static int pYPos = 425; // starting y pos
	private static int yadd = 0;
	// where to stop dec
	public static int stopD = 425; // to start

	private static int dVel = 0; // downward velocity

	private static boolean canJump = true; // only allow one jump (for now)
	public static boolean isJump = false;

	public static void jump() {
		if(canJump)
		{
			Paint.jumps++;
			pYPos -= 55;
			Runner.numAway = 40;
			canJump = false;
		}

	}

	/*
	 * Point p = new Point(115, 440); CalcJumpRotation.calcRot(p, 45, 100, 425);
	 */

	// changes the down vel to vel parameter
	public static void fall(int vel) {
		dVel = vel;
	}

	private static float accl = 0.02f;

	// used for decreasing the player block position
	public static void decPos(int decrement) {

		if((pYPos + (int) decrement + accl) < stopD)
		{
			pYPos += (int) decrement + accl;
			yadd = pYPos - 425;
			accl += accl;
		}

		else if(pYPos >= stopD)
		{
			pYPos = stopD;
			yadd = 0;
			accl = 0.02f;
			canJump = true;
			isJump = false;
		}
		else
		{
			yadd = 0;
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

	public static int getYadd() {
		return yadd;
	}

}

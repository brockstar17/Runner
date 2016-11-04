package runner;

import runner.player.Player;

public class GameOver
{
	/*
	 * Check to see if the game is over
	 */

	public static boolean isGameOver(int leadX, int obstacle, int topY) {

		switch (obstacle)
		{
		case 0:
			// the triangle
			if (130 >= leadX && !Player.isJump && leadX >= 100)
				return true;
			break;

		case 1:
			// the overhang
			if (130 >= leadX && 100 <= leadX + 60 && !Runner.getDucking())
				return true;
			break;

		}

		return false;
	}
}

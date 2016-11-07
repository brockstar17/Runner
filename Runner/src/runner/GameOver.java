package runner;

import runner.player.Player;

public class GameOver
{
	/*
	 * Check to see if the game is over
	 */

	public static boolean isGameOver(int leadX, int obstacle, int topY) {

		switch(obstacle)
		{
		case 0:
			// the triangle
			if(130 >= leadX && !Player.isJump && leadX >= 100) // first
				return true;
			// first land
			if(leadX + 20 >= 100 && leadX + 20 <= 130 && !Player.isJump)
				return true;

			if(130 >= leadX + 160 && !Player.isJump && leadX + 160 >= 100) // second
				return true;
			// second land
			if(leadX + 180 >= 100 && leadX + 180 <= 130 && !Player.isJump)
				return true;

			if(130 >= leadX + 320 && !Player.isJump && leadX + 320 >= 100) // third
				return true;
			// third land
			if(leadX + 340 >= 100 && leadX + 340 <= 130 && !Player.isJump)
				return true;
			break;

		case 1:
			// the overhang
			if(130 >= leadX && 100 <= leadX + 60 && !Runner.getDucking())
				return true;
			break;

		}

		return false;
	}
}

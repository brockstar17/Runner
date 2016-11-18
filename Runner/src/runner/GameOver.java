package runner;

import runner.graphics.Paint;
import runner.player.Player;

public class GameOver
{
	/*
	 * Check to see if the game is over
	 */

	public static boolean isGameOver(int leadX, int obstacle) {

		switch (obstacle)
		{
		case 0:
			// the triangle
			if (130 >= leadX && !Player.isJump && leadX >= 100) // first
				return true;
			// first land
			if (leadX + 25 >= 100 && leadX + 20 <= 130 && !Player.isJump)
				return true;

			if (130 >= leadX + Paint.space && !Player.isJump && leadX + 160 >= 100) // second
				return true;
			// second land
			if (leadX + Paint.space + 25 >= 100 && leadX + 180 <= 130 && !Player.isJump)
				return true;

			if (130 >= leadX + 160 + Paint.space && !Player.isJump && leadX + 320 >= 100) // third
				return true;
			// third land
			if (leadX + 160 + Paint.space + 25 >= 100 && leadX + 340 <= 130 && !Player.isJump)
				return true;
			break;

		case 1:
			// the overhang
			if (130 >= leadX && 100 <= leadX + 60 && !Runner.getDucking())
				return true;
			break;

		case 2:
			// triangle followed by overhang
			// the triangle
			if (130 >= leadX && !Player.isJump && leadX >= 100) // first
				return true;
			// first land
			if (leadX + 25 >= 100 && leadX + 20 <= 130 && !Player.isJump)
				return true;

			// the overhang
			if (130 >= leadX + 180 && 100 <= leadX + 240 && !Runner.getDucking())
				return true;

			break;

		case 3:

			// the pit
			if (120 >= leadX && !Player.isJump && leadX >= 80)
				return true;

			break;

		}

		return false;
	}

}

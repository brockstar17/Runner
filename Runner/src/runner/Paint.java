package runner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JPanel;

import runner.obstacles.Overhang;
import runner.obstacles.Pit;
import runner.obstacles.Triangle;
import runner.player.Player;
import runner.player.RotationHandler;

@SuppressWarnings("serial")
public class Paint extends JPanel
{
	public static boolean isOPassed = true;
	public static float passed = 0;
	public static float jumps = 0;
	public static float score;

	private static Random rand = new Random();
	private int num = rand.nextInt(3 + 1);
	private int numt = rand.nextInt(3) + 1;
	public static int space = rand.nextInt(200 - 160 + 1) + 160;

	private int textNum = 0;

	private Image hills = Toolkit.getDefaultToolkit().createImage("resources/RollingHills.png");
	private Image hill2 = Toolkit.getDefaultToolkit().createImage("resources/Hills2.png");
	private Image night = Toolkit.getDefaultToolkit().createImage("resources/night.png");
	private Image night2 = Toolkit.getDefaultToolkit().createImage("resources/night2.png");

	private boolean upText = false;

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(getBackImage(textNum)[0], 0, 0, null);
		// g.drawImage(hills, 0, 0, null);

		if (passed % 15 == 0 && passed > 0)
		{

			if (textNum < 1 && upText)
			{
				textNum++;
				upText = false;

			}
			else if (upText)
			{
				textNum = 0;
				upText = false;

			}

		}

		if (passed % 16 == 0 && passed > 0)
		{
			upText = true;

		}

		if (Runner.shouldUPPos)
		{
			g.drawImage(getBackImage(textNum)[0], Runner.pPos - 600, 0, Runner.pPos, 560, 0, 0, 600, 560, null);
			g.drawImage(getBackImage(textNum)[1], Runner.pPos, 0, Runner.pPos + 600, 560, 0, 0, 600, 560, null);
			g.drawImage(getBackImage(textNum)[0], Runner.pPos + 600, 0, Runner.pPos + 1200, 560, 0, 0, 600, 560, null);
			if (Runner.pPos == -600)
			{
				Runner.altPpos = -1200;
				Runner.shouldUPPos = false;
			}
		}
		else
		{
			g.drawImage(hills, Runner.altPpos - 600, 0, Runner.altPpos, 560, 0, 0, 600, 560, null);
			g.drawImage(hill2, Runner.altPpos, 0, Runner.altPpos + 600, 560, 0, 0, 600, 560, null);
			g.drawImage(hills, Runner.altPpos + 600, 0, Runner.altPpos + 1200, 560, 0, 0, 600, 560, null);
			if (Runner.altPpos + 600 <= 620)
			{
				Runner.pPos = 600;
				Runner.shouldUPPos = true;
			}
		}

		// -------------------Handle game over screen --------------------\\

		if (Runner.gameOver)
		{
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 600, 600);
			g.setColor(Color.ORANGE);

			g.drawString("Game Over", this.getWidth() / 2 - 20, this.getHeight() / 2);
			g.drawString("You cleared " + (int) passed + " obstacles with " + score * 100 + "% efficiency.",
					(int) (this.getWidth() / 2 - 110), this.getHeight() / 2 + 15);
			g.drawString("Press R to play again", this.getWidth() / 2 - 45, this.getHeight() / 2 + 30);

			HighScores.highScore(g);

		}

		// ------------------Handle player icon
		// ------------------------------------\\

		else
		{
			g.setColor(Color.GREEN);
			g.fillRect(0, 455, 600, 20);

			g.setColor(Color.RED);
			if (Player.isJump)
				RotationHandler.drawRotPlayer(g);
			else if (Runner.numAway > 0)
			{
				RotationHandler.drawRetPlayer(g);
				Runner.numAway -= 3;
			}
			else
				g.fillRect(100, Player.getPlayer(), 30, Player.duck());

			g.setColor(Color.BLACK);

			// ----------------------Switch that handles obstacle
			// spawning---------------------------------------------------\\

			switch (num)
			{
			case 0:

				Runner.gameOver = GameOver.isGameOver(Runner.xPos - 20, num);
				Triangle.paintT(g, numt, space);
				break;

			case 1:
				Runner.gameOver = GameOver.isGameOver(Runner.xPos, num);
				Overhang.paintO(g);
				break;

			case 2:
				Runner.gameOver = GameOver.isGameOver(Runner.xPos, num);
				Triangle.paintT(g, 1, 0);
				Overhang.paintOwithT(g);
				break;

			case 3:
				Runner.gameOver = GameOver.isGameOver(Runner.xPos, num);
				Pit.paintH(g);
				break;
			}

			// ---------------------------Handle when the object has passed the
			// player------------------------------------\\

			if (Runner.xPos <= 0 && num == 1)
			{
				isOPassed = true;
				passed++;
				Runner.xPos = 600;
				num = rand.nextInt(3 + 1);
				space = rand.nextInt(200 - 160 + 1) + 160;
				if (num != 0)
					numt = rand.nextInt(3) + 1;
			}

			else if (num == 0)
			{
				if (numt == 3 && Runner.xPos + 320 <= 0)
				{
					isOPassed = true;
					passed += 3;
					Runner.xPos = 600;
					num = rand.nextInt(3 + 1);
					if (num != 0)
						numt = rand.nextInt(3) + 1;
				}
				else if (numt == 2 && Runner.xPos + 100 <= 0)
				{
					isOPassed = true;
					passed += 2;
					Runner.xPos = 600;
					num = rand.nextInt(3 + 1);
					if (num != 0)
						numt = rand.nextInt(3) + 1;
				}
				else if (numt == 1 && Runner.xPos <= 0)
				{
					isOPassed = true;
					passed += 1;
					Runner.xPos = 600;
					num = rand.nextInt(3 + 1);
					if (num != 0)
						numt = rand.nextInt(3) + 1;
				}

			}
			else if (num == 2 && Runner.xPos <= -160)
			{
				isOPassed = true;
				passed += 2;
				Runner.xPos = 600;
				num = rand.nextInt(3 + 1);
				if (num != 0)
					numt = rand.nextInt(3) + 1;
			}
			else if (num == 3 && Runner.xPos <= 0)
			{
				isOPassed = true;
				passed++;
				Runner.xPos = 600;
				num = rand.nextInt(3 + 1);
				if (num != 0)
					numt = rand.nextInt(3) + 1;
			}

			if (isOPassed)
			{
				isOPassed = false;
			}

			g.setColor(Color.WHITE);
			g.drawString("Obstacles passed: " + (int) passed, 0, 10);
			g.drawString("Movements made: " + (int) jumps, 200, 10);

			// -----------------Calculate score when jumps > zero to avoid
			// opening black hole of destructive math-------------\\
			if (jumps != 0)
			{
				score = passed / jumps;
				score = (int) (score * 100);
				score = (float) (score / 100);
			}

			g.drawString("Efficiency: " + score * 100 + "%", 400, 10);

		}

	}

	private Image[] getBackImage(int num) {
		switch (num)
		{
		case 1:
			return new Image[] { night, night2 };

		default:
			return new Image[] { hills, hill2 };
		}
	}

}

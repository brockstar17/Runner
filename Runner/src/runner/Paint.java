package runner;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import runner.obstacles.Overhang;
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

	private Random rand = new Random();
	private int num = rand.nextInt(1 + 1);
	private int numt = rand.nextInt(3) + 1;

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		setBackground(Color.BLACK);

		if(Runner.gameOver)
		{
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 600, 600);
			g.setColor(Color.MAGENTA);

			g.drawString("Game Over", this.getWidth() / 2 - 20,
					this.getHeight() / 2);
			g.drawString("You cleared " + passed + " obstacles with " + score
					* 100 + "% efficiency.",
					(int) (this.getWidth() / 2 - 110 + passed / 10),
					this.getHeight() / 2 + 15);
			g.drawString("Press R to play again", this.getWidth() / 2 - 45,
					this.getHeight() / 2 + 30);
		}
		else
		{
			g.setColor(Color.GRAY);
			g.fillRect(0, 0, 600, 20);
			g.fillRect(0, 455, 600, 20);

			g.setColor(Color.RED);
			if(Player.isJump)
				RotationHandler.drawRotPlayer(g);
			else if(Runner.numAway > 0)
			{
				RotationHandler.drawRetPlayer(g);
				Runner.numAway -= 3;
			}
			else
				g.fillRect(100, Player.getPlayer(), 30, Player.duck());

			g.setColor(Color.YELLOW);

			switch(num)
			{
			case 0:

				Runner.gameOver = GameOver.isGameOver(Runner.xPos - 20, num,
						435);
				Triangle.paintT(g, numt);
				break;
			case 1:
				Runner.gameOver = GameOver.isGameOver(Runner.xPos, num, 415);
				Overhang.paintO(g);
				break;
			}

			if(Runner.xPos <= 0 && num != 0)
			{
				isOPassed = true;
				passed++;
				Runner.xPos = 600;
				num = rand.nextInt(1 + 1);
				if(num != 0)
					numt = rand.nextInt(3) + 1;
			}

			if(num == 0)
			{
				if(numt == 3 && Runner.xPos + 320 <= 0)
				{
					isOPassed = true;
					passed += 3;
					Runner.xPos = 600;
					num = rand.nextInt(1 + 1);
					if(num != 0)
						numt = rand.nextInt(3) + 1;
				}
				else if(numt == 2 && Runner.xPos + 100 <= 0)
				{
					isOPassed = true;
					passed += 2;
					Runner.xPos = 600;
					num = rand.nextInt(1 + 1);
					if(num != 0)
						numt = rand.nextInt(3) + 1;
				}
				else if(numt == 1 && Runner.xPos <= 0)
				{
					isOPassed = true;
					passed += 1;
					Runner.xPos = 600;
					num = rand.nextInt(1 + 1);
					if(num != 0)
						numt = rand.nextInt(3) + 1;
				}
			}

			if(isOPassed)
			{
				isOPassed = false;
			}

			g.setColor(Color.MAGENTA);
			g.drawString("Obstacles passed: " + passed, 0, 40);
			g.drawString("Movements made: " + jumps,
					((18 + (int) (passed / 10)) * 10), 40);
			if(jumps != 0)
			{
				score = passed / jumps;

			}

			g.drawString("Efficiency: " + score * 100 + "%",
					((35 + (int) (passed / 10) + (int) (jumps / 10))) * 10, 40);

		}

	}
}

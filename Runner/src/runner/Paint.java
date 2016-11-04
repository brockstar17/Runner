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

	private Random rand = new Random();
	private int num = rand.nextInt(1 + 1);

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		setBackground(Color.BLACK);

		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 600, 20);
		g.fillRect(0, 455, 600, 20);

		g.setColor(Color.RED);
		if (Player.isJump)
			RotationHandler.drawRotPlayer(g);
		else
			g.fillRect(100, Player.getPlayer(), 30, Player.duck());

		g.setColor(Color.YELLOW);

		switch (num)
		{
		case 0:
			Runner.gameOver = GameOver.isGameOver(Runner.xPos - 20, num, 435);
			Triangle.paintT(g);
			break;
		case 1:
			Runner.gameOver = GameOver.isGameOver(Runner.xPos, num, 415);
			Overhang.paintO(g);
			break;
		}

		if (Runner.xPos <= 0)
		{
			isOPassed = true;
			Runner.xPos = 600;
			num = rand.nextInt(1 + 1);
		}

		if (isOPassed)
		{

			isOPassed = false;
		}

	}

}

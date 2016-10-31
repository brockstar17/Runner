package runner;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import runner.obstacles.CreateObstacles;
import runner.player.Player;

@SuppressWarnings("serial")
public class Paint extends JPanel
{
	public static boolean isOPassed = true;
	public static boolean isFirstPassed = false;

	private int xsize;

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		setBackground(Color.BLACK);

		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 600, 20);
		g.fillRect(0, 455, 600, 20);

		g.setColor(Color.RED);
		g.fillRect(100, Player.getPlayer(), 30, 30);

		g.setColor(Color.YELLOW);

		if(isFirstPassed)
		{
			g.fillRect(Runner.xPos, 425, xsize, 30);
		}

		else
			g.fillRect(Runner.xPos, 425, 60, 30);

		if(Runner.xPos <= 0)
		{
			isOPassed = true;
			isFirstPassed = true;
			Runner.xPos = 600;
			xsize = CreateObstacles.pickShape();
		}

		if(isOPassed)
		{

			isOPassed = false;
		}

	}

}

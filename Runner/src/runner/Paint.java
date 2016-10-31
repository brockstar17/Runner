package runner;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import runner.obstacles.Overhang;
import runner.obstacles.Square;
import runner.obstacles.Triangle;
import runner.player.Player;

@SuppressWarnings("serial")
public class Paint extends JPanel
{
	public static boolean isOPassed = true;
	public static boolean isFirstPassed = false;

	private Random rand = new Random();
	private int num = rand.nextInt(2 + 1);

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		setBackground(Color.BLACK);

		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 600, 20);
		g.fillRect(0, 455, 600, 20);

		g.setColor(Color.RED);
		g.fillRect(100, Player.getPlayer(), 30, Player.duck());

		g.setColor(Color.YELLOW);

		switch(num)
		{
		case 0:
			Triangle.paintT(g);
			break;
		case 1:
			Square.paintS(g);
			break;
		case 2:
			Overhang.paintO(g);
			break;
		}

		if(Runner.xPos <= 0)
		{
			isOPassed = true;
			isFirstPassed = true;
			Runner.xPos = 600;
			num = rand.nextInt(2 + 1);
		}

		if(isOPassed)
		{

			isOPassed = false;
		}

	}

}

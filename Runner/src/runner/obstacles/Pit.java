package runner.obstacles;

import java.awt.Color;
import java.awt.Graphics;

import runner.Runner;

public class Pit
{
	public static void paintH(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(Runner.xPos, 455, 50, 20);

	}
}

package runner.obstacles;

import java.awt.Graphics;

import runner.Runner;

public class Overhang
{
	public static void paintO(Graphics g) {
		g.fillRect(Runner.xPos, 415, 60, 20);
	}

	public static void paintOwithT(Graphics g) {
		g.fillRect(Runner.xPos + 180, 415, 60, 20);
	}
}

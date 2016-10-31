package runner.obstacles;

import java.awt.Graphics;
import java.awt.Polygon;

import runner.Runner;

public class Triangle
{

	public static void paintT(Graphics g) {

		int[] xpoints1 = { Runner.xPos, Runner.xPos + 20, Runner.xPos - 20 };
		int[] ypoints1 = { 435, 435 + 20, 435 + 20 };

		Polygon p = new Polygon(xpoints1, ypoints1, 3);

		g.fillPolygon(p);

	}
}

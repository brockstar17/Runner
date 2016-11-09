package runner.obstacles;

import java.awt.Graphics;
import java.awt.Polygon;

import runner.Runner;

public class Triangle
{

	public static void paintT(Graphics g, int number, int spacing) {

		int[] xpoints1 = new int[] { Runner.xPos, Runner.xPos + 20,
				Runner.xPos - 20 };
		int[] xpoints2 = new int[] { Runner.xPos + spacing,
				Runner.xPos + spacing + 20, Runner.xPos + spacing - 20 };
		int[] xpoints3 = new int[] { Runner.xPos + spacing + 160,
				Runner.xPos + spacing + 180, Runner.xPos + spacing + 140 };
		int[] ypoints1 = { 435, 435 + 20, 435 + 20 };

		Polygon p = new Polygon(xpoints1, ypoints1, 3);
		Polygon o = new Polygon(xpoints2, ypoints1, 3);
		Polygon l = new Polygon(xpoints3, ypoints1, 3);

		switch(number)
		{
		case 1:
			g.fillPolygon(p);
			break;
		case 2:
			g.fillPolygon(p);
			g.fillPolygon(o);
			break;
		case 3:
			g.fillPolygon(p);
			g.fillPolygon(o);
			g.fillPolygon(l);
			break;

		}

	}
}

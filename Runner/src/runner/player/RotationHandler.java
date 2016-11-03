package runner.player;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import runner.Runner;

public class RotationHandler
{
	private static int[] xcoords = new int[4];
	private static int[] ycoords = new int[4];

	private static Point p = new Point(115, 440);

	public static void rotateCorners() {

		for(int i = 0; i < 4; i++)
		{
			switch(i)
			{
			case 0: // upper left
				CalcJumpRotation.calcRot(p, Runner.angleRot, 100, 425 + 40);
				xcoords[i] = CalcJumpRotation.getRotX();
				ycoords[i] = CalcJumpRotation.getRotY();
				break;

			case 1: // upper right
				CalcJumpRotation.calcRot(p, Runner.angleRot, 130, 425 + 40);
				xcoords[i] = CalcJumpRotation.getRotX();
				ycoords[i] = CalcJumpRotation.getRotY();
				break;

			case 2: // bottom right
				CalcJumpRotation.calcRot(p, Runner.angleRot, 130, 455 + 40);
				xcoords[i] = CalcJumpRotation.getRotX();
				ycoords[i] = CalcJumpRotation.getRotY();
				break;

			case 3: // bottom left
				CalcJumpRotation.calcRot(p, Runner.angleRot, 100, 455 + 40);
				xcoords[i] = CalcJumpRotation.getRotX();
				ycoords[i] = CalcJumpRotation.getRotY();
				break;
			}
		}
	}

	public static void drawRotPlayer(Graphics g) {
		Polygon p = new Polygon(xcoords, ycoords, 4);
		g.fillPolygon(p);
	}

}

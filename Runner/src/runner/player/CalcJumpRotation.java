package runner.player;

import java.awt.Point;
import java.awt.geom.AffineTransform;

public class CalcJumpRotation
{
	/*
	 * Circle center at (130, 400). Radius of 30.
	 */

	private static int rotx;
	private static int roty;

	public static void calcRot(Point center, double angle, int x, int y) {
		double[] pt = { x, y };
		AffineTransform.getRotateInstance(Math.toRadians(angle), center.x,
				center.y).transform(pt, 0, pt, 0, 1); // specifying to use this
														// double[] to hold
														// coords
		rotx = (int) pt[0];
		roty = (int) pt[1];
	}

	public static int getRotX() {
		return rotx;
	}

	public static int getRotY() {
		return roty;
	}
}

package runner.graphics;

import java.awt.Color;

public class BackColor
{
	private static int[] day = { 104, 204, 255 };
	private static int mult = 8;

	// && day[1] - (shade * mult) >= 0 && day[2] - (shade * mult) >= 0

	public static Color getBackColor(int shade, String time) {
		if (time == "day")
		{
			return new Color(day[0], day[1], day[2]);
		}
		else if (time == "tran")
		{
			if (day[0] - (shade * mult) >= 0)
			{
				return new Color(day[0] - (shade * mult), day[1] - (shade * mult), day[2] - (shade * mult));
			}
			else if (day[1] - (shade * mult) >= 0)
			{
				return new Color(0, day[1] - (shade * mult), day[2] - (shade * mult));
			}
			else
			{
				return new Color(0, 0, day[2] - (shade * mult));
			}
		}
		else
		{
			return new Color(0, 0, 0);
		}
	}
}

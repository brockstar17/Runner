package runner;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import runner.graphics.Paint;
import runner.player.Player;
import runner.player.RotationHandler;

@SuppressWarnings("serial")
public class Runner extends JFrame implements ActionListener, KeyListener
{
	public static int oVel = 0;
	public static int xPos = 600;
	public static int pPos = 600;

	public static boolean isNewGame = true;
	public static boolean gameOver = false;

	public Runner()
	{
		super("Runner");
		Container c = getContentPane();
		c.add(new Paint());
		addKeyListener(this);

		Timer clock = new Timer(30, this);
		clock.start();

	}

	public static void main(String[] args) {

		HighScores.readScores();

		Runner frame = new Runner();

		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);

	}

	// when keys are pressed
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key)
		{
		case KeyEvent.VK_A:
			break;
		case KeyEvent.VK_W:
			Player.jump();
			Player.isJump = true;
			break;
		case KeyEvent.VK_D:
			break;
		case KeyEvent.VK_S:

			isDucking = true;
			break;
		case KeyEvent.VK_C:

			break;

		case KeyEvent.VK_R:
			isNewGame = true;
			xPos = 600;
			oVel = 0;
			Paint.passed = 0;
			Paint.jumps = 0;
			Paint.score = 0;
			gameOver = false;
			once = 0;
			altPpos = -1200;
			pPos = 600;
			break;

		case KeyEvent.VK_I:
			HighScores.readScores();
			break;

		case KeyEvent.VK_ESCAPE:
			if (oVel != 0)
				oVel = 0;
			else
				oVel = 8;
			break;
		}
	}

	private static boolean isDucking = false;

	// when keys are released
	@Override
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();
		switch (key)
		{
		case KeyEvent.VK_A:
			isNewGame = false;
			oVel = 8;
			break;
		case KeyEvent.VK_W:

			Player.fall(1);
			break;
		case KeyEvent.VK_D:
			oVel = 8;
			isNewGame = false;
			break;
		case KeyEvent.VK_S:
			isDucking = false;
			Paint.jumps++;
			break;

		}

	}

	public static boolean getDucking() {
		return isDucking;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public static int angleRot = 180;

	public static int numAway = 0;

	private int once = 0;

	public static boolean shouldUPPos = true;
	public static int altPpos = -1200;

	private int count = 1;
	public static int time = 1;
	public static boolean day = true;

	public static boolean wait = true;
	private int wTime = 1;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!gameOver)
		{
			xPos -= oVel;
			if (shouldUPPos)
			{

				pPos -= oVel;
			}
			else
			{

				altPpos -= oVel;
			}

			if (Player.isJump)
				Player.decPos(Player.getDVel());

			if (angleRot < 270 && Player.isJump)
			{
				angleRot += 10;
				RotationHandler.rotateCorners();
			}
			if (angleRot == 270 && !Player.isJump)
			{
				angleRot = 180;
			}

		}

		if (gameOver && once == 0)
		{
			if (Paint.passed > HighScores.passed)
			{
				HighScores.addScore(HighScores.getName(), Paint.passed, Paint.score * 100);
			}
			HighScores.writeScores();
			once++;
		}

		if (count < (1000 / 30))
		{
			count++;
		}
		else if (count == (1000 / 30))
		{
			if (day && !wait)
			{
				time += 1;
				if (time == 30)
				{
					wait = true;
					day = false;
				}
			}
			else if (!wait)
			{
				time -= 1;
				if (time == 0)
				{
					wait = true;
					day = true;
				}
			}

			if (wTime < 40 && wait)
			{
				wTime += 1;
			}
			else if (wTime == 40 && wait)
			{
				wait = false;
				wTime = 1;
			}

			// System.out.println(time);

			count = 1;
		}

		repaint();
	}

}

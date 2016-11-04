package runner;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import runner.player.Player;
import runner.player.RotationHandler;

@SuppressWarnings("serial")
public class Runner extends JFrame implements ActionListener, KeyListener
{
	public static int oVel = 0;
	public static int xPos = 600;

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
			oVel = 5;
			break;
		case KeyEvent.VK_W:
			Player.jump();
			Player.isJump = true;
			break;
		case KeyEvent.VK_D:
			oVel = 10;
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
			gameOver = false;
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!gameOver)
		{
			xPos -= oVel;

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

		repaint();
	}

}

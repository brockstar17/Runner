package runner;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import runner.player.Player;

@SuppressWarnings("serial")
public class Runner extends JFrame implements ActionListener, KeyListener
{
	public static int oVel = 0;
	public static int xPos = 600;
	public static int oldXpos = 100;

	public static boolean isNewGame = true;

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

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key)
		{
		case KeyEvent.VK_A:
			oVel = 3;
			break;
		case KeyEvent.VK_W:
			Player.jump();
			break;
		case KeyEvent.VK_D:
			oVel = 5;
			break;
		case KeyEvent.VK_S:
			isDucking = true;
			break;
		}
	}

	private static boolean isDucking = false;

	@Override
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();
		switch(key)
		{
		case KeyEvent.VK_A:
			isNewGame = false;
			oVel = 4;
			break;
		case KeyEvent.VK_W:

			Player.fall(1);
			break;
		case KeyEvent.VK_D:
			oVel = 4;
			isNewGame = false;
			break;
		case KeyEvent.VK_S:
			isDucking = false;
			break;
		case KeyEvent.VK_R:
			isNewGame = true;
			Paint.isFirstPassed = false;
		}

	}

	public static boolean getDucking() {
		return isDucking;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public static boolean decOldX = false;

	@Override
	public void actionPerformed(ActionEvent e) {
		xPos -= oVel;
		if(decOldX)
		{
			oldXpos -= oVel;
			if(oldXpos <= 0)
			{
				decOldX = false;
				oldXpos = 100;
			}
		}
		Player.decPos(Player.getDVel());
		repaint();
	}

}

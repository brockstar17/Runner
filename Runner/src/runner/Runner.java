package runner;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Runner extends JFrame implements ActionListener, KeyListener
{
	public static int oVel = 0;
	public static int xPos = 600;

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
			oVel = 2;
			break;
		case KeyEvent.VK_W:
			System.out.println("Jump");
			break;
		case KeyEvent.VK_D:
			oVel = 4;
			break;
		case KeyEvent.VK_S:
			System.out.println("Duck");
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_A)
			oVel = 3;
		if(e.getKeyCode() == KeyEvent.VK_D)
			oVel = 3;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		xPos -= oVel;
		repaint();
	}

}

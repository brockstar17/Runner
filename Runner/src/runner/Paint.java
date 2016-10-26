package runner;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import runner.player.Player;

@SuppressWarnings("serial")
public class Paint extends JPanel
{

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		setBackground(Color.BLACK);

		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 600, 20);
		g.fillRect(0, 455, 600, 20);

		g.setColor(Color.RED);
		g.fillRect(100, Player.getPlayer(), 30, 30);

		g.setColor(Color.YELLOW);
		g.fillRect(Runner.xPos, 425, 60, 30);
	}
}

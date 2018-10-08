import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
public class NukeDefenseAnimation2 extends JFrame
	{
		NukeEngine gameEngine = new NukeEngine();
		public NukeDefenseAnimation2()
			{
				setTitle("NukeDefense");
				setLocationRelativeTo(null);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setSize(500,500);
				
				JLabel instructions = new JLabel("Press Enter to launch the laser and stop the nuke.");
				instructions.setOpaque(true);
				instructions.setBackground(Color.green);
				add(instructions, BorderLayout.SOUTH);
				
				add(gameEngine);
				
				addKeyListener(new KeyAdapter()
							{
								
								@Override
								public void keyPressed(KeyEvent e)
									{
										switch (e.getKeyCode()) 
										{
											case KeyEvent.VK_ENTER:
												gameEngine.fireLaser();
												break;
											case KeyEvent.VK_SPACE:
												gameEngine.start();
												break;
										}
									}
							});
			}
		public static void main(String[] args)
			{
				JFrame mainWindow = new NukeDefenseAnimation2();
				mainWindow.setVisible(true);
			}
	}
class NukeEngine extends JPanel
	{
		String message = "Press space to start";
		boolean running = false;
		static int nukeSize = 20;
		static int nukeX = 0;
		static int nukeY = 100;
		static int sateliteX = 230;
		static int sateliteY = 300;
		static int laserX = 239;
		static int laserY = 305;
		static boolean laserFired = false;
		
		public NukeEngine()
			{
				Timer timer = new Timer(50, new ActionListener() 
					{
						@Override
						public void actionPerformed(ActionEvent e) 
							{
								if (running) 
									{
										updateGame();
									}
							}
					});
				timer.start();
			}
		
		public void updateGame()
			{
				if(running)
					{
				nukeX += 5;
				if(laserFired)
					{
						laserY -= 15;
						if(laserY < 0)
							{
								laserFired = false;
								laserY = 305;
							}
					}
				if (nukeX + nukeSize > getWidth())
					{
						showGameOver();
						running = false;
						nukeX = 0;
						nukeY = 100;
						sateliteX = 230;
						sateliteY = 300;
						laserX = 239;
						laserY = 305;
						laserFired = false;
					}
				else if ((laserX > nukeX) && (laserX < nukeX + nukeSize) && (laserY > nukeY) && (laserY < nukeY + nukeSize))
					{
						showYouWon();
						running = false;
						nukeX = 0;
						nukeY = 100;
						sateliteX = 230;
						sateliteY = 300;
						laserX = 239;
						laserY = 305;
						laserFired = false;
					}
				repaint();
					}
			}
		
		public void start() 
			{
				if (!running) 
					{
						running = true;
					}
			}
		
		public void fireLaser()
			{
				if (!laserFired)
					{
						laserFired = true;
					}
			}
		
		@Override
		public void paint(Graphics graphics)
			{
				super.paintComponent(graphics);
				if (running)
					{
						graphics.setColor(Color.RED);
						graphics.fillRect(laserX, laserY - 5, 2, 15);
						graphics.setColor(Color.DARK_GRAY);
						graphics.fillOval(sateliteX, sateliteY, 10, 20);
						graphics.fillRect(sateliteX - 10, sateliteY + 10, 30, 2);
						graphics.setColor(Color.BLUE);
						graphics.fillRect(sateliteX - 25, sateliteY, 15, 20);
						graphics.fillRect(sateliteX + 20, sateliteY, 15, 20);
						graphics.setColor(Color.white);
						graphics.fillRect(nukeX - 5, nukeY, nukeSize, nukeSize);
						graphics.setColor(Color.BLACK);
						graphics.fillRect(nukeX, nukeY, nukeSize, nukeSize);
					}
				else
					{
						String message = "Press space to start";
						graphics.setColor(Color.BLACK);
						int h = graphics.getFontMetrics().getHeight();
						int w = graphics.getFontMetrics().stringWidth(message);
						graphics.drawString(message, getWidth()/2 - w/2, getHeight()/2 - h/2);
					}
			}
		public void showGameOver()
			{
				System.out.println("Game Over");
				System.out.println("The world was destroyed by the nuke.");
				System.out.println();
			}
		public void showYouWon()
			{
				System.out.println("You Won");
				System.out.println("You saved the world.");
				System.out.println();
			}
	}

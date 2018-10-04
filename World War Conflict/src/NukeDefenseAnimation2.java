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
//												gameEngine.(fireLaser);
												//add class in NukeEngine to fire the laser
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
		boolean running = false;
		static int x = 0;
		static int y = 100;
		static int x2 = 230;
		static int y2 = 300;
		String message = "Press space to start";
		public void start() 
			{
				if (!running) 
					{
						running = true;
					}
			}
		@Override
		public void paint(Graphics graphics)
			{
				super.paintComponent(graphics);
				if (running)
					{
						graphics.setColor(Color.DARK_GRAY);
						graphics.fillOval(x2, y2, 10, 20);
						graphics.setColor(Color.white);
						graphics.fillRect(x - 5, y, 20, 20);
						graphics.setColor(Color.BLACK);
						graphics.fillRect(x, y, 20, 20);
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
	}

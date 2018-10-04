import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
public class NukeDefenseSystemAnimation extends Canvas
	{
		//Have a nuke move across the screen and have the user choose when to fire the laser
		//If the laser hits the nuke you save the world other wise the world is destroyed
		private static final long        serialVersionUID        = 1L;
		static int x = 0;
		static int y = 100;
		static int x2 = 230;
		static int y2 = 300;
		static boolean launch = false; 
		static Scanner userInput = new Scanner(System.in);
		public static void main(String[] args, Graphics Graphics)
			{
				NukeDefenseSystemAnimation canvas = new NukeDefenseSystemAnimation();
				JFrame frame = new JFrame(); //Creates new frame
				frame.setSize(500, 500); //Sets frame size
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Allows X to close the frame
				frame.getContentPane().add(canvas).setBackground(Color.white); //Sets background color to white
				frame.setLocationRelativeTo(null); //Sets JPanel to center of screen 
				frame.setResizable(false); //Allows frame size to be changed
				frame.setVisible(true);
				frame.setLayout(new GridBagLayout());
				//fix button
				JButton btnA = new JButton("LAUNCH");
				frame.add(btnA);
				//fix button
				
				btnA.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0)
						{
							// TODO Auto-generated method stub
							System.out.println("Laser Activated");
							launch = true;
						}
				});
				
//				while(x < 480)
//					{
//						graphics.setColor(Color.DARK_GRAY);
//						graphics.fillOval(x2, y2, 10, 20);
//						if (launch)
//							{
//								graphics.setColor(Color.red);
//								graphics.fillRect(x2 - 4, 0, 2, 300);
//							}
//						graphics.setColor(Color.white);
//						graphics.fillRect(x - 5, y, 20, 20);
//						graphics.setColor(Color.BLACK);
//						graphics.fillRect(x, y, 20, 20);
//						delay();
//						x = x + 5;
//					}
			}
		public void paint(Graphics graphics)
			{
				while(x < 240)
					{
						graphics.setColor(Color.DARK_GRAY);
						graphics.fillOval(x2, y2, 10, 20);
						//fix so laser fires when button is pressed
						graphics.setColor(Color.white);
						graphics.fillRect(x - 5, y, 20, 20);
						graphics.setColor(Color.BLACK);
						graphics.fillRect(x, y, 20, 20);
						delay();
						x = x + 5;
					}
				if (launch)
					{
						graphics.setColor(Color.red);
						graphics.fillRect(x2 - 4, 0, 2, 300);
					}
				while(x < 480)
					{
						graphics.setColor(Color.DARK_GRAY);
						graphics.fillOval(x2, y2, 10, 20);
						//fix so laser fires when button is pressed
						graphics.setColor(Color.white);
						graphics.fillRect(x - 5, y, 20, 20);
						graphics.setColor(Color.BLACK);
						graphics.fillRect(x, y, 20, 20);
						delay();
						x = x + 5;
					}
			}
		public static void delay()
			{
				try
        			{
        				Thread.sleep(50);
        			} 
        		catch (InterruptedException e)
        			{
        				e.printStackTrace();
        			}
			}
	}

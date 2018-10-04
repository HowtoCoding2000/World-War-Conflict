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
		//NukeEngine gameEngine = new NukeEngine();
		
		public void NukeDefense()
			{
				setTitle("NukeDefense");
				setLocationRelativeTo(null);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setSize(500,500);
				
				addKeyListener(new KeyAdapter()
							{
								
								@Override
								public void keyPressed(KeyEvent e)
									{
										switch (e.getKeyCode()) 
										{
											case KeyEvent.VK_ENTER:
												
										}
									}
							});
			}
	}

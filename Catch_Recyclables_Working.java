import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Catch_Recyclables_Working extends JFrame implements KeyListener{
	private JPanel contentPane;
	private Timer timer;
	private int seconds = 5, milliseconds = 1000;
	
	//make these random
	private int itemX = 251;
	private int itemY = 302;
	
	private JLabel recyclingBin;
	private JLabel sodaCan;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Catch_Recyclables_Working frame = new Catch_Recyclables_Working();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Catch_Recyclables_Working() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1150, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		JLabel banana = new JLabel("");
		banana.setHorizontalAlignment(SwingConstants.CENTER);
		banana.setIcon(new ImageIcon(Catch_Recyclables_Working.class.getResource("/CalHacks_Images/banana_peel_(not_recyclable).png")));
		banana.setBounds(136, 11, 166, 184);
		getContentPane().add(banana);
			
		JLabel plasticBottle = new JLabel("");
		plasticBottle.setHorizontalAlignment(SwingConstants.CENTER);
		plasticBottle.setIcon(new ImageIcon(Catch_Recyclables_Working.class.getResource("/CalHacks_Images/plastic_bottle_smaller.png")));
		plasticBottle.setBounds(444, 57, 151, 184);
		contentPane.add(plasticBottle);
		
		recyclingBin = new JLabel("");
		recyclingBin.setVerticalAlignment(SwingConstants.BOTTOM);
		recyclingBin.setHorizontalAlignment(SwingConstants.CENTER);
		recyclingBin.setIcon(new ImageIcon(Catch_Recyclables_Working.class.getResource("/CalHacks_Images/plastic_bottle_even_smaller.png")));
		recyclingBin.setBounds(297, 285, 108, 267);
		contentPane.add(recyclingBin);
		
		sodaCan = new JLabel("");
		sodaCan.setHorizontalAlignment(SwingConstants.CENTER);
		sodaCan.setIcon(new ImageIcon(Catch_Recyclables_Working.class.getResource("/CalHacks_Images/soda-can.png")));
		sodaCan.setBounds(101, 194, 98, 172);
		contentPane.add(sodaCan);
		//MADE ITEMS HIT TOP OF BIN BY MAKING ITS VERTICAL ALIGNMENT "BOTTOM"
		
		// Timer
		ActionListener timerListener = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(banana.getY() >= recyclingBin.getY() - 5 && banana.getY() <= recyclingBin.getY() + 5) {
					if(banana.getX() >= recyclingBin.getX() - 50 && banana.getX() <= recyclingBin.getX() + 50) {
						timer.stop();
						banana.setVisible(false);
						JOptionPane.showMessageDialog(null, "Penalty!");
					}
				}
				
				++milliseconds;
				if (milliseconds >= 5) {
					--seconds;
					milliseconds = 0;
				}

				if (seconds <= 0) {
					banana.setLocation(banana.getX(), banana.getY() + 10);
					
					milliseconds = 1000;
					seconds = 5;
				}
				
			}
		};

		timer = new Timer(1, timerListener);

		timer.start();
		
//		JLabel bckgrnd = new JLabel("");
//		bckgrnd.setIcon(new ImageIcon(Catch_Recyclables.class.getResource("/CalHacks_Images/tree_bckgrnd.jpg")));
//		bckgrnd.setBounds(-11, -43, 728, 446);
//		getContentPane().add(bckgrnd);

	//See Instagram DM w/sister on April 3 about how to do collisions and all the ideas that
	//she helped me out with
	//Maybe a way to check if the jlabel given is recyclable vs. garbage is to make a class for each
	//and label them with a boolean (recyclable = true);
	
	//Premise of the game is to catch recyclables and avoid garbage to teach people
	//what to recycle and what not to recycle
	
		
	//FEATURES TO KEEP IN MIND
	//collision: if(bottom of item = top of can, stop timer of item to stop it moving and set it visible to false, then do either penalty or point addition)
	//moving recycle bin: use arrow keys, make sure you can hold down arrow key and keep it moving SMOOTHLY
	//-set bounds for where you can move recycle bin, where items can fall
		
	}
	
	public void keyReleased(KeyEvent event) {
		
	}
	public void keyTyped(KeyEvent event) {
		
	}
	public void keyPressed(KeyEvent event) {
		int x = recyclingBin.getX();
		int y = recyclingBin.getY();
		
		if(event.getKeyCode() == event.VK_LEFT && x >= 5) {
			recyclingBin.setLocation(x-5, y);
			System.out.println(x);
		} else if(event.getKeyCode() == event.VK_RIGHT && x <= 1025) {
			recyclingBin.setLocation(x+5,y);
			System.out.println(x);
		}
	}
}

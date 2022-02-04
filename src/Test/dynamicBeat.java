package Test;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class dynamicBeat extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground;
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("/Images/MenuBar.png")));
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("/Images/ExitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("/Images/ExitButtonBasic.png"));
	private JButton exitButton = new JButton(exitButtonBasicImage);
	
	private int mouseX, mouseY;
	
dynamicBeat(){
	setUndecorated(true);
	setTitle("DynamicBeat");
	setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
	setResizable(false);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	setBackground(new Color(0,0,0,0));
	setLayout(null);
	
	
	exitButton.setBounds(1240 ,0,50, 50);
	exitButton.setBorderPainted(false);
	exitButton.setContentAreaFilled(false);
	exitButton.setFocusPainted(false);
	exitButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			exitButton.setIcon(exitButtonEnteredImage);
			Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
			buttonEnteredMusic.start();
			exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			exitButton.setIcon(exitButtonBasicImage);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
			buttonPressedMusic.start();
			try {
				Thread.sleep(100);
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
			System.exit(0);
			
		}
	});
	add(exitButton);
	
	menuBar.setBounds(0,0, 1280,30);
	menuBar.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			mouseX = e.getX();
			mouseY = e.getY();
		}
	});
	menuBar.addMouseMotionListener(new MouseMotionAdapter() {
		@Override 
		public void mouseDragged(MouseEvent e) {
			int x = e.getXOnScreen();
			int y= e.getYOnScreen();
			setLocation(x-mouseX, y-mouseY);
		}
	} );
	add(menuBar);
	introBackground = new ImageIcon(Main.class.getResource("/Images/mainBackground.jpg")).getImage();
	

	
	Music introMusic = new Music("IntroMusic.mp3", true);
	introMusic.start();
}

public void paint(Graphics g) {
screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
screenGraphic = screenImage.getGraphics();
screenDraw(screenGraphic);
g.drawImage(screenImage,0,0,null);
}

public void screenDraw(Graphics g) {
	g.drawImage(introBackground, 0,0,null);
	paintComponents(g);
	this.repaint();
}
}

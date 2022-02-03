package Test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class dynamicBeat extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground;
	private JLabel menuBar = new JLabel();
	private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("/Images/ExitButtonBasic.png")));
	
	
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
	
	menuBar.setBounds(0,0, 1280,30);
	add(menuBar);
	introBackground = new ImageIcon(Main.class.getResource("/Images/mainBackground.jpg")).getImage();
	
	exitButton.setBounds(50,50,50, 50);
	exitButton.setBorderPainted(false);
	exitButton.setContentAreaFilled(false);
	exitButton.setFocusPainted(false);
	add(exitButton);
	
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

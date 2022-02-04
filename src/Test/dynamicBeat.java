package Test;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class dynamicBeat extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image background = new ImageIcon(Main.class.getResource("/Images/mainBackground.jpg")).getImage(); //draw with g.drawImage
	
	
	
	//track components
	private Image titleImage ;
	private Music selectedMusic;
	private Image selectedImage;
	private int nowSelected = 0;
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("/Images/MenuBar.png")));
	
	//exit Button
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("/Images/ExitButtonEntered.png"));//draw withpaintComponents
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("/Images/ExitButtonBasic.png"));
	private JButton exitButton = new JButton(exitButtonBasicImage);
	
	//start Button
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("/Images/StartButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("/Images/StartButtonBasic.png"));
	private JButton startButton = new JButton(startButtonBasicImage);
	//quit Button
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("/Images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("/Images/quitButtonBasic.png"));
	private JButton quitButton = new JButton(quitButtonBasicImage);
	
	//left right buttons
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("/Images/ArrowLeft.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("/Images/ArrowLeftBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("/Images/ArrowRight.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("/Images/ArrowRightBasic.png"));
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	
	
	
	//easy hard buttons
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("/Images/easyButtonEntered.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("/Images/easyButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("/Images/hardButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("/Images/hardButtonBasic.png"));
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	
	private int mouseX, mouseY;
	
	
	private boolean isMainScreen =false;
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	
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
	
	//track database
	trackList.add(new Track("M2U_QueenBeeText.png", "QueenBeesOpening.png", "mainPage.jpg", "M2U - Queen Bee.mp3", "M2U - Queen Bee.mp3"));
	trackList.add(new Track("farout_truestLiesText.png", "Truest_Lie.png", "mainPage.jpg", "Far Out - Truest Lies.mp3", "Far Out - Truest Lies.mp3"));
	trackList.add(new Track("FelixCartal_LoveMeText.png", "Love me.png", "mainPage.jpg", "Felix Cartal  LIGHTS - Love Me.mp3", "Felix Cartal  LIGHTS - Love Me.mp3"));
	
	Music introMusic = new Music("IntroMusic.mp3", true);
	introMusic.start();
	
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
	
	startButton.setBounds(40 ,330,400, 100);
	startButton.setBorderPainted(false);
	startButton.setContentAreaFilled(false);
	startButton.setFocusPainted(false);
	startButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			startButton.setIcon(startButtonEnteredImage);
			Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
			buttonEnteredMusic.start();
			startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			startButton.setIcon(startButtonBasicImage);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
			buttonPressedMusic.start();
			introMusic.close();
			
	//game start event
			startButton.setVisible(false);
			quitButton.setVisible(false);
			leftButton.setVisible(true);
			rightButton.setVisible(true);
			hardButton.setVisible(true);
			easyButton.setVisible(true);
			background = new ImageIcon(Main.class.getResource("/Images/mainPage.jpg")).getImage();
			isMainScreen =true;
			selectedTrack(0);
		}
	});
	add(startButton);
	
	quitButton.setBounds(40 ,200,400, 100);
	quitButton.setBorderPainted(false);
	quitButton.setContentAreaFilled(false);
	quitButton.setFocusPainted(false);
	quitButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			quitButton.setIcon(quitButtonEnteredImage);
			Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
			buttonEnteredMusic.start();
			quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			quitButton.setIcon(quitButtonBasicImage);
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
	add(quitButton);
	
	leftButton.setVisible(false);
	leftButton.setBounds(140 ,310,60, 60);
	leftButton.setBorderPainted(false);
	leftButton.setContentAreaFilled(false);
	leftButton.setFocusPainted(false);
	leftButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			leftButton.setIcon(leftButtonEnteredImage);
			Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
			buttonEnteredMusic.start();
			leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			leftButton.setIcon(leftButtonBasicImage);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
			buttonPressedMusic.start();
		//left button event
			selectLeft();
		}
	});
	add(leftButton);
	
	
	rightButton.setVisible(false);
	rightButton.setBounds(1080 ,310,60, 60);
	rightButton.setBorderPainted(false);
	rightButton.setContentAreaFilled(false);
	rightButton.setFocusPainted(false);
	rightButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			rightButton.setIcon(rightButtonEnteredImage);
			Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
			buttonEnteredMusic.start();
			rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			rightButton.setIcon(rightButtonBasicImage);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
			buttonPressedMusic.start();
		//right button event
			selectRight();
		}
	});
	add(rightButton);
	
	easyButton.setVisible(false);
	easyButton.setBounds(375 ,580,250, 67);
	easyButton.setBorderPainted(false);
	easyButton.setContentAreaFilled(false);
	easyButton.setFocusPainted(false);
	easyButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			easyButton.setIcon(easyButtonEnteredImage);
			Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
			buttonEnteredMusic.start();
			easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			easyButton.setIcon(easyButtonBasicImage);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
			buttonPressedMusic.start();
		//easy button event
			gameStart(nowSelected, "easy");
		}
	});
	add(easyButton);
	
	hardButton.setVisible(false);
	hardButton.setBounds(655 ,580,250, 67);
	hardButton.setBorderPainted(false);
	hardButton.setContentAreaFilled(false);
	hardButton.setFocusPainted(false);
	hardButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			hardButton.setIcon(hardButtonEnteredImage);
			Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
			buttonEnteredMusic.start();
			hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			hardButton.setIcon(hardButtonBasicImage);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
			buttonPressedMusic.start();
		//hard button event
			gameStart(nowSelected, "hard");
		}
	});
	add(hardButton);
	
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

	

	

}

public void paint(Graphics g) {
screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
screenGraphic = screenImage.getGraphics();
screenDraw(screenGraphic);
g.drawImage(screenImage,0,0,null);
}

public void screenDraw(Graphics g) {
	g.drawImage(background, 0,0,null);
	if(isMainScreen) {
		g.drawImage(selectedImage, 340,100,null);
		g.drawImage(titleImage,340,70,null );
	}
	paintComponents(g);
	this.repaint();
}

public void selectedTrack(int nowSelected) {
	if(selectedMusic != null)
		selectedMusic.close();
	
	titleImage = new ImageIcon(Main.class.getResource("/Images/"+trackList.get(nowSelected).getTitleImage())).getImage();
	selectedImage = new ImageIcon(Main.class.getResource("/Images/"+trackList.get(nowSelected).getStartImage())).getImage();
	selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(),true);
	selectedMusic.start();
}

public void selectLeft(){
	if(nowSelected ==0)
		nowSelected = trackList.size()-1;
	else
		nowSelected--;
	
	selectedTrack(nowSelected);
	
}
public void selectRight() {
	if(nowSelected ==trackList.size()-1)
		nowSelected = 0;
	else
		nowSelected++;
	
	selectedTrack(nowSelected);
}
public void gameStart(int nowSelected, String difficulty) {
	if(selectedMusic != null)
		selectedMusic.close();
	
	isMainScreen = false;
	leftButton.setVisible(false);
	rightButton.setVisible(false);
	easyButton.setVisible(false);
	hardButton.setVisible(false);
	background = new ImageIcon(Main.class.getResource("/Images/"+trackList.get(nowSelected).getGameImage())).getImage();
	
}
}

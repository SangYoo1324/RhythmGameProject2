package Test;


import java.awt.*;
import java.awt.event.KeyAdapter;
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
	
	private Music introMusic = new Music("IntroMusic.mp3", true);
	
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
	
	
	//game play Screen
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("/Images/ArrowLeft.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("/Images/ArrowLeft.png"));
	private JButton backButton = new JButton(backButtonBasicImage);
	//private Image gameInfoImage = new ImageIcon(Main.class.getResource("/Images/gameInfo.png")).getImage(); //draw with g.drawImage
	//private Image judgementLineImage = new ImageIcon(Main.class.getResource("/Images/judgementLine.png")).getImage(); //draw with g.drawImage
	//private Image noteRouteImage =  new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	//private Image noteRouteLineImage =  new ImageIcon(Main.class.getResource("/Images/noteRouteLine.png")).getImage();
	//private Image noteBasicImage =  new ImageIcon(Main.class.getResource("/Images/noteBasic.png")).getImage();
	
	//easy hard buttons
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("/Images/easyButtonEntered.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("/Images/easyButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("/Images/hardButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("/Images/hardButtonBasic.png"));
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	
	private int mouseX, mouseY;
	
	
	private boolean isMainScreen =false;
	private boolean isGameScreen = false;
	
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	public static Game game;
	
dynamicBeat(){
	trackList.add(new Track("M2U_QueenBeeText.png", "QueenBeesOpening.png", "mainPage.jpg", "M2U - Queen Bee.mp3", "M2U - Queen Bee.mp3","M2u-QueenBee"));
	trackList.add(new Track("farout_truestLiesText.png", "Truest_Lie.png", "mainPage.jpg", "Far Out - Truest Lies.mp3", "Far Out - Truest Lies.mp3","Far Out - Truest Lies"));
	trackList.add(new Track("FelixCartal_LoveMeText.png", "Love me.png", "mainPage.jpg", "Felix Cartal  LIGHTS - Love Me.mp3", "Felix Cartal  LIGHTS - Love Me.mp3", "Felix Cartal  LIGHTS - Love Me"));
	
	
	setUndecorated(true);
	setTitle("DynamicBeat");
	setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
	setResizable(false);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	setBackground(new Color(0,0,0,0));
	setLayout(null);
	setFocusable(true);//Keyboard focus on main Frame
	
	//Adding KeyListener for gameScreen
	addKeyListener(new KeyListener());
	//
	//addKeyListener(new KeyAdapter() {});<<-- do this if you don't want to create new Class for KeyListener
	
	//track database
	
	
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
			
			enterMain();
	//game start event

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
	
	backButton.setVisible(false);
	backButton.setBounds(20 ,50,60, 60);
	backButton.setBorderPainted(false);
	backButton.setContentAreaFilled(false);
	backButton.setFocusPainted(false);
	backButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			backButton.setIcon(backButtonEnteredImage);
			Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);
			buttonEnteredMusic.start();
			backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			backButton.setIcon(backButtonBasicImage);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
			buttonPressedMusic.start();
		//main screen return event
			backMain();
		}
	});
	add(backButton);
	
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

public void paint(Graphics g) {//Override AWT
screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
screenGraphic = screenImage.getGraphics();
screenDraw((Graphics2D)screenGraphic);// screenDraw to ScreenGraphic
g.drawImage(screenImage,0,0,null);
}

public void screenDraw(Graphics2D g) {
	g.drawImage(background, 0,0,null);
	if(isMainScreen) {
		g.drawImage(selectedImage, 340,100,null);
		g.drawImage(titleImage,340,70,null );
	}
	if(isGameScreen) {
		game.screenDraw(g);
		/*
		g.drawImage(noteRouteImage, 228,30,null);
		g.drawImage(noteRouteImage, 332,30,null);
		g.drawImage(noteRouteImage, 436,30,null);
		g.drawImage(noteRouteImage, 540,30,null);
		g.drawImage(noteRouteImage, 640,30,null);
		g.drawImage(noteRouteImage, 744,30,null);
		g.drawImage(noteRouteImage, 848,30,null);
		g.drawImage(noteRouteImage, 952,30,null);
		
		
		g.drawImage(noteRouteLineImage, 224,30,null);
		g.drawImage(noteRouteLineImage, 328,30,null);
		g.drawImage(noteRouteLineImage, 432,30,null);
		g.drawImage(noteRouteLineImage, 536,30,null);
		g.drawImage(noteRouteLineImage, 740,30,null);
		g.drawImage(noteRouteLineImage, 844,30,null);
		g.drawImage(noteRouteLineImage, 948,30,null);
		g.drawImage(noteRouteLineImage, 1052,30,null);
		
		g.drawImage(noteBasicImage, 540,500,null);
		g.drawImage(noteBasicImage, 640,500,null);
		
		g.drawImage(gameInfoImage, 0,660,null);
		g.drawImage(judgementLineImage, 0,580,null); 
		
		//g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD,30));
		g.drawString("shibalsaeki", 20, 702);
		
		g.setFont(new Font("Elephant", Font.BOLD,30));
		g.drawString("Easy", 1190, 700);
		g.drawString("000000", 565, 702);
		
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("SpaceBar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		*/
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
	
	isGameScreen = true;
	isMainScreen = false;
	leftButton.setVisible(false);
	rightButton.setVisible(false);
	easyButton.setVisible(false);
	hardButton.setVisible(false);
	backButton.setVisible(true);
	background = new ImageIcon(Main.class.getResource("/Images/"+trackList.get(nowSelected).getGameImage())).getImage();
	game = new Game(trackList.get(nowSelected).getTitleName(),difficulty, trackList.get(nowSelected).getGameMusic());
	game.start();
	setFocusable(true);
	
}
public void backMain() {
	isMainScreen =true;
	leftButton.setVisible(true);
	rightButton.setVisible(true);
	easyButton.setVisible(true);
	hardButton.setVisible(true);
	backButton.setVisible(false);
	background = new ImageIcon(Main.class.getResource("/Images/mainBackground.jpg")).getImage();
	selectedTrack(nowSelected);
	isGameScreen = false;
	game.close();
}
public void enterMain() {
	startButton.setVisible(false);
	quitButton.setVisible(false);
	leftButton.setVisible(true);
	rightButton.setVisible(true);
	hardButton.setVisible(true);
	easyButton.setVisible(true);
	background = new ImageIcon(Main.class.getResource("/Images/mainPage.jpg")).getImage();
	isMainScreen =true;
	introMusic.close();
	selectedTrack(0);
}
}

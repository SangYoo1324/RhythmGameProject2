package Test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {
	//Game screen components
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("/Images/gameInfo.png")).getImage(); //draw with g.drawImage
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("/Images/judgementLine.png")).getImage(); //draw with g.drawImage
	private Image noteRouteSImage =  new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	private Image noteRouteDImage =  new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	private Image noteRouteFImage =  new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image =  new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image =  new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	private Image noteRouteJImage =  new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	private Image noteRouteKImage =  new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	private Image noteRouteLImage =  new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	
	private Image noteRouteLineImage =  new ImageIcon(Main.class.getResource("/Images/noteRouteLine.png")).getImage();
	
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	
		
		
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228,30,null);
		g.drawImage(noteRouteDImage, 332,30,null);
		g.drawImage(noteRouteFImage, 436,30,null);
		g.drawImage(noteRouteSpace1Image, 540,30,null);
		g.drawImage(noteRouteSpace2Image, 640,30,null);
		g.drawImage(noteRouteJImage, 744,30,null);
		g.drawImage(noteRouteKImage, 848,30,null);
		g.drawImage(noteRouteLImage, 952,30,null);
		
		
		g.drawImage(noteRouteLineImage, 224,30,null);
		g.drawImage(noteRouteLineImage, 328,30,null);
		g.drawImage(noteRouteLineImage, 432,30,null);
		g.drawImage(noteRouteLineImage, 536,30,null);
		g.drawImage(noteRouteLineImage, 740,30,null);
		g.drawImage(noteRouteLineImage, 844,30,null);
		g.drawImage(noteRouteLineImage, 948,30,null);
		g.drawImage(noteRouteLineImage, 1052,30,null);
		
		
		g.drawImage(gameInfoImage, 0,660,null);
		g.drawImage(judgementLineImage, 0,580,null); 
		
		//g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD,30));
		g.drawString(titleName, 20, 702);
		
		g.setFont(new Font("Elephant", Font.BOLD,30));
		g.drawString(difficulty, 1190, 700);
		g.drawString("000000", 565, 702);
		
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("SpaceBar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		
		//note Call
		for(int i = 0; i<noteList.size(); i++) {
			Note note = noteList.get(i);
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
				note.screenDraw(g);
			}
			
		}
	}
	
	public void pressS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("/Images/noteRoutePressed.png")).getImage();
		new Music("drumSmall.mp3",false).start();
		judgeGame("S");
	}
	public void pressD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("/Images/noteRoutePressed.png")).getImage();
		new Music("drumSmall.mp3",false).start();
		judgeGame("D");
	}
	public void pressF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("/Images/noteRoutePressed.png")).getImage();
		new Music("drumSmall.mp3",false).start();
		judgeGame("D");
	}
	public void pressSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("/Images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("/Images/noteRoutePressed.png")).getImage();
		new Music("drumSmall.mp3",false).start();
		judgeGame("D");
	}
	
	public void pressJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("/Images/noteRoutePressed.png")).getImage();
		new Music("drumSmall.mp3",false).start();
		judgeGame("D");
	}
	public void pressK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("/Images/noteRoutePressed.png")).getImage();
		new Music("drumSmall.mp3",false).start();
		judgeGame("D");
	}
	public void pressL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("/Images/noteRoutePressed.png")).getImage();
		new Music("drumSmall.mp3",false).start();
		judgeGame("D");
	}
	
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	}
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	}
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	}
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	}
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	}
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("/Images/noteRoute.png")).getImage();
	}
	
	
	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public void dropNotes(String titleName) {
		
Beat[] beats = null;
		
		if(titleName.equals("M2u-QueenBee")&& difficulty.equals("easy")){
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(1000,"S"),
					new Beat(2000,"D"),
					new Beat(3000,"F")
			};
		}
		else if(titleName.equals("Far Out - Truest Lies")&& difficulty.equals("easy")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime,"Space"),
						new Beat(2000, "S"),
						new Beat(3000, "D"),
						new Beat(4000, "F")
			};
		}
		else if(titleName.equals("Felix Cartal  LIGHTS - Love Me")&& difficulty.equals("easy")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime,"Space"),
						new Beat(2000, "S"),
						new Beat(3000, "D"),
						new Beat(4000, "F")
			};
		}
		
		int i = 0;
		gameMusic.start();
		while(i<beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime()==gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
	
		/*Beat[] beats = null;
		
		if(titleName.equals("M2u-QueenBee")){
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(1000,"S"),
					new Beat(2000,"D"),
					new Beat(3000,"F")
			};
		}
		else if(titleName.equals("Far Out - Truest Lies")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime,"Space"),
						new Beat(2000, "S"),
						new Beat(3000, "D"),
						new Beat(4000, "F")
			};
		}
		else if(titleName.equals("Felix Cartal  LIGHTS - Love Me")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime,"Space"),
						new Beat(2000, "S"),
						new Beat(3000, "D"),
						new Beat(4000, "F")
			};
		}
		
		int i = 0;
		gameMusic.start();
		while(true) {
			if(beats[i].getTime()<=gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
			}
		}
		
		*/
		/*
		 * int i = 0;
		gameMusic.start();
		while(i<beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime()<=gameMusic.getTime());{
			Note note = new Note(beats[i].getNoteName());
			note.start();
			noteList.add(note);
			i++;
			dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		 * */
		
		/*
		 * Beat[] beats = null;
		if(titleName.equals("M2u-QueenBee")) {
			int startTime = 1000-Main.REACH_TIME*1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime,"Space"),
						new Beat(startTime+gap*2, "S"),
						new Beat(startTime+gap*4, "D"),
						new Beat(startTime+gap*6, "F")
			};
			
		}else if(titleName.equals("Far Out - Truest Lies")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime,"Space"),
						new Beat(2000, "S"),
						new Beat(3000, "D"),
						new Beat(4000, "F")
			};
		}
		else if(titleName.equals("Felix Cartal  LIGHTS - Love Me")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime,"Space"),
						new Beat(2000, "S"),
						new Beat(3000, "D"),
						new Beat(4000, "F")
			};
		}
	//
		
	
		int i = 0;
		gameMusic.start();
		while(i<beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime()<=gameMusic.getTime());{
			Note note = new Note(beats[i].getNoteName());
			note.start();
			noteList.add(note);
			i++;
			dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	*/
		

	
	}
	public void judgeGame(String input) {
		for(int i = 0; i<noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				note.judgeNote();
				break;
				
			}
		}
	}
}

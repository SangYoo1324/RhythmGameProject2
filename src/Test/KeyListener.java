package Test;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

	@Override   // Overrides the KeyAdapter methods
	public void keyPressed(KeyEvent e) {
		if(dynamicBeat.game == null)
			return;
			
		if(e.getKeyCode()== KeyEvent.VK_S) {
			dynamicBeat.game.pressS();
		}
		else if(e.getKeyCode()== KeyEvent.VK_D) {
			dynamicBeat.game.pressD();
		}
		else if(e.getKeyCode()== KeyEvent.VK_F) {
			dynamicBeat.game.pressF();
		}
		else if(e.getKeyCode()== KeyEvent.VK_SPACE) {
			dynamicBeat.game.pressSpace();
}
		else if(e.getKeyCode()== KeyEvent.VK_J) {
			dynamicBeat.game.pressJ();
}
		else if(e.getKeyCode()== KeyEvent.VK_K) {
			dynamicBeat.game.pressK();
}
		else if(e.getKeyCode()== KeyEvent.VK_L) {
			dynamicBeat.game.pressL();
}

		
	}
	
	@Override   // Overrides the KeyAdapter methods
	public void keyReleased(KeyEvent e) {
		if(dynamicBeat.game == null)
			return;
		
		if(e.getKeyCode()== KeyEvent.VK_S) {
			dynamicBeat.game.releaseS();
		}
		else if(e.getKeyCode()== KeyEvent.VK_D) {
			dynamicBeat.game.releaseD();
		}
		else if(e.getKeyCode()== KeyEvent.VK_F) {
			dynamicBeat.game.releaseF();
		}
		else if(e.getKeyCode()== KeyEvent.VK_SPACE) {
			dynamicBeat.game.releaseSpace();
}
		else if(e.getKeyCode()== KeyEvent.VK_J) {
			dynamicBeat.game.releaseJ();
}
		else if(e.getKeyCode()== KeyEvent.VK_K) {
			dynamicBeat.game.releaseK();
}
		else if(e.getKeyCode()== KeyEvent.VK_L) {
			dynamicBeat.game.releaseL();
}

		
	}
}

package game.mainScreen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import guiTeacher.components.AnimatedComponent;

public class Character implements KeyListener {
	
	/**
	  *@author Mimi Buan and Lubna Khalid and Jessi Wu
	 */
	
	private static AnimatedComponent goil;
	private static AnimatedComponent boi;
	private int x;
	private int y;
	
	public Character() {
		boi = game.farm.FarmScreenAll.boy;
		goil = game.farm.FarmScreenAll.girl;
		x = 430;
		y = 200;
	}
	
	public void keyPressed(KeyEvent e) {
		x = getX();
		y = getY(); 
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			x -= 10;
			goil.update();
	    else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
	    	x += 10;
			
	    else if (e.getKeyCode() == KeyEvent.VK_UP)
	        y -= 10;
	    else if (e.getKeyCode() == KeyEvent.VK_DOWN)
	        y += 10;
	
	}

	
	private int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	private int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

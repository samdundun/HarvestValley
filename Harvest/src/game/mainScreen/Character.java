package game.mainScreen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import guiTeacher.components.AnimatedComponent;
import harvest.MainMenu;

public class Character implements KeyListener {
	
	/**
	  *@author Mimi Buan and Lubna Khalid and Jessi Wu
	 */
	
	private static AnimatedComponent girl;
	private static AnimatedComponent boy;
	private int x;
	private int y; 
	public Character(int x,int y) {
		boy = game.farm.FarmScreenAll.boy;
		girl = game.farm.FarmScreenAll.girl;
//		x = 430;
//		y = 200;
		this.x = x;
		this.y = y;
	}
	
	
	
	public void updateCharacter() {
		if(MainMenu.isGirl == true) {

			girl.setX(x);
			girl.setY(y);
			girl.update();
		}
		else {
			boy.setX(x);
			boy.setY(y);
			boy.update();
		}
	}
	public void keyPressed(KeyEvent e) {
		x = getX();
		y = getY(); 
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= 10;
			System.out.println("asdfasd");
			updateCharacter();
		}
	    else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	    	x += 10;
	    	updateCharacter();
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_UP) {
	        y -= 10;
	        updateCharacter();
		}
	    else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	        y += 10;
	        updateCharacter();
	    }
	
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

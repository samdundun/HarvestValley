package game.mainScreen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.KeyStroke;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.interfaces.KeyedComponent;
import harvest.MainMenu;

public class Character{
	
	/**
	  *@author Mimi Buan and Lubna Khalid and Jessi Wu
	 */
	
	private static MovableCharacter girl;
	private static MovableCharacter boy;
	private int x;
	private int y; 
	
	public Character(int x,int y) {
		boy = game.farm.FarmScreenAll.boy;
		girl = game.farm.FarmScreenAll.girl;
		x = 430;
		y = 200;
//		this.x = x;
//		this.y = y;
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
			girl.setX(girl.getX() - 10);
			boy.setX(boy.getX() - 10);
			System.out.println("asdfasd");
			updateCharacter();
		}
	    else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	    	girl.setX(girl.getX() + 10);
			boy.setX(boy.getX() + 10);
	    	updateCharacter();
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_UP) {
	    	girl.setY(girl.getY() - 10);
			boy.setY(boy.getY() - 10);
	        updateCharacter();
		}
	    else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	    	girl.setY(girl.getY() + 10);
			boy.setY(boy.getY() + 10);
	        updateCharacter();
	    }
	
	}

	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

}

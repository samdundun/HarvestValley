package game.mainScreen;

import java.awt.event.KeyEvent;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.interfaces.KeyedComponent;

public class MovableCharacter extends AnimatedComponent implements KeyedComponent {

	public MovableCharacter(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int x = getX();
		int y = getY(); 
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			setVx(-3);
//			setX(getX() - 10);
//			System.out.println("asdfasd");
		}
	    else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	    	setVx(3);
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_UP) {
	    	setVy(-3);
		}
	    else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	    	setVy(3);
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			setVx(0);
//			setX(getX() - 10);
//			System.out.println("asdfasd");
		}
	    else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	    	setVx(0);
	    }
	    else if (e.getKeyCode() == KeyEvent.VK_UP) {
	    	setVy(0);
		}
	    else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	    	setVy(0);
	    }
	}

	public void checkBehaviors() {
		if (getVx() == 0 && getVy() == 0) {
			setCurrentFrame(0);
		}
		if(getX() < 0) {
			setX(0);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFocus(boolean b) {
		// TODO Auto-generated method stub
		
	}

}

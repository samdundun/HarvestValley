package game.mainScreen;

import java.util.List;

import guiPlayer.Sampler;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.Screen;

/**
 * @author Mimi Buan
 */

public class GirlCharacter extends AnimatedComponent{
	
	private static AnimatedComponent girl;
	
	public GirlCharacter(int x, int y , int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args){
		Sampler sample = new Sampler(800, 550);
		Thread go = new Thread(sample);
		go.start();
	}

	
	public static AnimatedComponent addGirl(List<Visible> viewObjects) {
		girl = new AnimatedComponent(480, 220, 50, 100);
		girl.addSequence("resources/girl farmer.png",180, 0, 0 ,100, 160, 3);
		return girl;
	}

}

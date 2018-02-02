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
	
	public GirlCharacter(int width, int height) {
		super(width, height, height, height);
		// TODO Auto-generated constructor stub
	}
	
	private AnimatedComponent girl;
	
	
	public static void main(String[] args){
		Sampler sample = new Sampler(800, 550);
		Thread go = new Thread(sample);
		go.start();
	}


	public void initObjects(List<Visible> viewObjects) {
		girl = new AnimatedComponent(0, 0, 100, 150);
		girl.addSequence("resources/girl farmer.png",  180, 0, 0 ,100, 160, 3);
		Thread run = new Thread(girl);
		run.start();
		viewObjects.add(girl);
		

		
	}

}

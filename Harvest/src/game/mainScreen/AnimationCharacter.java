package game.mainScreen;

import java.util.List;

import guiPlayer.Sampler;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.Screen;

/**
 * @author Mimi Buan
 */

public class AnimationCharacter extends Screen{
	
	public AnimationCharacter(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 258186143576427947L;
	AnimatedComponent girl;
	private static final long serialVersionUID1 = 258186143576427947L;
	AnimatedComponent boy;
	
	public static void main(String[] args){
		Sampler sample = new Sampler(800, 550);
		Thread go = new Thread(sample);
		go.start();
	}

	@Override
	public void initObjects(List<Visible> viewObjects) {
		girl = new AnimatedComponent(250, 265, 29, 34);
		girl.addSequence("resources/girl farmer.png", 150, 234, 50, 29, 34, 3);
		Thread run = new Thread(girl);
		run.start();
		viewObjects.add(girl);
		
		boy = new AnimatedComponent(250, 400, 63, 120);
		boy.addSequence("resources/farmer.jpg", 150, 234, 50, 29, 34, 3);
		Thread runboi = new Thread(boy);
		runboi.start();
		viewObjects.add(boy);
		
	}

}

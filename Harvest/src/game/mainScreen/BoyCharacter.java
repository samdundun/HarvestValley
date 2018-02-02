package game.mainScreen;

import java.util.List;

import guiPlayer.Sampler;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.interfaces.Visible;

/**
 * @author Lubna Khalid.
 */
	
public class BoyCharacter extends AnimatedComponent {

	
	 private AnimatedComponent boy;
	public BoyCharacter(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Sampler sample = new Sampler(800, 550);
		Thread go = new Thread(sample);
		go.start();

	}
	public void initObjects(List<Visible> viewObjects) {
		boy = new AnimatedComponent(250, 50, 100, 150);
		boy.addSequence("resources/boy.png",180, 0, 0 ,100, 160, 3);
		Thread runboi = new Thread(boy);
		runboi.start();
		viewObjects.add(boy);
	
	}
	}

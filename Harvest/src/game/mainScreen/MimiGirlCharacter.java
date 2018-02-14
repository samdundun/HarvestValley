package game.mainScreen;

import java.util.List;

import guiPlayer.Sampler;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.Screen;

/**
 * @author Mimi Buan
 */

public class MimiGirlCharacter extends MimiMovableCharacter{
	
	
	public MimiGirlCharacter(int x, int y , int w, int h) {
		super(x, y, w, h);
		addSequence("resources/girl farmer.png",180, 0, 0 ,109, 160, 3);
		// TODO Auto-generated constructor stub
	}
	

	

}

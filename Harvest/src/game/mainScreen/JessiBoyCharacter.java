package game.mainScreen;

import java.util.List;

import guiPlayer.Sampler;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.interfaces.Visible;

/**
 * @author Jessi Wu.
 */

public class JessiBoyCharacter extends MimiMovableCharacter {
	
	public JessiBoyCharacter(int x, int y, int w, int h) {
		super(x, y, w, h);
		addSequence("resources/boy.png",180, 0, 0 ,109, 160, 3);
		// TODO Auto-generated constructor stub
	}


	
}


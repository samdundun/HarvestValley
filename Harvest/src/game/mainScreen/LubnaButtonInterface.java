package game.mainScreen;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;
/**
 * 
 * @author Lubna Khalid
 *
 */
public interface LubnaButtonInterface extends Clickable {
	void setColor(Color color);
	void setAction(Action a);
	void highlight();
	void dim();

}
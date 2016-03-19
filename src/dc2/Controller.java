package dc2;

import java.awt.Color;
import java.util.Date;

public abstract class Controller {
	protected Model m;
	public abstract void addTask(Task task);
	public abstract void addEvent(Event event);
}

package dc2;

import java.awt.Color;
import java.util.Date;

public class Controller {
	private ProductivityTool pt = new ProductivityTool();
	private TaskFactory tf = new TaskFactory();
	private EventFactory ef = new EventFactory();
	
	public void addTask(Date date, String name, String startTime, String endTime, Color color){
		TaskEvent te = tf.createObject(date, name, startTime, endTime, color);
		pt.addTask((Task) te);
		
	}

	public void addEvent(Date date, String name, String startTime, String endTime, Color color){
		TaskEvent te = ef.createObject(date, name, startTime, endTime, color);
		pt.addEvent((Event) te);
	}
}

package dc2;

import java.awt.Color;
import java.util.Date;

public class TaskFactory extends Factory{
	
	@Override
	public TaskEvent createObject() {
		return null;
	}

	public Task createObject(Date date, String name, String startTime, String endTime, Color color){
		Task task = new Task(date, name, startTime, color);
		return task;
		
	}

	
}

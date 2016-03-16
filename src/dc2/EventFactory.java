package dc2;

import java.awt.Color;
import java.util.Date;

public class EventFactory extends Factory{

	@Override
	public TaskEvent createObject() {
		return null;
	}

	public Event createObject(Date date, String name, String startTime, String endTime, Color color){
		Event event = new Event(date, name, startTime, endTime, color);
		return event;
		
	}
}

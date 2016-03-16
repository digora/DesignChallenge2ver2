package dc2;

import java.util.*;
import java.awt.*;
public class Event extends TaskEvent {
	
	private String endTime;
	
	public Event(Date date, String name, String startTime, String endTime, Color color)
	{
		super(date,name,startTime,color);
		this.endTime = endTime;
	}
	
	public String getEndTime()
	{
		return endTime;
	}
	
	

}

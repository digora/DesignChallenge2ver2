package dc2;

import java.util.*;
import java.awt.*;
public class Event extends TaskEvent {
	public Event(int day, String month, int year, String name, String startTime, String endTime, String color)
	{
		super(day, month, year,name,startTime,endTime, color);
		this.endTime = endTime;
	} 
	
	public String getEndTime()
	{
		return endTime;
	}
}
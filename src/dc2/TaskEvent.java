package dc2;

import java.awt.Color;
import java.util.*;

public abstract class TaskEvent {
	protected Date date;
	protected String startTime;
	protected String name;
	protected Color color;
	
	public TaskEvent(Date date, String name, String startTime, Color color)
	{
		this.date = date; 
		this.startTime = startTime;
		this.name = name;
		this.color = color;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getStartTime()
	{
		return startTime;
		
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public Date getDate()
	{
		return date;
	}
}

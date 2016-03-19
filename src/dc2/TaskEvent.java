package dc2;


import java.awt.Color;
import java.util.*;

public abstract class TaskEvent {
	protected int day;
	protected String month;
	protected int year;
	protected String startTime;
	protected String endTime;
	protected String name;
	protected String color;
	
	
	public TaskEvent(int day, String month, int year, String name, String startTime, String color)
	{
		this.day = day;
		this.month = month;
		this.year = year;
		this.startTime = startTime;
		this.name = name;
		this.color = color;
	} 
	public TaskEvent(int day, String month, int year, String name, String startTime, String endTime, String color)
	{
		this.day = day;
		this.month = month;

		this.year = year;
		this.startTime = startTime;
		this.name = name;
		this.color = color;
		this.endTime = endTime;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getStartTime()
	{
		return startTime;
		
	}
	
	public String getEndTime()
	{
		return endTime;
		
	}
	
	public String getColor()
	{
		return color;
	}
	
	public int getDay(){
		return day;
	}
	
	public String getMonth(){
		return month;
	}
	
	public int getYear(){
		return year;
	}
	
}
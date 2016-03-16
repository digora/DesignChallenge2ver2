package dc2;

import java.util.*;

public class ProductivityTool {

	private ArrayList<Task> taskList;
	private ArrayList<Event> eventList;
	private ArrayList<View> viewList;
	private CSVReaderWriter csvRW;
	
	public ArrayList<Event> getEventList()
	{
		return eventList;
	}
	
	public ArrayList<Task> getTaskList()
	{
		return taskList;
	}
	
	public void setEventList(ArrayList<Event> eventList)
	{
		this.eventList = eventList;
		
	}
	public void setTaskList(ArrayList<Task> taskList)
	{
		this.taskList = taskList;
	}
	public int getTaskSize()
	{
		return taskList.size();
	}
	
	public int getEventSize()
	{
		return eventList.size();
	}
	
	public void addTask(Task task){
		taskList.add(task);
	}
	
	public void addEvent(Event event){
		eventList.add(event);
	}
	
	public void attach(View v){
		viewList.add(v);
	}
	
	public void update(){
		
	}
}

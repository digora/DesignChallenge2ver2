package dc2;


import java.util.*;

public class ProductivityTool extends Model{
	private ArrayList<Task> taskList = new ArrayList<Task> ();
	private ArrayList<Event> eventList = new ArrayList<Event> ();
	private ArrayList<View> viewList = new  ArrayList<View> ();
	private CSVReaderWriter csvRW = new CSVReaderWriter();
	
	public ProductivityTool(){
		//csvRW = new CSVReaderWriter("C:/Users/h12/Documents/databaze.csv");
		initTaskList();
		initEventList(); 
	}
	
	public void initTaskList()
	{
		taskList = csvRW.readT("C:/Users/h12/Documents/gggg.csv");
	}
	
	public void initEventList()
	{
		eventList = csvRW.readE("C:/Users/h12/Documents/stuffstuffsss - Copy.csv");
	}
	
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
	
	public void addTask(Task t){
		taskList.add(t);
		csvRW.write(t);
		notifyObservers();
	}
	
	public void addEvent(Event e){
		eventList.add(e);
		csvRW.write(e);
		notifyObservers();
	}
	
	//Views
	public void attachView(View v){
		viewList.add(v);
	}
			
	public ArrayList getViewList(){
		return viewList;
	}
			
	public int getViewListSize(){
		return viewList.size();
	}
	
	public void notifyObservers(){
		for(int i=0; i<getViewListSize(); i++)
			viewList.get(i).update();
	}
}

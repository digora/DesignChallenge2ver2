package dc2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DayView extends AbstractViewPanel{
	private ArrayList<JPanel> timeSlotList; //Think of a way to connect to timeslots being taken boy
	private ArrayList<JPanel> hourCubeList; 
	private ArrayList<Task> tasksTodayList = new ArrayList<Task> ();
	private ArrayList<Event> eventsTodayList = new ArrayList<Event> ();
	private ArrayList<TaskEvent> allList = new ArrayList<TaskEvent>();
	
	public DayView(ProductivityTool PT, int dayFocused, String monthFocused, int yearFocused, boolean checkTask, boolean checkEvent){ //should accept values from productivityshti
		
		for(int i = 0; i < PT.getEventSize(); i++){
			if(PT.getEventList().get(i).getDay() == dayFocused && PT.getEventList().get(i).getMonth().equals(monthFocused) && PT.getEventList().get(i).getYear() == yearFocused&& PT.getEventList().get(i).getColor().equals("BLUE")){
				// day, month, year, name, start time, end time, color
				
				eventsTodayList.add(PT.getEventList().get(i));
			}
		}
			
		for(int i = 0; i < PT.getTaskSize(); i++){
			if(PT.getTaskList().get(i).getDay() == dayFocused && PT.getTaskList().get(i).getMonth().equals(monthFocused) && PT.getTaskList().get(i).getYear() == yearFocused&& PT.getTaskList().get(i).getColor().equals("GREEN")){
				//day, month, year, name, start time, color
				tasksTodayList.add(PT.getTaskList().get(i));
			}
		}
		
			for(int i = 0; i < tasksTodayList.size(); i++){
				allList.add(tasksTodayList.get(i));
			}
			
			for(int i = 0; i < eventsTodayList.size(); i++){
				allList.add(eventsTodayList.get(i));
			}
			
			for(int j = 0; j < allList.size(); j++){
				System.out.println("DIED " + allList.get(j).getName() + " on " + allList.get(j).getDay() + " " + allList.get(j).getMonth() + " " + allList.get(j).getYear() + " Showtime "  + allList.get(j).getStartTime() + " Color " + allList.get(j).getColor() );
			}
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints timeslotC = new GridBagConstraints();
		GridBagConstraints hourC = new GridBagConstraints();
		//48 time slots
		//24 Hour cubes;
		
		timeSlotList = new ArrayList<>();
		hourCubeList = new ArrayList<>();
		
		//Instiation of the time shit niga
		for(int i = 0;i < 48;i++){
			
			timeSlotList.add(new JPanel());
			timeSlotList.get(i).setOpaque(true);
			timeSlotList.get(i).setBackground(Color.yellow);
			
			String time = "";
			String hour = "" + i/2;
			String minutes = "" + (i%2*30);
		//	System.out.println("BEFORE PROCESSING: " + hour + ":" + minutes);
			//if(hour.length() == 1){
			//	hour = "0" + hour;
			//}
			if(minutes.length() != 2){
				minutes = "00";
			}
			time = hour + ":" + minutes;
			System.out.println("TIME: " + time);
			
			for(int j = 0; j < allList.size(); j++ ){
				System.out.println("I am checking out: " + allList.get(j).getName() + " on " + allList.get(j).getDay() + " " + allList.get(j).getMonth() + " " + allList.get(j).getYear() + " Showtime "  + allList.get(j).getStartTime() + " Color " + allList.get(j).getColor() );
				if(allList.get(j).getStartTime().equals(time)){
					if(allList.get(j).getColor().equals("BLUE")){
						
						timeSlotList.get(i).add(new JLabel(allList.get(j).getName()));
						timeSlotList.get(i).setBackground(Color.blue);
						/*
						for(int x2 = 0; ; x2++){
							
							timeSlotList.get(i).setBackground(Color.blue);
							String ntime = "";
							String nhour = "" + i/2;
							String nminutes = "" + (i%2*30);
						//	System.out.println("BEFORE PROCESSING: " + hour + ":" + minutes);
							//if(hour.length() == 1){
							//	hour = "0" + hour;
							//}
							if(nminutes.length() != 2){
								nminutes = "00";
							}
							ntime = nhour + ":" + nminutes;
							System.out.println("TIME: " + ntime);
							if(allList.get(j).getEndTime().equals(ntime)){
								break;
							}
							
						}
						*/
					}else{
						timeSlotList.get(i).add(new JLabel(allList.get(j).getName()));
						timeSlotList.get(i).setBackground(Color.green);
					}
				}
			}
			
		
				
			
			timeslotC.gridx = 1;
			timeslotC.gridy = i;
			timeslotC.fill = GridBagConstraints.BOTH;
			timeslotC.weighty = 1;
			timeslotC.weightx = 0.8;
			this.add(timeSlotList.get(i), timeslotC);
			
			
		}
		
		
		hourC.fill = GridBagConstraints.BOTH;
		hourC.weightx = 0.2;
		hourC.weighty = 0.5;
		hourC.gridheight = 2;
		
		int x = 0;
		
		for(int j = 0; j < 24; j++){
			
			hourCubeList.add(new JPanel(new GridBagLayout()));
			hourCubeList.get(j).setOpaque(true);
			if(j % 2 == 0){
				hourCubeList.get(j).setBackground(Color.GREEN);
			}else{
				hourCubeList.get(j).setBackground(Color.lightGray);
			}
			GridBagConstraints c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = 0;
			JLabel lblConstTime = new JLabel();
			
			if(j >= 10){
				lblConstTime.setText("" + j + ":00" );
			}else{
				lblConstTime.setText("0" + j + ":00");
			}
			
			hourCubeList.get(j).add(lblConstTime, c);
			hourC.gridx = 0;
			hourC.gridy = j + x;
			x++;
			this.add(hourCubeList.get(j), hourC);
			
			
		}
		
		
		
	}
	

	@Override
	void update(ProductivityTool PT, int dayFocused, String monthFocused, int yearFocused, boolean checkTask, boolean checkEvent) {
		// TODO Auto-generated method stub
		//System.out.println("Dayu");
	}
 //Pass a method that gets the state of the calendar (With events and agendas for today)
}

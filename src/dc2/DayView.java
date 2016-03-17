package dc2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DayView extends AbstractViewPanel{
	private ArrayList<JPanel> timeSlotList; //Think of a way to connect to timeslots being taken boy
	private ArrayList<JPanel> hourCubeList; 
	
	public DayView(){ //should accept values from productivityshti
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
			if(i % 2 == 0)
				timeSlotList.get(i).setBackground(Color.magenta);
			else
				timeSlotList.get(i).setBackground(Color.yellow);
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
	void update() {
		// TODO Auto-generated method stub
		
	}
 //Pass a method that gets the state of the calendar (With events and agendas for today)
}

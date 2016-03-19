package dc2;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class AgendaView extends AbstractViewPanel{

	private ArrayList<JLabel> eventsThisDayList = new ArrayList<>();
	private ArrayList<JLabel> timePartList = new ArrayList<>();
	
	
	public AgendaView(ProductivityTool PT, int dayFocused, String monthFocused, int yearFocused, boolean checkTask, boolean checkEvent){

		
		
		
		if(checkEvent && !checkTask){
			System.out.println("noone");
			for(int i = 0; i < PT.getEventSize(); i++){
				if(PT.getEventList().get(i).getDay() == dayFocused && PT.getEventList().get(i).getMonth().equals(monthFocused) && PT.getEventList().get(i).getYear() == yearFocused&& PT.getTaskList().get(i).getColor().equals("BLUE")){
					eventsThisDayList.add(new JLabel(PT.getEventList().get(i).getName()));
					timePartList.add(new JLabel(PT.getEventList().get(i).getStartTime() + " - " + PT.getEventList().get(i).getEndTime()));
					eventsThisDayList.get(i).setForeground(Color.blue);
					timePartList.get(i).setForeground(Color.blue);
				}
			}
		}else if(checkTask && !checkEvent){
			System.out.println("no");
			for(int i = 0; i < PT.getTaskSize(); i++){
				if(PT.getTaskList().get(i).getDay() == dayFocused && PT.getTaskList().get(i).getMonth().equals(monthFocused) && PT.getTaskList().get(i).getYear() == yearFocused&& PT.getTaskList().get(i).getColor().equals("GREEN")){
					eventsThisDayList.add(new JLabel(PT.getTaskList().get(i).getName()));
					timePartList.add(new JLabel(PT.getTaskList().get(i).getStartTime()));
					eventsThisDayList.get(i).setForeground(Color.green);
					timePartList.get(i).setForeground(Color.green);
				}
			}
			
		}else if((checkEvent && checkTask) || (!checkEvent && !checkTask)){
			System.out.println("here");
			for(int i = 0; i < PT.getTaskSize(); i++){
				if(PT.getTaskList().get(i).getDay() == dayFocused && PT.getTaskList().get(i).getMonth().equals(monthFocused) && PT.getTaskList().get(i).getYear() == yearFocused && PT.getTaskList().get(i).getColor().equals("GREEN")){
					System.out.println(PT.getTaskList().get(i).getName());
					eventsThisDayList.add(new JLabel(PT.getTaskList().get(i).getName()));
					timePartList.add(new JLabel(PT.getTaskList().get(i).getStartTime()));
					eventsThisDayList.get(i).setForeground(Color.green);
					timePartList.get(i).setForeground(Color.green);
				}
			}
			System.out.println("ETDL: " + eventsThisDayList.size() + " " + "Task: " + PT.getTaskSize() +  " EVENT " + PT.getEventSize());
			for(int j = 0; j < PT.getEventSize(); j++){
				if(PT.getEventList().get(j).getDay() == dayFocused && PT.getEventList().get(j).getMonth().equals(monthFocused) && PT.getEventList().get(j).getYear() == yearFocused && PT.getEventList().get(j).getColor().equals("BLUE")){
					eventsThisDayList.add(new JLabel(PT.getEventList().get(j).getName()));
					timePartList.add(new JLabel(PT.getEventList().get(j).getStartTime() + " - " + PT.getEventList().get(j).getEndTime()));
					eventsThisDayList.get(j+PT.getTaskSize()).setForeground(Color.blue);
					timePartList.get(j+PT.getTaskSize()).setForeground(Color.blue);
				}
			}
			
		}
		
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints agendaC = new GridBagConstraints();
		agendaC.insets = new Insets(20,20,20,20);
		
		if(eventsThisDayList.size() == 0 ){
			//<html>Text color: <font color='red'>red</font></html>
			JLabel lblSignalEmpty = new JLabel("There are no events this day");
			
			agendaC.gridx = 0;
			agendaC.gridy = 0;
			this.add(lblSignalEmpty, agendaC);
			
		}else{
			for(int i = 0; i < eventsThisDayList.size(); i++){
				agendaC.gridx = 0;
				agendaC.gridy = i;
				this.add(eventsThisDayList.get(i), agendaC);
				agendaC.gridx = 1;
				agendaC.gridy = i;
				this.add(timePartList.get(i), agendaC);
			}

		}
	}
	
	@Override
	void update(ProductivityTool PT, int dayFocused, String monthFocused, int yearFocused, boolean checkTask, boolean checkEvent) {
		timePartList.clear();
		eventsThisDayList.clear();
		this.removeAll();
		
		for(int i = 0; i < PT.getTaskSize(); i++){
			if(PT.getTaskList().get(i).getDay() == dayFocused && PT.getTaskList().get(i).getMonth().equals(monthFocused) && PT.getTaskList().get(i).getYear() == yearFocused && PT.getTaskList().get(i).getColor().equals("GREEN")){
				eventsThisDayList.add(new JLabel(PT.getTaskList().get(i).getName()));
				timePartList.add(new JLabel(PT.getTaskList().get(i).getStartTime()));
				eventsThisDayList.get(i).setForeground(Color.green);
				timePartList.get(i).setForeground(Color.green);
			}
		}
		
		
		
		for(int j = 0; j < PT.getEventSize(); j++){
			if(PT.getEventList().get(j).getDay() == dayFocused && PT.getEventList().get(j).getMonth().equals(monthFocused) && PT.getEventList().get(j).getYear() == yearFocused && PT.getEventList().get(j).getColor().equals("BLUE")){
				eventsThisDayList.add(new JLabel(PT.getEventList().get(j).getName()));
				timePartList.add(new JLabel(PT.getEventList().get(j).getStartTime() + " - " + PT.getEventList().get(j).getEndTime()));
				eventsThisDayList.get(j+PT.getTaskSize()).setForeground(Color.blue);
				timePartList.get(j+PT.getTaskSize()).setForeground(Color.blue);
			}
		}
		
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints agendaC = new GridBagConstraints();
		agendaC.insets = new Insets(20,20,20,20);
		
		if(eventsThisDayList.size() == 0 ){
			//<html>Text color: <font color='red'>red</font></html>
			JLabel lblSignalEmpty = new JLabel("There are no events this day");
			
			agendaC.gridx = 0;
			agendaC.gridy = 0;
			this.add(lblSignalEmpty, agendaC);
			
		}else{
			for(int i = 0; i < eventsThisDayList.size(); i++){
				agendaC.gridx = 0;
				agendaC.gridy = i;
				this.add(eventsThisDayList.get(i), agendaC);
				agendaC.gridx = 1;
				agendaC.gridy = i;
				this.add(timePartList.get(i), agendaC);
			}

		}
		
		this.repaint();
		this.revalidate();
	}
	
	public void checkFilter(ProductivityTool PT, int dayFocused, String monthFocused, int yearFocused, boolean checkTask, boolean checkEvent){
		// TODO Auto-generated method stub
				timePartList.clear();
				eventsThisDayList.clear();
				this.removeAll();
				
				if(checkEvent && !checkTask){
					System.out.println("no");
					for(int i = 0; i < PT.getEventSize(); i++){
						if(PT.getEventList().get(i).getDay() == dayFocused && PT.getEventList().get(i).getMonth().equals(monthFocused) && PT.getEventList().get(i).getYear() == yearFocused&& PT.getEventList().get(i).getColor().equals("BLUE")){
							eventsThisDayList.add(new JLabel(PT.getEventList().get(i).getName()));
							timePartList.add(new JLabel(PT.getEventList().get(i).getStartTime() + " - " + PT.getEventList().get(i).getEndTime()));
							eventsThisDayList.get(i).setForeground(Color.blue);
							timePartList.get(i).setForeground(Color.blue);
						}
					}
				}else if(checkTask && !checkEvent){
					System.out.println("no");
					for(int i = 0; i < PT.getTaskSize(); i++){
						if(PT.getTaskList().get(i).getDay() == dayFocused && PT.getTaskList().get(i).getMonth().equals(monthFocused) && PT.getTaskList().get(i).getYear() == yearFocused&& PT.getTaskList().get(i).getColor().equals("GREEN")){
							eventsThisDayList.add(new JLabel(PT.getTaskList().get(i).getName()));
							timePartList.add(new JLabel(PT.getTaskList().get(i).getStartTime()));
							eventsThisDayList.get(i).setForeground(Color.green);
							timePartList.get(i).setForeground(Color.green);
						}
					}
					
				}else if((checkEvent && checkTask) || (!checkEvent && !checkTask)){
					System.out.println("here");
					for(int i = 0; i < PT.getTaskSize(); i++){
						if(PT.getTaskList().get(i).getDay() == dayFocused && PT.getTaskList().get(i).getMonth().equals(monthFocused) && PT.getTaskList().get(i).getYear() == yearFocused && PT.getTaskList().get(i).getColor().equals("GREEN")){
							eventsThisDayList.add(new JLabel(PT.getTaskList().get(i).getName()));
							timePartList.add(new JLabel(PT.getTaskList().get(i).getStartTime()));
							eventsThisDayList.get(i).setForeground(Color.green);
							timePartList.get(i).setForeground(Color.green);
						}
					}
					
					for(int j = 0; j < PT.getEventSize(); j++){
						if(PT.getEventList().get(j).getDay() == dayFocused && PT.getEventList().get(j).getMonth().equals(monthFocused) && PT.getEventList().get(j).getYear() == yearFocused && PT.getEventList().get(j).getColor().equals("BLUE")){
							eventsThisDayList.add(new JLabel(PT.getEventList().get(j).getName()));
							timePartList.add(new JLabel(PT.getEventList().get(j).getStartTime() + " - " + PT.getEventList().get(j).getEndTime()));
							eventsThisDayList.get(j+PT.getTaskSize()).setForeground(Color.blue);
							timePartList.get(j+PT.getTaskSize()).setForeground(Color.blue);
						}
					}
					
				}
				
				this.setLayout(new GridBagLayout());
				
				GridBagConstraints agendaC = new GridBagConstraints();
				agendaC.insets = new Insets(20,20,20,20);
				
				if(eventsThisDayList.size() == 0 ){
					//<html>Text color: <font color='red'>red</font></html>
					JLabel lblSignalEmpty = new JLabel("There are no events this day");
					
					agendaC.gridx = 0;
					agendaC.gridy = 0;
					this.add(lblSignalEmpty, agendaC);
					
				}else{
					for(int i = 0; i < eventsThisDayList.size(); i++){
						agendaC.gridx = 0;
						agendaC.gridy = i;
						this.add(eventsThisDayList.get(i), agendaC);
						agendaC.gridx = 1;
						agendaC.gridy = i;
						this.add(timePartList.get(i), agendaC);
					}

				}
				
				this.repaint();
				this.revalidate();
	}
	//Pass a method that gets the state of the calendar (With events and agendas for today)
	
	
	
}
//ll //sd //no //wat
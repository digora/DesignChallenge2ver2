package dc2;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class AgendaView extends AbstractViewPanel{

	private ArrayList<JLabel> eventsThisDayList;
	private ArrayList<JLabel> timePartList;
	
	public AgendaView(){
		
		eventsThisDayList = new ArrayList<>();
		
		
		this.setLayout(new GridBagLayout());
		
		if(eventsThisDayList.size() == 0 ){
			
			JLabel lblSignalEmpty = new JLabel("There are no events this day");
			GridBagConstraints agendaC = new GridBagConstraints();
			agendaC.gridx = 0;
			agendaC.gridy = 0;
			this.add(lblSignalEmpty, agendaC);
			
		}
	}
	
	@Override
	void update() {
		// TODO Auto-generated method stub
		
	}
	//Pass a method that gets the state of the calendar (With events and agendas for today)
	
	
	
	
}
//ll //sd //no //wat
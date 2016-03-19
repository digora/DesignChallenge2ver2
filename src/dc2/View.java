package dc2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class View extends AbstractView{
	private JLabel lblTitle;
	private JLabel lblFDate;
	private JLabel lblView;
	private JLabel lblDay;
    
	private DayView dayView;
	private AgendaView agendaView;
	private ProductivityTool pTool;
	private CalendarGUI calendarPanel;
	 
	private JCheckBox chkEvent;
	private JCheckBox chkTask;
 
	private JButton btnToday;
	private JButton btnDay;
	private JButton btnAgenda;
	private JButton btnCreate;
	private JButton btnSave;
	private JButton btnDiscard;

	private JRadioButton rbEvent;
	private JRadioButton rbTask;

	private JPanel panelSuperContainer;
	private JPanel panelDeck;
	private JPanel panelCreateView;

	private JTextField txtInputName;

	private JComboBox cmbFrom;
	private JComboBox cmbTo;

	private JScrollPane jspScrollDay;
	private JScrollPane jspScrollAgenda;
	
	private ConcreteController controller;
	
	final static String DAY_VIEW = "Card with day view";
	final static String AGENDA_VIEW = "Card with agenda view";
	final static String CREATE_VIEW = "Card with create view";
	
	public View(int width, int height, String title, ProductivityTool PT){
	
		this.pTool = PT;
		
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
		this.setSize(width, height);
		this.setTitle(title);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controller = new ConcreteController(PT);
		
		calendarPanel = new CalendarGUI(this);
		String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		GridBagConstraints cFrame = new GridBagConstraints();
		cFrame.gridx = 0;
		cFrame.gridy = 0;
		cFrame.weightx = 1;
		cFrame.weighty = 1;
		cFrame.fill = GridBagConstraints.BOTH;
		
		panelSuperContainer = new JPanel(new GridBagLayout());
		panelSuperContainer.setOpaque(true);
		panelSuperContainer.setBackground(Color.blue);
		
		this.add(panelSuperContainer, cFrame);
		
		GridBagConstraints cGen = new GridBagConstraints();
		cGen.insets = new Insets(10,10,10,10);
		
		lblTitle = new JLabel("My Productivity Tool");
		lblTitle.setOpaque(true);
		lblTitle.setBackground(Color.white);
		cGen.gridx = 0;
		cGen.gridy = 0;
		cGen.weightx = 0.3;
		cGen.fill = GridBagConstraints.HORIZONTAL;
		panelSuperContainer.add(lblTitle, cGen);
		
		btnToday = new JButton("Today");
		btnToday.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				lblFDate.setText(months[calendarPanel.getCalendar().getMonthToday()] + " " + calendarPanel.getCalendar().getDayToday() + "," + calendarPanel.getCalendar().getYearToday());
				lblDay.setText(lblFDate.getText());
				btnCreate.setEnabled(true);
				//update();
				CardLayout cl = (CardLayout)(panelDeck.getLayout());
				cl.show(panelDeck, DAY_VIEW);
			}
		});
		cGen.gridx = 1;
		cGen.gridy = 0;
		cGen.weightx = 0;
		//cGen.gridwidth = 1;
		cGen.fill = GridBagConstraints.NONE;
		panelSuperContainer.add(btnToday, cGen);
		
		lblFDate = new JLabel(calendarPanel.getMonthFocused() + " " + calendarPanel.getDayFocused() + "," + calendarPanel.getYearFocused());
		
		cGen.gridx = 2;
		cGen.gridy = 0;
		cGen.weightx = 0.5;
		cGen.fill = GridBagConstraints.HORIZONTAL;
		panelSuperContainer.add(lblFDate, cGen);
		
		btnDay = new JButton("Day");
		btnDay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnCreate.setEnabled(true);
				CardLayout cl = (CardLayout)(panelDeck.getLayout());
				cl.show(panelDeck, DAY_VIEW);
			}
		});
		cGen.gridx = 3;
		cGen.gridy = 0;
		cGen.weightx = 0;
		cGen.fill = GridBagConstraints.NONE;
		cGen.insets = new Insets(10, 10, 10, 0);
		panelSuperContainer.add(btnDay, cGen);
		
		btnAgenda = new JButton("Agenda");
		btnAgenda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnCreate.setEnabled(true);
				
				CardLayout cl = (CardLayout)(panelDeck.getLayout());
				cl.show(panelDeck, AGENDA_VIEW);
			}
		});
		cGen.gridx = 4;
		cGen.gridy = 0;
		cGen.insets = new Insets(10, 0, 10, 10);
		panelSuperContainer.add(btnAgenda, cGen);
		
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnCreate.setEnabled(false);
				CardLayout cl = (CardLayout)(panelDeck.getLayout());
				cl.show(panelDeck, CREATE_VIEW);
			}
		});
		btnCreate.setOpaque(true);
		btnCreate.setBackground(Color.red);
		cGen.gridx = 0;
		cGen.gridy = 1;
		cGen.weightx = 0.3;
		cGen.fill = GridBagConstraints.HORIZONTAL;
		cGen.insets = new Insets(10, 10, 10, 10);
		panelSuperContainer.add(btnCreate, cGen);
		
		panelDeck = new JPanel(new CardLayout());
		GridBagConstraints deckC = new GridBagConstraints();
		deckC.gridx = 1;
		deckC.gridy = 1;
		deckC.weightx = 0.7;
		deckC.weighty = 0.9;
		deckC.gridheight = 5;
		deckC.gridwidth = 4;
		deckC.fill = GridBagConstraints.BOTH;
		panelSuperContainer.add(panelDeck, deckC);
		
		GridBagConstraints viewC = new GridBagConstraints();
		viewC.insets = new Insets(10, 10, 10, 10);
		
		panelCreateView = new JPanel(new GridBagLayout());
		panelCreateView.setOpaque(true);
		panelCreateView.setBackground(Color.GRAY);
		
		JLabel tempLabel1 = new JLabel("to");
		viewC.gridx = 2;
		viewC.gridy = 1;
		panelCreateView.add(tempLabel1, viewC);	
		
		txtInputName = new JTextField();
		viewC.gridx = 0;
		viewC.gridy = 0;
		viewC.gridwidth = 4;
		viewC.weightx = 0.3;
		viewC.fill = GridBagConstraints.HORIZONTAL;
		panelCreateView.add(txtInputName, viewC);
		
		viewC.gridwidth = 1;
		
		rbEvent = new JRadioButton("Event");
		rbEvent.setSelected(true);
		rbEvent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cmbTo.setVisible(true);
				tempLabel1.setVisible(true);
				
			}
		});
		viewC.gridx = 4;
		viewC.gridy = 0;
		viewC.weightx = 0.2;
		viewC.fill = GridBagConstraints.NONE;
		panelCreateView.add(rbEvent, viewC);
		
		viewC.gridwidth = 1;
		
		rbTask = new JRadioButton("Task");
		rbTask.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cmbTo.setVisible(false);
				tempLabel1.setVisible(false);
			}
		});
		viewC.gridx = 5;
		viewC.gridy = 0;
		viewC.weightx = 0.2;
		panelCreateView.add(rbTask, viewC);
		
		viewC.weightx = 0;
		
		
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(rbEvent); //add mouse listeners pa and actionlistener
		bGroup.add(rbTask);
		
		
		lblDay = new JLabel();
		lblDay.setText(lblFDate.getText());
		viewC.gridx = 0;
		viewC.gridy = 1;
		panelCreateView.add(lblDay, viewC);
		
		String timeSlots[] = new String[48];
		int run = 0;
		for(int x2 = 0; x2 < 24; x2++){
			for(int x3 = 0; x3 < 2; x3++){
				if(x2 < 10){
					timeSlots[run] = ("0" + x2 + ":" + (x3*3) + "0");
				}else{
					timeSlots[run] = (x2 + ":" + (x3*3) + "0");
				}
				run++;
			}
		}
		
		cmbFrom = new JComboBox(timeSlots);
		viewC.gridx = 1;
		viewC.gridy = 1;
		panelCreateView.add(cmbFrom, viewC);
		
		
		
		cmbTo = new JComboBox(timeSlots);
		viewC.gridx = 3;
		viewC.gridy = 1;
		panelCreateView.add(cmbTo, viewC);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCreate.setEnabled(true);
				// TODO Auto-generated method stub
				if(rbEvent.isSelected()){
					//make new event
					// day, month, year, name, start time, end time, color
					controller.addEvent(new Event(calendarPanel.getDayFocused(), calendarPanel.getMonthFocused(), calendarPanel.getYearFocused(), txtInputName.getText(), cmbFrom.getSelectedItem().toString(), cmbTo.getSelectedItem().toString(), "BLUE"));
					cmbFrom.setSelectedIndex(0);
					cmbTo.setSelectedIndex(0);
					txtInputName.setText("");
					
					CardLayout cl = (CardLayout)(panelDeck.getLayout());
					cl.show(panelDeck, DAY_VIEW);
				}else{
					//make new task
					//day, month, year, name, start time, color
					controller.addTask(new Task(calendarPanel.getDayFocused(), calendarPanel.getMonthFocused(), calendarPanel.getYearFocused(), txtInputName.getText() ,cmbFrom.getSelectedItem().toString(), "GREEN"));
					cmbFrom.setSelectedIndex(0);
					cmbTo.setSelectedIndex(0);
					txtInputName.setText("");
					
					CardLayout cl = (CardLayout)(panelDeck.getLayout());
					cl.show(panelDeck, DAY_VIEW);
				}
			}
		});
		viewC.gridx = 0;
		viewC.gridy = 2;
		panelCreateView.add(btnSave, viewC);
		
		btnDiscard = new JButton("Discard");
		btnDiscard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cmbFrom.setSelectedIndex(0);
				cmbTo.setSelectedIndex(0);
				txtInputName.setText("");
				btnCreate.setEnabled(true);
				CardLayout cl = (CardLayout)(panelDeck.getLayout());
				cl.show(panelDeck, DAY_VIEW);
			}
		});
		viewC.gridx = 1;
		viewC.gridy = 2;
		panelCreateView.add(btnDiscard, viewC);
		/*
		panelDayViewPH = new JPanel();
		panelDayViewPH.setOpaque(true);
		panelDayViewPH.setBackground(Color.cyan);
		*/

		
		/*
		panelAgendaViewPH = new JPanel();
		panelAgendaViewPH.setOpaque(true);
		panelAgendaViewPH.setBackground(Color.green);
		*/
		cGen.fill = GridBagConstraints.NONE;
		chkEvent = new JCheckBox("Event");
		chkEvent.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Object source = e.getItemSelectable();
				
				if(source == chkEvent){
					agendaView.checkFilter(PT, calendarPanel.getDayFocused(), calendarPanel.getMonthFocused(), calendarPanel.getYearFocused(),chkTask.isSelected(), chkEvent.isSelected());
				}
			}
		});
		cGen.gridx = 0;
		cGen.gridy = 4;
		cGen.weightx = 0;
		cGen.weighty = 0.1;
		panelSuperContainer.add(chkEvent, cGen);
		
		chkTask = new JCheckBox("Task");
		chkTask.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Object source = e.getItemSelectable();
				
				if(source == chkTask){
					agendaView.checkFilter(PT, calendarPanel.getDayFocused(), calendarPanel.getMonthFocused(), calendarPanel.getYearFocused(),chkTask.isSelected(), chkEvent.isSelected());
				}
			}
		});
		cGen.gridx = 0;
		cGen.gridy = 5;
		cGen.weightx = 0;
		cGen.weighty = 0.1;
		panelSuperContainer.add(chkTask, cGen);
		
		agendaView = new AgendaView(PT, calendarPanel.getDayFocused(), calendarPanel.getMonthFocused(), calendarPanel.getYearFocused(), chkTask.isSelected(), chkEvent.isSelected());
		dayView = new DayView(PT, calendarPanel.getDayFocused(), calendarPanel.getMonthFocused(), calendarPanel.getYearFocused(), chkTask.isSelected(), chkEvent.isSelected());
		
		jspScrollDay = new JScrollPane();
		jspScrollDay.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jspScrollDay.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jspScrollDay.setViewportView(dayView);
		
		jspScrollAgenda = new JScrollPane();
		jspScrollAgenda.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jspScrollAgenda.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jspScrollAgenda.setViewportView(agendaView);
		
		panelDeck.add(jspScrollDay, DAY_VIEW);
		panelDeck.add(jspScrollAgenda, AGENDA_VIEW);
		panelDeck.add(panelCreateView, CREATE_VIEW);
		
		/*
		panelCalendarPH = new JPanel();
		panelCalendarPH.setOpaque(true);
		panelCalendarPH.setBackground(Color.red);
		*/
		
		
		cGen.gridx = 0;
		cGen.gridy = 2;
		cGen.weightx = 0.3;
		cGen.weighty = 0.5;
		cGen.fill = GridBagConstraints.BOTH;
		panelSuperContainer.add(calendarPanel, cGen);
		
		lblView = new JLabel("View");
		lblView.setOpaque(true);
		lblView.setBackground(Color.white);
		cGen.gridx = 0;
		cGen.gridy = 3;
		cGen.weightx = 0;
		cGen.weighty = 0.1;
		cGen.fill = GridBagConstraints.NONE;
		panelSuperContainer.add(lblView, cGen);
		
		
		panelSuperContainer.revalidate();
		
	}

	@Override
	void update() {
		// TODO Auto-generated method stub
		lblFDate.setText(calendarPanel.getMonthFocused() + " " + calendarPanel.getDayFocused() + "," + calendarPanel.getYearFocused());
		lblDay.setText(lblFDate.getText());
		agendaView.update(pTool, calendarPanel.getDayFocused(), calendarPanel.getMonthFocused(), calendarPanel.getYearFocused(),chkTask.isSelected(), chkEvent.isSelected());
		dayView.update(pTool, calendarPanel.getDayFocused(), calendarPanel.getMonthFocused(), calendarPanel.getYearFocused(),chkTask.isSelected(), chkEvent.isSelected());
	
	}
	
}

package dc2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JFrame{
	JLabel lblTitle;
	JLabel lblFDate;
	JLabel lblView;
	
	JCheckBox chkEvent;
	JCheckBox chkTask;
	
	JButton btnToday;
	JButton btnDay;
	JButton btnAgenda;
	JButton btnCreate;
	
	JPanel panelSuperContainer;
	JPanel panelCalendarPH;
	JPanel panelDayViewPH;
	JPanel panelAgendaViewPH;
	JPanel panelDeck;
	JPanel panelCreateView;
	
	JScrollPane jspScrollDay;
	JScrollPane jspScrollAgenda;
	
	final static String DAY_VIEW = "Card with day view";
	final static String AGENDA_VIEW = "Card with agenda view";
	final static String CREATE_VIEW = "Card with create view";
	
	public View(int width, int height, String title){
		
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
		this.setSize(width, height);
		this.setTitle(title);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		cGen.gridx = 1;
		cGen.gridy = 0;
		cGen.weightx = 0;
		//cGen.gridwidth = 1;
		cGen.fill = GridBagConstraints.NONE;
		panelSuperContainer.add(btnToday, cGen);
		
		lblFDate = new JLabel("INSERTGETDATEHERE");
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
		deckC.gridheight = 2;
		deckC.gridwidth = 4;
		deckC.fill = GridBagConstraints.BOTH;
		panelSuperContainer.add(panelDeck, deckC);
		
		
		panelDayViewPH = new JPanel();
		panelDayViewPH.setOpaque(true);
		panelDayViewPH.setBackground(Color.cyan);
		
		panelAgendaViewPH = new JPanel();
		panelAgendaViewPH.setOpaque(true);
		panelAgendaViewPH.setBackground(Color.green);
		
		panelCreateView = new JPanel();
		panelCreateView.setOpaque(true);
		panelCreateView.setBackground(Color.GRAY);
		
		
		jspScrollDay = new JScrollPane();
		jspScrollDay.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jspScrollDay.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jspScrollDay.setViewportView(panelDayViewPH);
		
		jspScrollAgenda = new JScrollPane();
		jspScrollAgenda.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jspScrollAgenda.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jspScrollAgenda.setViewportView(panelAgendaViewPH);
		
		panelDeck.add(jspScrollDay, DAY_VIEW);
		panelDeck.add(jspScrollAgenda, AGENDA_VIEW);
		panelDeck.add(panelCreateView, CREATE_VIEW);
		
		panelSuperContainer.revalidate();
		
	}
	
}

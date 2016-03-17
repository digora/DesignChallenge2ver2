package dc2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.GregorianCalendar;

public class CalendarGUI extends JPanel{
	private JPanel panelHeader;
	private JPanel panelDay;
	
	private JLabel[][] lblDayArray  = new JLabel[7][6];
	
	private JLabel lblMonth;
	private JLabel lblYear;
	
	private JButton btnNext;
	private JButton btnPrev;
	
	private int currDay;
	private int currYear;
	private int currMonth;
	
	private int dayToday;
	private int yearToday;
	private int monthToday;

	private int dayFocused;
	private String monthFocused;
	private int yearFocused;
	
	private CalendarClass calendar = new CalendarClass();
	
	

	public CalendarGUI(View view){
		//just do it //2d array //refresh cal
		String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		currDay = calendar.getCurrDay();
		currYear = calendar.getCurrYear();
		currMonth = calendar.getCurrMonth();
		
		dayToday = calendar.getDayToday();
		yearToday = calendar.getYearToday();
		monthToday = calendar.getMonthToday();
		
		dayFocused = calendar.getDayToday();
		monthFocused = months[calendar.getMonthToday()];
		yearFocused = calendar.getYearToday();
		
		
		System.out.println("Today is: " + (monthToday+1) + "/" + dayToday + "/" + yearToday);
		
		this.setOpaque(true);
		this.setBackground(Color.red);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0.1;
		c.fill = GridBagConstraints.BOTH;
		
		panelHeader = new JPanel(new GridBagLayout());
		panelHeader.setOpaque(true);
		panelHeader.setBackground(Color.lightGray);
		this.add(panelHeader, c);
		
		/* Panel Header Elements */
		
		GridBagConstraints d = new GridBagConstraints();
		d.insets = new Insets(10,10,10,10);
		lblMonth = new JLabel(months[currMonth]);
		d.gridx = 0;
		d.gridy = 0;
		panelHeader.add(lblMonth, d);
		
		lblYear = new JLabel(""+ currYear);
		d.gridx = 1;
		panelHeader.add(lblYear, d);
		
		btnPrev = new JButton("<<");
		btnPrev.setOpaque(true);
		btnPrev.setBackground(Color.cyan);
		btnPrev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("prev");
				calendar.setCurrDate(0);
				refreshCalendar();
			}
		});
		d.gridx = 2;
		d.insets = new Insets(10, 50, 10, 10);
		panelHeader.add(btnPrev, d);
		
		btnNext = new JButton(">>");
		btnNext.setOpaque(true);
		btnNext.setBackground(Color.CYAN);
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				calendar.setCurrDate(1);
				refreshCalendar();
			}
		});
		d.gridx = 3;
		d.insets = new Insets(10, 10, 10, 10);
		panelHeader.add(btnNext, d);
		/* Panel Header Elements End */
		
		panelDay = new JPanel(new GridBagLayout());
		panelDay.setOpaque(true);
		panelDay.setBackground(Color.cyan);
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 0.9;
		this.add(panelDay, c);
		
		/*Panel Day Elements Start*/
		GridBagConstraints f = new GridBagConstraints();
		f.gridy = 0;
		f.insets = new Insets(10, 10 ,10, 10);
		
		
		String dayOfWeek[] = {"S", "M", "T", "W",  "TH",  "F", "S"};
		for(int i = 0; i < 7; i++){
			JLabel header = new JLabel();
			header.setText(dayOfWeek[i]);
			f.gridx = i;
			panelDay.add(header, f);	
		}
		
		
		
		/*Setting the day*/
		GregorianCalendar cal = new GregorianCalendar(currYear, currMonth, 1);
		int nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		int som = cal.get(GregorianCalendar.DAY_OF_WEEK); 
                
		
		
		GridBagConstraints gridC = new GridBagConstraints();
		gridC.insets = new Insets(10, 10, 10, 10);
		//7x5
		for(int j = 0; j < 6; j++){
			
			for(int x = 0; x < 7; x++){
				lblDayArray[x][j] = new JLabel("");
				lblDayArray[x][j].addMouseListener(new MouseAdapter()  
				{  
				    public void mouseClicked(MouseEvent e)  
				    {  
				    	
				    	String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
				    	dayFocused = Integer.parseInt(((JLabel)e.getSource()).getText());
				    	monthFocused = months[currMonth];
				    	yearFocused = currYear;
				    	view.update();
				    	System.out.println("I clicked: " + monthFocused + " " + dayFocused + "," + yearFocused);
				    }  
				}); 
				gridC.gridx = x;
				gridC.gridy = j+1;
				panelDay.add(lblDayArray[x][j], gridC);
			}
		}
		
		for (int i2 = 1; i2 <= nod; i2++)
	        {
				int row = new Integer((i2+som-2)/7);
				int column  =  (i2+som-2)%7;
				lblDayArray[column][row].setText(""+ i2);
			}
			
		/*Panel Day Elements End*/
		
		
		
	}
	
	public void refreshCalendar(){
		currDay = calendar.getCurrDay();
		currYear = calendar.getCurrYear();
		currMonth = calendar.getCurrMonth();
		String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int nod, som, i, j;
		GregorianCalendar cal = new GregorianCalendar(currYear, currMonth, 1);
		nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		som = cal.get(GregorianCalendar.DAY_OF_WEEK); 	
		
		lblYear.setText(""+ currYear);
		lblMonth.setText(months[currMonth]);
		
		
		System.out.println("Refresh");
		for(j = 0; j < 6; j++)
			for(int x = 0; x < 7; x++)
				lblDayArray[x][j].setText("");			
			
		for (int i2 = 1; i2 <= nod; i2++)
	        {
				int row = new Integer((i2+som-2)/7);
				int column  =  (i2+som-2)%7;
				lblDayArray[column][row].setText(""+ i2);
			}
		
		System.out.println("Today is: " + (monthToday+1) + "/" + dayToday + "/" + yearToday);
	}

	public int getCurrDay() {
		return currDay;
	}

	public void setCurrDay(int currDay) {
		this.currDay = currDay;
	}

	public int getCurrYear() {
		return currYear;
	}

	public void setCurrYear(int currYear) {
		this.currYear = currYear;
	}

	public int getCurrMonth() {
		return currMonth;
	}

	public void setCurrMonth(int currMonth) {
		this.currMonth = currMonth;
	}

	public CalendarClass getCalendar() {
		return calendar;
	}

	public void setCalendar(CalendarClass calendar) {
		this.calendar = calendar;
	}

	public int getDayFocused() {
		return dayFocused;
	}

	public void setDayFocused(int dayFocused) {
		this.dayFocused = dayFocused;
	}

	public String getMonthFocused() {
		return monthFocused;
	}

	public void setMonthFocused(String monthFocused) {
		this.monthFocused = monthFocused;
	}

	public int getYearFocused() {
		return yearFocused;
	}

	public void setYearFocused(int yearFocused) {
		this.yearFocused = yearFocused;
	}
	
}

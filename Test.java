// Group project for Bob Japundza, Perry Cameron, Dante Gearring

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

// class that is used to test calendar controls
public class Test extends JFrame implements ItemListener {
	static JPanel calendarContainer;
	private static final int GRAY = 1;
	static int yearSelected = 2018;  // this will set the year for the calendar
	static int monthSelected = 0;  // this will be the month of interest
	static int viewSelected = 0;  // this will be the monthy view your calendar is on
    private static final int BORDER = 2;
    private static final int NOBORDER = 0;
    private ForwardButtonHandler fbHandler;
    private ReverseButtonHandler rbHandler;
    
	// constructor
	public Test () {
		fbHandler = new ForwardButtonHandler();  // forward button
		rbHandler = new ReverseButtonHandler();
		
		calendarContainer = new JPanel();
		SidePanel sidePanel = new SidePanel();
		setTitle("Test Calendar Object");
        calendarContainer.setLayout(new BorderLayout());
        writeCalendar();
        setLayout(new BorderLayout());
		sidePanel.setPreferredSize(new Dimension(250,800));
		sidePanel.setVisible(true);
        calendarContainer.setPreferredSize(new Dimension(800,800));
        
        add(sidePanel, BorderLayout.LINE_START);
        add(calendarContainer, BorderLayout.CENTER);
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// item listeners
		SidePanel.oneMonthRadioButton.addItemListener(this);
		SidePanel.threeMonthsRadioButton.addItemListener(this);
		SidePanel.twelveMonthsRadioButton.addItemListener(this);
		SidePanel.monthListComboBox.addItemListener(this);
		
		// action listeners
		SidePanel.forward.addActionListener(fbHandler);
		SidePanel.reverse.addActionListener(rbHandler);
	}

	// main entry point
	public static void main(String[] args) {
		Test thisTest = new Test();
	}

	// method to set up three calendar view
	public static void threeCalendarView() {
		calendarContainer.setLayout(new GridLayout(2,2));
		for(int i = 0; i < 3; i++) {
			if(monthSelected + i == 12) {
				calendarContainer.add(new CalendarPanel(0,BORDER, new GregorianCalendar(Test.yearSelected)));	
			} else if(monthSelected + i == 13) {
				calendarContainer.add(new CalendarPanel(1,BORDER, new GregorianCalendar(Test.yearSelected)));	
			} else {
				calendarContainer.add(new CalendarPanel(monthSelected + i,BORDER, new GregorianCalendar(Test.yearSelected)));
			}
		}
		calendarContainer.add(new DayPanel("",0,GRAY));
	}
	
	// method to set up single calendar view
	public static void oneCalendarView() {
		calendarContainer.setLayout(new BorderLayout());
		calendarContainer.add(new CalendarPanel(monthSelected, NOBORDER, new GregorianCalendar(Test.yearSelected)), BorderLayout.CENTER);
	}
	
	// method to set up full year view
	public static void twelveCalendarView() {
		calendarContainer.setLayout(new GridLayout(4,3));
		for(int i = 0;i < 12; i++) {  
		calendarContainer.add(new CalendarPanel(i,BORDER, new GregorianCalendar(Test.yearSelected)));
		}
	}
	
	// does the work of displaying a calendar view
	public static void writeCalendar() {
		calendarContainer.removeAll();
		switch(viewSelected) {
		case 0:
			oneCalendarView();
			break;
		case 1:
			threeCalendarView();
			break;
		case 2:
			twelveCalendarView();
			break;
		}
		calendarContainer.updateUI();
		System.out.println("Updating UI");  //temp
	}
	
	// handles selections
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(SidePanel.oneMonthRadioButton.isSelected()) {
			viewSelected = 0;
		}
		if(SidePanel.threeMonthsRadioButton.isSelected()) {
			viewSelected = 1;
		}
		if(SidePanel.twelveMonthsRadioButton.isSelected()) {
			viewSelected = 2;
		} 
		selectMonth();
		writeCalendar();
	}

	// handles month selection
	public static void selectMonth() {
		for(int i = 0; i < SidePanel.monthList.length ; i++) {
			if(SidePanel.monthList[i].equals(SidePanel.monthListComboBox.getSelectedItem())) {
				monthSelected = i;
				System.out.println("Changed Monthyly selection to " + monthSelected); //temp
			}
		}
	}
}

// forward button handler
class ForwardButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Test.yearSelected++;
		SidePanel.yearDisplay.setText("" + Test.yearSelected);
		Test.writeCalendar();
		System.out.println("Forward one year");  //temp
	}
}

// back button handler
class ReverseButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Test.yearSelected--;
		SidePanel.yearDisplay.setText("" + Test.yearSelected);
		Test.writeCalendar();
		System.out.println("Reverse one year");  //temp
	}
}

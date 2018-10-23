import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
    
	
	public Test () {
		fbHandler = new ForwardButtonHandler();  // forward button
		rbHandler = new ReverseButtonHandler();
		
		calendarContainer = new JPanel();
		SidePanel sidePanel = new SidePanel();
		setTitle("Test Calendar Object");
        calendarContainer.setLayout(new BorderLayout());
        writeCalendar();
        setLayout(new BorderLayout());
		sidePanel.setPreferredSize(new Dimension(200,800));
		sidePanel.setVisible(true);
        calendarContainer.setPreferredSize(new Dimension(800,800));
        
        
        add(sidePanel, BorderLayout.LINE_START);
        add(calendarContainer, BorderLayout.CENTER);
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		SidePanel.oneMonthRadioButton.addItemListener(this);
		SidePanel.threeMonthsRadioButton.addItemListener(this);
		SidePanel.twelveMonthsRadioButton.addItemListener(this);
		SidePanel.forward.addActionListener(fbHandler);
		SidePanel.reverse.addActionListener(rbHandler);
		SidePanel.monthListComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
            System.out.println(SidePanel.monthListComboBox.getSelectedItem());
			}
		});
	}

	public static void main(String[] args) {
		Test thisTest = new Test();
	}

	public static void threeCalendarView() {
		calendarContainer.setLayout(new GridLayout(2,2));
		for(int i = 0; i < 3; i++) {		
		calendarContainer.add(new CalendarPanel(monthSelected + i,BORDER, new GregorianCalendar(Test.yearSelected)));
		}
		calendarContainer.add(new DayPanel("",0,GRAY));
		calendarContainer.updateUI();

	}
	
	public static void oneCalendarView() {
		calendarContainer.setLayout(new BorderLayout());
		calendarContainer.add(new CalendarPanel(monthSelected, NOBORDER, new GregorianCalendar(Test.yearSelected)), BorderLayout.CENTER);
		calendarContainer.updateUI();
	}
	
	public static void twelveCalendarView() {
		calendarContainer.setLayout(new GridLayout(4,3));
		for(int i = 0;i < 12; i++) {  
		calendarContainer.add(new CalendarPanel(i,BORDER, new GregorianCalendar(Test.yearSelected)));
		}
		calendarContainer.updateUI();
	}
	
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
		
	}
	
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
		writeCalendar();
	}
}

class ForwardButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Test.yearSelected++;
        SidePanel.yearDisplay.setText("" + Test.yearSelected);
        Test.writeCalendar();
	}
}

class ReverseButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Test.yearSelected--;
		SidePanel.yearDisplay.setText("" + Test.yearSelected);
		Test.writeCalendar();
	}
}

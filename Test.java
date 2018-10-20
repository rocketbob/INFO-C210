import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame implements ItemListener {
	JPanel calendarContainer;
	private static final int GRAY = 1;
	int yearSelected = 2018;  // this will set the year for the calendar
    GregorianCalendar gCalendar = new GregorianCalendar(yearSelected);
    private static final int BORDER = 2;
    private static final int NOBORDER = 0;
    
    
	
	public Test () {
		calendarContainer = new JPanel();
		SidePanel sidePanel = new SidePanel();
		setTitle("Test Calendar Object");
        calendarContainer.setLayout(new BorderLayout());
        calendarContainer.add(new CalendarPanel(gCalendar.currentMonth-1, NOBORDER, gCalendar), BorderLayout.CENTER);
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
	}

	public static void main(String[] args) {
		Test thisTest = new Test();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		calendarContainer.removeAll();
		if(SidePanel.oneMonthRadioButton.isSelected()) {
			calendarContainer.setLayout(new BorderLayout());
			calendarContainer.add(new CalendarPanel(gCalendar.currentMonth-1, NOBORDER, gCalendar), BorderLayout.CENTER);
			calendarContainer.updateUI();
		}
		if(SidePanel.threeMonthsRadioButton.isSelected()) {
			//calendarContainer.removeAll();
			calendarContainer.setLayout(new GridLayout(2,2));
			for(int i = 0; i < 3; i++) {
			calendarContainer.add(new CalendarPanel(i,BORDER, gCalendar));
			}
			calendarContainer.add(new DayPanel("",0,GRAY));
			calendarContainer.updateUI();
		}
		if(SidePanel.twelveMonthsRadioButton.isSelected()) {
			calendarContainer.setLayout(new GridLayout(4,3));
			for(int i = 0;i < 12; i++) {  
			calendarContainer.add(new CalendarPanel(i,BORDER, gCalendar));
			}
			calendarContainer.updateUI();
		}
		
	}
}

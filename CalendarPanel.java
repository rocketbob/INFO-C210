import java.awt.GridLayout;

import javax.swing.JPanel;

public class CalendarPanel extends JPanel {
    private JPanel calendarPanel;
    private String[] daysOfWeek = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    
	public CalendarPanel (int offset, int numDays) {
		setLayout(new GridLayout(6,7));
		for(int i=0;i<7;i++) {         // creates a panel for day heading
		add(new DayPanel(daysOfWeek[i]));
		}
		for(int i=0;i<offset;i++) {    // creates blank panels for spacers
		add(new DayPanel(""));
		}
		for(int i=1;i<numDays+1;i++) {  // creates a panel for each day
		add(new DayPanel("" + i));
		}
	}
}


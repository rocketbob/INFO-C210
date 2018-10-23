import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarPanel extends JPanel {
	private String[] daysOfWeek = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	// private String[] monthsOfYear = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	int tailSet;
	private static final int GRAY = 1;
	private static final int LIGHTGRAY = 0;
	private static final int YELLOW = 2;

	// problem with September and December when offset is 6 it dosen't work?
	public CalendarPanel (int month, int border, GregorianCalendar gCalendar) {
		JPanel tileContainer = new JPanel();
		JPanel headingPanel = new JPanel();
		JLabel monthLabel = new JLabel(SidePanel.monthList[month]);
		monthLabel.setForeground(Color.WHITE);
		monthLabel.setHorizontalAlignment(JLabel.CENTER);
		headingPanel.setBackground(Color.GRAY);
		headingPanel.add(monthLabel);
		this.tailSet = 42 - (gCalendar.monthNumDays[month] + gCalendar.monthOffsets[month]); // figue up number of trailing tiles needed
		tileContainer.setLayout(new GridLayout(7,7));
		tileContainer.setBackground(Color.GRAY);
		
		if (border > 0) {
			tileContainer.setBorder(BorderFactory.createLineBorder(Color.GRAY, border));
		}
		setLayout(new BorderLayout());
		for(int i=0;i<7;i++) {         // creates panels for day headings
			tileContainer.add(new DayPanel(daysOfWeek[i],1,LIGHTGRAY));
		}
		for(int i=0;i<gCalendar.monthOffsets[month];i++) {    // creates blank panels for spacers
			tileContainer.add(new DayPanel("",1,LIGHTGRAY));
		}
		for(int i=1;i<gCalendar.monthNumDays[month]+1;i++) {  // creates a panel for each day
			if (gCalendar.currentDay == i && gCalendar.currentMonth == month+1 && gCalendar.currentYear == gCalendar.yearSelected) { 
			tileContainer.add(new DayPanel("" + i,1,YELLOW));	
			} else {
			tileContainer.add(new DayPanel("" + i,1,LIGHTGRAY));
			}
			
		}
		for(int i = 0; i < tailSet; i++) {  // creates panels for any spaces left at the end
			tileContainer.add(new DayPanel("",0,GRAY));
		}
		add(headingPanel, BorderLayout.PAGE_START);
		add(tileContainer, BorderLayout.CENTER);
	}
}


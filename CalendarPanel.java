import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarPanel extends JPanel {
	private String[] daysOfWeek = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	private String[] monthsOfYear = {"January","February","March","April","May","June","July","Auguest","September","October","November","December"};
	int[] monthOffsets = {1,4,4,0,2,5,0,3,6,1,4,6};
	int[] monthNumDays = {31,28,31,30,31,30,31,31,30,31,30,31};
	int tailSet;
	private static final int GRAY = 1;
	private static final int LIGHTGRAY = 0;

	// problem with September and December when offset is 6 it dosen't work?
	public CalendarPanel (int month, int border) {
		JPanel tileContainer = new JPanel();
		JPanel headingPanel = new JPanel();
		JLabel monthLabel = new JLabel(monthsOfYear[month]);
		monthLabel.setForeground(Color.WHITE);
		monthLabel.setHorizontalAlignment(JLabel.CENTER);
		headingPanel.setBackground(Color.GRAY);
		headingPanel.add(monthLabel);
		this.tailSet = 42 - (monthNumDays[month] + monthOffsets[month]); // figue up number of trailing tiles needed
		tileContainer.setLayout(new GridLayout(7,7));
		tileContainer.setBackground(Color.GRAY);
		 System.out.println(monthsOfYear[month] + " -> " + monthNumDays[month] + "+" + monthOffsets[month] + "=" + tailSet + " ");

		if (border > 0) {
			tileContainer.setBorder(BorderFactory.createLineBorder(Color.GRAY, border));
		}
		setLayout(new BorderLayout());
		for(int i=0;i<7;i++) {         // creates a panel for day heading
			tileContainer.add(new DayPanel(daysOfWeek[i],1,LIGHTGRAY));
		}
		for(int i=0;i<monthOffsets[month];i++) {    // creates blank panels for spacers
			tileContainer.add(new DayPanel("",1,LIGHTGRAY));
		}
		for(int i=1;i<monthNumDays[month]+1;i++) {  // creates a panel for each day
			tileContainer.add(new DayPanel("" + i,1,LIGHTGRAY));
		}
		for(int i = 0; i < tailSet; i++) {  // creates panels for any spaces left
			tileContainer.add(new DayPanel("",0,GRAY));
		}
		add(headingPanel, BorderLayout.PAGE_START);
		add(tileContainer, BorderLayout.CENTER);
	}
}


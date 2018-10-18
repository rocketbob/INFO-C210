import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarPanel extends JPanel {
	private String[] daysOfWeek = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	private String[] monthsOfYear = {"January","February","March","April","May","June","July","Auguest","September","October","November","December"};

	int tailSet;

	public CalendarPanel (int offset, int numDays, int month, int border) {
		JPanel tileContainer = new JPanel();
		JLabel monthLabel = new JLabel(monthsOfYear[month]);
		monthLabel.setHorizontalAlignment(JLabel.CENTER);
		this.tailSet = 35 - (numDays + offset); // figue up number of trailing tiles needed
		tileContainer.setLayout(new GridLayout(6,7));
		// test // System.out.print(tailSet);

		if (border > 0) {
			tileContainer.setBorder(BorderFactory.createLineBorder(Color.RED, border));
		}
		setLayout(new BorderLayout());
		for(int i=0;i<7;i++) {         // creates a panel for day heading
			tileContainer.add(new DayPanel(daysOfWeek[i]));
		}
		for(int i=0;i<offset;i++) {    // creates blank panels for spacers
			tileContainer.add(new DayPanel(""));
		}
		for(int i=1;i<numDays+1;i++) {  // creates a panel for each day
			tileContainer.add(new DayPanel("" + i));
		}
		for(int i = 0; i < tailSet; i++) {  // creates panels for any spaces left
			tileContainer.add(new DayPanel(""));
		}
		add(monthLabel, BorderLayout.PAGE_START);
		add(tileContainer, BorderLayout.CENTER);
	}
}


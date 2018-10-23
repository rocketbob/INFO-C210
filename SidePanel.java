import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SidePanel extends JPanel {
	static JRadioButton oneMonthRadioButton;
	static JRadioButton threeMonthsRadioButton;
	static JRadioButton twelveMonthsRadioButton;
	JLabel monthSelect;
	JPanel yearPanel;
	JPanel radioPanel;
	JPanel sideGrid; // this is the main grid to hold and organize other panels in sidePanel
	static JLabel yearDisplay;
	static JComboBox<String> monthListComboBox;
	String[] monthList;
	static JButton forward;
	static JButton reverse;
	
	ButtonGroup radioButtonGroup;
	
	public SidePanel() {
		
		radioButtonGroup = new ButtonGroup();
		oneMonthRadioButton = new JRadioButton("1 Month");
		threeMonthsRadioButton = new JRadioButton("3 Months");
		twelveMonthsRadioButton = new JRadioButton("12 Months");
		forward = new JButton(">");
		reverse = new JButton("<");
		yearDisplay = new JLabel("2018", SwingConstants.CENTER); // start with default year
		monthSelect = new JLabel("Calendar View");
		yearPanel = new JPanel();
		radioPanel = new JPanel();
		sideGrid = new JPanel();
		monthList = new String[] {"January", "February", "March", "April", "May", "June", "July", "August","September","October", "November","December"};
		monthListComboBox = new JComboBox<String>(monthList);
		
		sideGrid.setLayout(new BorderLayout()); // main container panel inside side panel
		
		yearPanel.setLayout(new GridLayout(1,3));  // container panel for year select components
		yearPanel.setBorder(new EmptyBorder(20, 0, 20, 5));
		yearPanel.add(reverse);
		yearPanel.add(yearDisplay);
		yearPanel.add(forward);
		
		radioPanel.setLayout(new GridLayout(4,1));  // container panel for radio button group of components
		radioPanel.setBorder(new EmptyBorder(0, 0, 20, 0));
		radioButtonGroup.add(oneMonthRadioButton);
		radioButtonGroup.add(threeMonthsRadioButton);
		radioButtonGroup.add(twelveMonthsRadioButton);
		radioPanel.add(monthSelect);
		radioPanel.add(oneMonthRadioButton);
		radioPanel.add(threeMonthsRadioButton);
		radioPanel.add(twelveMonthsRadioButton);
		
		sideGrid.add(yearPanel, BorderLayout.PAGE_START);
		sideGrid.add(radioPanel, BorderLayout.CENTER);
		sideGrid.add(monthListComboBox, BorderLayout.PAGE_END);
		
		add(sideGrid);
	}
	
	
}

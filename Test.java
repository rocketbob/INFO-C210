import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame implements ItemListener {
	JPanel calendarContainer;

	int offset = 5;  // determines where days start on calendar
	int numDays = 28;  // number of days in a month
	private static final int GRAY = 1;
	public Test () {
		calendarContainer = new JPanel();
		SidePanel sidePanel = new SidePanel();
		setTitle("Test Calendar Object");
        calendarContainer.setLayout(new BorderLayout());
        calendarContainer.add(new CalendarPanel(1, 0), BorderLayout.CENTER);
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
			calendarContainer.add(new CalendarPanel(8, 0), BorderLayout.CENTER);
			calendarContainer.updateUI();
		}
		if(SidePanel.threeMonthsRadioButton.isSelected()) {
			//calendarContainer.removeAll();
			calendarContainer.setLayout(new GridLayout(2,2));
			for(int i = 0; i < 3; i++) {
			calendarContainer.add(new CalendarPanel(i, 2));
			}
			calendarContainer.add(new DayPanel("",0,GRAY));
			calendarContainer.updateUI();
		}
		if(SidePanel.twelveMonthsRadioButton.isSelected()) {
			calendarContainer.setLayout(new GridLayout(4,3));
			for(int i = 0;i < 12; i++) {  
			calendarContainer.add(new CalendarPanel(i, 2));
			}
			calendarContainer.updateUI();
		}
		
	}
}

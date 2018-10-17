import javax.swing.JFrame;

public class Test extends JFrame {
	int offset = 3;  // determines where days start on calendar
	int numDays = 30;  // number of days in a month

	public Test () {
		CalendarPanel calendarPanel = new CalendarPanel(offset, numDays);
		setTitle("Test Calendar Object");
		add(calendarPanel);
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Test thisTest = new Test();
	}
}

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DayPanel extends JPanel {

	public DayPanel(String string, int border, int color) {
		JLabel day = new JLabel(string);
		if (border > 0) { // adds boarder if told
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, border));
		}
		if (color == 1) {  // normal color for tiles
			this.setBackground(Color.GRAY);
		}
		if (color == 2) {  // color for current day
			this.setBackground(Color.YELLOW);
		}
		this.add(day);
	}
}

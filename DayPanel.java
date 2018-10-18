import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DayPanel extends JPanel {

	public DayPanel(String string, int border, int color) {
		JLabel day = new JLabel(string);
		if (border > 0) {
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, border));
		}
		if (color == 1) {
			this.setBackground(Color.GRAY);
		}
		this.add(day);
	}
}

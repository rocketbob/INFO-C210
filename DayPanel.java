import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DayPanel extends JPanel {

	public DayPanel(String string, int border, Color color,Color color2) {
		JLabel day = new JLabel(string);
		if (border > 0) { // adds boarder if told
		this.setBorder(BorderFactory.createLineBorder(color2, border));
		}
		this.setBackground(color);
		this.add(day);
	}
}

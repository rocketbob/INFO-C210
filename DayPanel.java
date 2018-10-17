import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DayPanel extends JPanel {

	public DayPanel(String string) {
		JLabel day = new JLabel(string);
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
		this.add(day);
	}
}

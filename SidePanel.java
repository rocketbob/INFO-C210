import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SidePanel extends JPanel {
	static JRadioButton oneMonthRadioButton;
	static JRadioButton threeMonthsRadioButton;
	static JRadioButton twelveMonthsRadioButton;
	
	ButtonGroup radioButtonGroup;
	
	public SidePanel() {
		radioButtonGroup = new ButtonGroup();
		oneMonthRadioButton = new JRadioButton("1");
		threeMonthsRadioButton = new JRadioButton("3");
		twelveMonthsRadioButton = new JRadioButton("12");	
		radioButtonGroup.add(oneMonthRadioButton);
		radioButtonGroup.add(threeMonthsRadioButton);
		radioButtonGroup.add(twelveMonthsRadioButton);
		// setBackground(Color.BLUE);
		add(oneMonthRadioButton);
		add(threeMonthsRadioButton);
		add(twelveMonthsRadioButton);
	}
	
	
}

import java.awt.Color;

public class Theme {
	
	// new Color lightRed = Color(255, 0, 255);
	
	
	
	private Color[] textColor = {
			Color.BLACK,       // 1
			Color.WHITE,       // 2
			Color.WHITE,       // 3
			Color.WHITE,       // 4
			Color.WHITE,       // 5
			Color.YELLOW,       // 6
			Color.WHITE,       // 7
			Color.RED,       // 8
			Color.WHITE,       // 9
			Color.BLACK,       // 10
			Color.BLUE.darker(),       // 11
			Color.PINK};      // 12
	
	private Color[] backGroundColor = {  // header
			Color.WHITE.darker(),       // 1
			Color.blue.darker(),      // 2
			Color.YELLOW.darker(),    // 3
			Color.BLACK.darker(),     // 4
			Color.lightGray.darker(), // 5
			Color.cyan.darker(),      // 6
			Color.magenta.darker(),   // 7
			Color.DARK_GRAY.darker(), // 8
			Color.BLUE,      // 9
			Color.orange.darker(),    // 10
			Color.pink.darker(),      // 11
			Color.GREEN.darker()};    // 12
	
	private Color[] panelColor = {
			Color.WHITE,       			// 1
			Color.blue,      			// 2
			Color.YELLOW,   			// 3
			Color.BLACK,    			// 4
			Color.GRAY, // 5
			Color.cyan,      			// 6
			Color.magenta,   			// 7
			Color.DARK_GRAY, 			// 8
			Color.WHITE,     			// 9
			Color.orange,    			// 10
			Color.pink,      			// 11
			Color.GREEN};  				// 12
	int month;
	
	public Color getTextColor() {
		return textColor[month];
	}

	public Color getBackGroundColor() {
		return backGroundColor[month];
	}

	public Color getPanelColor() {
		return panelColor[month];
	}


	
	public Theme(int month) {
		super();
		this.month = month;
		// TODO Auto-generated constructor stub
	}

}

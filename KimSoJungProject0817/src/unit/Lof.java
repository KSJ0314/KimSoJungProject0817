package unit;

import javax.swing.JLabel;

public class Lof extends JLabel {

	public int y;
	public int xStart;
	public int yStart;
	public String tag = "lof";

	public Lof(int xStart, int yStart, int y) {
		this.y = y;
		this.xStart = xStart;
		this.yStart = yStart;
		setBounds(xStart, yStart, 25, y);
		setOpaque(true);
	}

}

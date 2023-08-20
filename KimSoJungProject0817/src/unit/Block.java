package unit;

import javax.swing.JLabel;

public class Block extends JLabel {

	public int x;
	public int xStart;
	public int yStart;
	public String tag = "block";

	public Block(int xStart, int yStart, int x) {
		this.x = x;
		this.xStart = xStart;
		this.yStart = yStart;
		setBounds(xStart, yStart, x, 10);
		setOpaque(false);
	}

}

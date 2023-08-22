package unit;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Block extends JLabel {

	public int x;
	public int xStart;
	public int yStart;

	public Block(int xStart, int yStart, int x) {
		this.x = x;
		this.xStart = xStart;
		this.yStart = yStart;
		setBounds(xStart, yStart, x, 10);
		setOpaque(false);
	}

}



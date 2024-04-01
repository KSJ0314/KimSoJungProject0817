package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public class Exp extends JLabel {
	
	public ImageIcon background = new ImageIcon(MyFrame.class.getResource("../image/exp.png"));	// ¿ÃπÃ¡ˆ
	public int x = 0;

	public Exp() {
		setBounds(0,532,x, 8);
		setIcon(background);
		setOpaque(false);
	}
	
	public void boundsChange() {
		setBounds(0,532,x, 8);
	}
	
}

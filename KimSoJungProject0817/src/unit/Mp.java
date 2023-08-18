package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public class Mp extends JLabel {
	
	public ImageIcon background = new ImageIcon(MyFrame.class.getResource("../image/mp.png"));	// ¿ÃπÃ¡ˆ
	public int x = 141;

	public Mp() {
		setBounds(307,508,x, 13);
		setIcon(background);
		setOpaque(false);
	}
	
	public void boundsChange() {
		setBounds(307,508,x, 13);
	}
	
}

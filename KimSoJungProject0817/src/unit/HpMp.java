package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public class HpMp extends JLabel {
	
	public ImageIcon background = new ImageIcon(MyFrame.class.getResource("../image/hpmp.png"));	// ¿ÃπÃ¡ˆ

	public HpMp() {
		setBounds(281,464,174, 70);
		setIcon(background);
		setOpaque(false);
	}
	
}

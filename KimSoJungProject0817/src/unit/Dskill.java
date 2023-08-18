package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public class Dskill extends JLabel  {
	
	public ImageIcon background = new ImageIcon(MyFrame.class.getResource("../image/±√.png"));	// ¿ÃπÃ¡ˆ
	public ImageIcon background2 = new ImageIcon(MyFrame.class.getResource("../image/±√disable.png"));	// ¿ÃπÃ¡ˆ
	public boolean able;

	public Dskill() {
		setBounds(686,461,32, 32);
		setIcon(background2);
		setOpaque(false);
	}
	
	public void iconChange() {
		if (able) {
			setIcon(background);
		} else {
			setIcon(background2);
		}
	}
	
}

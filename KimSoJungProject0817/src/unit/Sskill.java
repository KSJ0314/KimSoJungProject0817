package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public class Sskill extends JLabel  {
	
	public ImageIcon background = new ImageIcon(MyFrame.class.getResource("../image/스윙.png"));	// 이미지
	public ImageIcon background2 = new ImageIcon(MyFrame.class.getResource("../image/스윙disable.png"));	// 이미지
	public boolean able;

	public Sskill() {
		setBounds(652,461,32, 32);
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

package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public class Askill extends JLabel  {
	
	public ImageIcon background = new ImageIcon(MyFrame.class.getResource("../image/������.png"));	// �̹���
	public ImageIcon background2 = new ImageIcon(MyFrame.class.getResource("../image/������disable.png"));	// �̹���
	public boolean able;

	public Askill() {
		setBounds(616,461,32, 32);
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

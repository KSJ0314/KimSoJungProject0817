package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public class Skill extends JLabel  {
	
	public ImageIcon background; // Ȱ��ȭ �̹���
	public ImageIcon background2; // ��Ȱ��ȭ �̹���
	public boolean able; // Ȱ��ȭ ���°�

	public Skill(String bg1, String bg2, int x) {
		background = new ImageIcon(MyFrame.class.getResource("../image/"+bg1));
		background2 = new ImageIcon(MyFrame.class.getResource("../image/"+bg2));
		
		setBounds(x,461,32,32);
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

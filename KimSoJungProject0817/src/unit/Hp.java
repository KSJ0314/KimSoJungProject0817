package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public class Hp extends JLabel {
	
	public ImageIcon background = new ImageIcon(MyFrame.class.getResource("../image/hp.png"));	// �̹���
	public int x = 141;

	public Hp() {
		setBounds(307,492,x, 13);
		setIcon(background);
		setOpaque(false);
	}
	
	public void hpCheck(int hp) {	// hp ���� �� �̹��� ���� ũ�⸦ ����
		setBounds(307,492,x*hp/10, 13);
	}
	
}

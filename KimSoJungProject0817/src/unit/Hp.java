package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public class Hp extends JLabel {
	
	public ImageIcon background = new ImageIcon(MyFrame.class.getResource("../image/hp.png"));	// 이미지
	public int x = 141;

	public Hp() {
		setBounds(307,492,x, 13);
		setIcon(background);
		setOpaque(false);
	}
	
	public void hpCheck(int hp) {	// hp 깎일 시 이미지 가로 크기를 변경
		setBounds(307,492,x*hp/10, 13);
	}
	
}

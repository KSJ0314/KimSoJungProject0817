package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public class Level extends JLabel {

	public ImageIcon[] background = new ImageIcon[5];
	public int lv = 1;

	public Level() {
		background[0] = new ImageIcon(MyFrame.class.getResource("../image/1.png")); // 이미지
		background[1] = new ImageIcon(MyFrame.class.getResource("../image/2.png")); // 이미지
		background[2] = new ImageIcon(MyFrame.class.getResource("../image/3.png")); // 이미지
		background[3] = new ImageIcon(MyFrame.class.getResource("../image/4.png")); // 이미지
		background[4] = new ImageIcon(MyFrame.class.getResource("../image/5.png")); // 이미지
		setBounds(318, 472, 12, 10);
		setIcon(background[0]);
		setOpaque(false);
	}

	public void levelUp() {
		switch (lv) {
			case 2:
				setIcon(background[1]);
				break;
			case 3:
				setIcon(background[2]);
				break;
			case 4:
				setIcon(background[3]);
				break;
			case 5:
				setIcon(background[4]);
				break;
		}
	}

}

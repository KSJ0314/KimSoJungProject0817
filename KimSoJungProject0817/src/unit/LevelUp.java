package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public class LevelUp extends JLabel {

	public ImageIcon[] background = new ImageIcon[23];
	public int IconNum = 0;
	public int xStart;
	public int yStart;
	public int x = 134;
	public int y = 72;

	public LevelUp(int xStart, int yStart) {
		background[0] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.0.png")); // 이미지
		background[1] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.1.png")); // 이미지
		background[2] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.2.png")); // 이미지
		background[3] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.3.png")); // 이미지
		background[4] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.4.png")); // 이미지
		background[5] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.5.png")); // 이미지
		background[6] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.6.png")); // 이미지
		background[7] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.7.png")); // 이미지
		background[8] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.8.png")); // 이미지
		background[9] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.9.png")); // 이미지
		background[10] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.10.png")); // 이미지
		background[11] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.11.png")); // 이미지
		background[12] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.12.png")); // 이미지
		background[13] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.13.png")); // 이미지
		background[14] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.14.png")); // 이미지
		background[15] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.15.png")); // 이미지
		background[16] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.16.png")); // 이미지
		background[17] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.17.png")); // 이미지
		background[18] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.18.png")); // 이미지
		background[19] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.19.png")); // 이미지
		background[20] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.20.png")); // 이미지
		background[21] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.21.png")); // 이미지
		background[22] = new ImageIcon(MyFrame.class.getResource("../image/LevelUp2.22.png")); // 이미지

		this.xStart = xStart;
		this.yStart = yStart;
		setBounds(xStart, yStart, x, y);
		setIcon(background[0]);
		setOpaque(false);
		setVisible(false);
	}

	public void BoundsChange() {
		switch (IconNum) {
		case 0:
			x = 134;
			y = 72;
			break;
		case 1:
			x = 201;
			y = 235;
			break;
		case 2:
			x = 218;
			y = 299;
			break;
		case 3:
			x = 246;
			y = 315;
			break;
		case 4:
			x = 296;
			y = 329;
			break;
		case 5:
			x = 246;
			y = 345;
			break;
		case 6:
			x = 296;
			y = 301;
			break;
		case 7:
			x = 218;
			y = 312;
			break;
		case 8:
			x = 246;
			y = 316;
			break;
		case 9:
			x = 296;
			y = 328;
			break;
		case 10:
			x = 246;
			y = 169;
			break;
		case 11:
			x = 296;
			y = 170;
			break;
		case 12:
			x = 178;
			y = 173;
			break;
		case 13:
			x = 178;
			y = 187;
			break;
		case 14:
			x = 178;
			y = 177;
			break;
		case 15:
			x = 178;
			y = 184;
			break;
		case 16:
			x = 178;
			y = 180;
			break;
		case 17:
			x = 178;
			y = 146;
			break;
		case 18:
			x = 178;
			y = 152;
			break;
		case 19:
			x = 163;
			y = 108;
			break;
		case 20:
			x = 161;
			y = 105;
			break;
		case 21:
			x = 159;
			y = 78;
			break;
		case 22:
			x = 137;
			y = 60;
			break;
		}
		setBounds(xStart, yStart, x, y);
	}

	public void IconChange() {
		if (IconNum == 22) {
			IconNum = -1;
		}
		IconNum++;
		setIcon(background[IconNum]);
	}

}

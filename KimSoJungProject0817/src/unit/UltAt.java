package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public class UltAt extends Attack {


	public UltAt() {
		hitIconNum = -1;
		atIconNum = -1;
		x = 73;
		y = 80;
		xStart = -x;
		yStart = -y;
		hitX = 5;
		hitY = 50;
		hitXStart = 0;
		hitYStart = 0;
		uthitXStart = new int[13];
		uthitYStart = new int[13];
		damage = 30;
		uthitJl = new JLabel[13];
		for (int i = 0; i < uthitJl.length; i++) {
			uthitJl[i] = new JLabel();
			uthitJl[i].setOpaque(false);
			uthitJl[i].setVisible(false);
		}
		atImage = new ImageIcon[18];
		atImageR = new ImageIcon[18];
		for (int i = 0; i < atImage.length; i++) {
			atImage[i]  = new ImageIcon(MyFrame.class.getResource("../attack_Image/ult_At"+i+".png"));
			atImageR[i]  = new ImageIcon(MyFrame.class.getResource("../attack_Image/ult_At_R"+i+".png"));
		}
		
		hitImage = new ImageIcon[10];
		hitImage[0] = new ImageIcon(MyFrame.class.getResource("../attack_Image/ult_Hit0.png"));
		hitImage[1] = new ImageIcon(MyFrame.class.getResource("../attack_Image/ult_Hit1.png"));
		hitImage[2] = new ImageIcon(MyFrame.class.getResource("../attack_Image/ult_Hit2.png"));
		hitImage[3] = new ImageIcon(MyFrame.class.getResource("../attack_Image/ult_Hit3.png"));
		hitImage[4] = new ImageIcon(MyFrame.class.getResource("../attack_Image/ult_Hit4.png"));
		hitImage[5] = new ImageIcon(MyFrame.class.getResource("../attack_Image/ult_Hit5.png"));
		hitImage[6] = new ImageIcon(MyFrame.class.getResource("../attack_Image/ult_Hit6.png"));
		hitImage[7] = new ImageIcon(MyFrame.class.getResource("../attack_Image/ult_Hit7.png"));
		hitImage[8] = new ImageIcon(MyFrame.class.getResource("../attack_Image/ult_Hit8.png"));
		hitImage[9] = new ImageIcon(MyFrame.class.getResource("../attack_Image/ult_Hit9.png"));
		setOpaque(false);
		setVisible(false);

		hitJl = new JLabel();

	}

	@Override
	public void setBounds(Player pl) {
		setVisible(true);
		hitIconNum = -1;
		atIconNum = -1;
		right = pl.right;
		if (right) {
			xStart = pl.x + pl.xSize;
			setIcon(atImageR[0]);
		} else {
			xStart = pl.x - x;
			setIcon(atImage[0]);
		}
		yStart = pl.floor - y - 5;
	}

	@Override
	public void BoundsChange() {
		setBounds(xStart, yStart, x, y);
	}

	@Override
	public void hitBounds(Mob mob) {
	}

	@Override
	public void uthitBounds(Mob[] mob) {
		for (int i = 0; i < mob.length; i++) {
			if (mob[i].isVisible()) {
				uthitXStart[i] = mob[i].xStart + (mob[i].x - hitX) / 2;
				uthitYStart[i] = mob[i].yStart + mob[i].y - hitY + 8;
				uthitJl[i].setVisible(true);
				uthitJl[i].setBounds(uthitXStart[i], uthitYStart[i], hitX, hitY);
			}
		}
	}

	@Override
	public void hitChange() {
		if (hitIconNum == hitImage.length - 1) {
			hitIconNum = -1;
		}
		hitIconNum++;
		switch (hitIconNum) {
		case 0:
			hitX = 5;
			hitY = 50;
			break;
		case 1:
			hitX = 38;
			hitY = 96;
			break;
		case 2:
			hitX = 76;
			hitY = 124;
			break;
		case 3:
			hitX = 82;
			hitY = 113;
			break;
		case 4:
			hitX = 76;
			hitY = 110;
			break;
		case 5:
			hitX = 73;
			hitY = 109;
			break;
		case 6:
			hitX = 70;
			hitY = 106;
			break;
		case 7:
			hitX = 69;
			hitY = 86;
			break;
		case 8:
			hitX = 67;
			hitY = 58;
			break;
		case 9:
			hitX = 43;
			hitY = 6;
			break;
		}
		for (int i = 0; i < uthitJl.length; i++) {
			uthitJl[i].setIcon(hitImage[hitIconNum]);
		}
	}

	@Override
	public void utChange(Player pl) {
		if (atIconNum == atImage.length - 1) {
			atIconNum = -1;
		}
		atIconNum++;
		switch (atIconNum) {
		case 0:
			x = 73;
			y = 80;
			break;
		case 1:
			x = 79;
			y = 158;
			break;
		case 2:
			x = 100;
			y = 169;
			break;
		case 3:
			x = 121;
			y = 173;
			break;
		case 4:
			x = 147;
			y = 180;
			break;
		case 5:
			x = 163;
			y = 231;
			break;
		case 6:
			x = 176;
			y = 244;
			break;
		case 7:
			x = 180;
			y = 240;
			break;
		case 8:
			x = 171;
			y = 236;
			break;
		case 9:
			x = 160;
			y = 232;
			break;
		case 10:
			x = 144;
			y = 232;
			break;
		case 11:
			x = 126;
			y = 235;
			break;
		case 12:
			x = 110;
			y = 236;
			break;
		case 13:
			x = 110;
			y = 259;
			break;
		case 14:
			x = 107;
			y = 263;
			break;
		case 15:
			x = 105;
			y = 367;
			break;
		case 16:
			x = 102;
			y = 421;
			break;
		case 17:
			x = 91;
			y = 408;
			break;
		}
		if (right) {
			setIcon(atImageR[atIconNum]);
		} else {
			setIcon(atImage[atIconNum]);
		}
		xStart = pl.x - (x - pl.xSize) / 2;
		yStart = pl.floor - y;
		BoundsChange();
	}

}

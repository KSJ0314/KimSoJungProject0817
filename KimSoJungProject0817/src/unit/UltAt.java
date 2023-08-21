package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public class UltAt extends Attack {

	public int hitIconNum = -1;
	public int atIconNum = -1;

	public UltAt() {
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
		uthitJl = new JLabel[13];
		damage = 30;
		atImage = new ImageIcon[18];
		atImageR = new ImageIcon[18];
		hitImage = new ImageIcon[10];
		for (JLabel i : uthitJl) {
			i = new JLabel();
			i.setOpaque(false);
			i.setVisible(false);
		}
		atImage[0] = new ImageIcon(MyFrame.class.getResource("../attack_Image/swing_At.gif"));
		atImageR[0] = new ImageIcon(MyFrame.class.getResource("../attack_Image/swing_At_R.gif"));
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
		right = pl.right;
		if (right) {
			xStart = pl.x + pl.xSize - 100;
			setIcon(atImageR[0]);
		} else {
			xStart = pl.x - x + 100;
			setIcon(atImage[0]);
		}
		yStart = pl.floor - y + 20;
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
			uthitXStart[i] = mob[i].xStart + (mob[i].x - hitX) / 2;
			uthitYStart[i] = mob[i].yStart + mob[i].y - hitY + 8;
			uthitJl[i].setVisible(true);
			uthitJl[i].setBounds(uthitXStart[i], uthitYStart[i], hitX, hitY);
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
		for (JLabel i : uthitJl) {
			setIcon(hitImage[hitIconNum]);
		}
	}

	@Override
	public void atChange() {
		if (atIconNum == atImage.length - 1) {
			atIconNum = -1;
		}
		atIconNum++;
		switch (atIconNum) {
		case 0:
			break;
		}
		if (right) {
			setIcon(atImageR[atIconNum]);
		} else {
			setIcon(atImage[atIconNum]);
		}
	}

}

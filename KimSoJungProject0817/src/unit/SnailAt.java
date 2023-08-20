package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public class SnailAt extends Attack {

	public SnailAt() {
		x = 32;
		y = 35;
		hitX = 76;
		hitY = 79;
		damage = 3;
		atImage = new ImageIcon[1];
		atImageR = new ImageIcon[1];
		atImage[0] = new ImageIcon(MyFrame.class.getResource("../attack_Image/snail_At.gif"));
		atImageR[0] = new ImageIcon(MyFrame.class.getResource("../attack_Image/snail_At_R.gif"));
		hitImage = new ImageIcon(MyFrame.class.getResource("../attack_Image/snail_Hit.gif"));
		hitImageR = new ImageIcon(MyFrame.class.getResource("../attack_Image/snail_Hit_R.gif"));
		setOpaque(false);
		setVisible(false);

		hitJl = new JLabel();
		hitJl.setOpaque(false);
		hitJl.setVisible(false);
	}

	@Override
	public void setBounds(Player pl) {
		setVisible(true);
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
		hitXStart = mob.xStart + (mob.x - hitX) / 2;
		hitYStart = mob.yStart + mob.y - hitY + 15;
		hitJl.setVisible(true);
		if (right) {
			hitJl.setIcon(hitImage);
		} else {
			hitJl.setIcon(hitImageR);
		}
		hitJl.setBounds(hitXStart, hitYStart, hitX, hitY);
	}

}

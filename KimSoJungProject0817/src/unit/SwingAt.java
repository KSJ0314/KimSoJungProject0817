package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public class SwingAt extends Attack {

	public SwingAt() {
		x = 150;
		y = 76;
		xStart = -x;
		yStart = -y;
		hitX = 76;
		hitY = 80;
		damage = 5;
		atImage = new ImageIcon[1];
		atImageR = new ImageIcon[1];
		hitImage = new ImageIcon[1];
		hitImageR = new ImageIcon[1];
		atImage[0] = new ImageIcon(MyFrame.class.getResource("../attack_Image/swing_At.gif"));
		atImageR[0] = new ImageIcon(MyFrame.class.getResource("../attack_Image/swing_At_R.gif"));
		hitImage[0] = new ImageIcon(MyFrame.class.getResource("../attack_Image/swing_Hit.gif"));
		hitImageR[0] = new ImageIcon(MyFrame.class.getResource("../attack_Image/swing_Hit_R.gif"));
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
		hitXStart = mob.xStart + (mob.x - hitX) / 2;
		hitYStart = mob.yStart + mob.y - hitY + 15;
		hitJl.setVisible(true);
		if (right) {
			hitJl.setIcon(hitImage[0]);
		} else {
			hitJl.setIcon(hitImageR[0]);
		}
		hitJl.setBounds(hitXStart, hitYStart, hitX, hitY);
	}

}

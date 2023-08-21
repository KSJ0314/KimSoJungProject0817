package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public class Mob_Slime extends Mob {

	public Mob_Slime(int xStart, int yStart, int range, int preStayCount) {
		prehp = 5;
		hp = 5;
		exp = 2;
		x = 70;
		y = 49;
		damage = 2;
		moveNum = 0;
		speed = 1;
		dieNum = 0;
		jen = 4;
		this.preStayCount = preStayCount;
		stayCount = preStayCount;
		this.xStart = xStart;
		this.yStart = yStart;
		this.prex = x;
		this.prey = y;
		this.prexStart = xStart;
		this.preyStart = yStart;
		this.minX = xStart - range;
		this.maxX = xStart + range;
		setBounds(xStart, yStart, x, y);

		move = new ImageIcon[7];
		moveR = new ImageIcon[7];
		dieImage = new ImageIcon[4];
		dieImageR = new ImageIcon[4];

		stand = new ImageIcon(MyFrame.class.getResource("../mob1_image/stand.gif")); // 기본이미지
		standR = new ImageIcon(MyFrame.class.getResource("../mob1_image/stand_R.gif")); // 기본이미지

		for (int i = 0; i < move.length; i++) {
			move[i] = new ImageIcon(MyFrame.class.getResource("../mob1_image/move" + i + ".png"));
			moveR[i] = new ImageIcon(MyFrame.class.getResource("../mob1_image/move" + i + "_R.png"));
		}

		hitImage = new ImageIcon(MyFrame.class.getResource("../mob1_image/hit0.png"));
		hitImageR = new ImageIcon(MyFrame.class.getResource("../mob1_image/hit0_R.png"));

		for (int i = 0; i < dieImage.length; i++) {
			dieImage[i] = new ImageIcon(MyFrame.class.getResource("../mob1_image/die" + i + ".png"));
			dieImageR[i] = new ImageIcon(MyFrame.class.getResource("../mob1_image/die" + i + "_R.png"));
		}

		if (preStayCount == -1) {
			setIcon(standR);
		} else {
			setIcon(stand);
		}
		setOpaque(false);

		jl = new JLabel();
		jl.setBounds(xStart, yStart - 5, x, 4);
		jl.setIcon(new ImageIcon(MyFrame.class.getResource("../image/hp.png")));
		j2 = new JLabel();
		j2.setBounds(xStart, yStart - 5, x, 4);
		j2.setIcon(new ImageIcon(MyFrame.class.getResource("../image/black.png")));
		setVisible(false);
		jl.setVisible(false);
		j2.setVisible(false);
	}

	@Override
	public void hpChange() {
		jl.setBounds(xStart, yStart - 5, x * hp / 5, 4);
		j2.setBounds(xStart, yStart - 5, x, 4);
	}

	@Override
	public void moveIcon() {
		int px = x;
		int py = y;
		switch (moveNum) {
		case 0:
			x = 70;
			y = 51;
			break;
		case 1:
			x = 62;
			y = 53;
			break;
		case 2:
			x = 54;
			y = 61;
			yStart -= 10;
			break;
		case 3:
			x = 63;
			y = 67;
			yStart -= 10;
			break;
		case 4:
			x = 63;
			y = 84;
			yStart += 5;
			break;
		case 5:
			x = 61;
			y = 71;
			yStart += 15;
			break;
		case 6:
			x = 60;
			y = 46;
			break;
		}
		if (right) {
			setIcon(moveR[moveNum]);
			xStart = xStart + px - x;
		} else {
			setIcon(move[moveNum]);
		}
		yStart = yStart + py - y;
		moveNum++;
		if (moveNum == move.length) {
			moveNum = 0;
		}
	}

	@Override
	public void BoundsChange() {
		setBounds(xStart, yStart, x, y);
		hpChange();
	}

	@Override
	public void dieIcon() {
		if (right) {
			setIcon(dieImageR[dieNum]);
		} else {
			setIcon(dieImage[dieNum]);
		}
	}

	@Override
	public void dieBounds() {
		int px = x;
		int py = y;
		switch (dieNum) {
		case 0:
			x = 61;
			y = 60;
			break;
		case 1:
			x = 56;
			y = 59;
			break;
		case 2:
			x = 49;
			y = 54;
			break;
		case 3:
			x = 31;
			y = 40;
			break;
		}
		xStart = xStart + (px - x) / 2;
		yStart = yStart + py - y;
		dieNum++;
		if (dieNum == dieImage.length) {
			dieNum = 0;
		}
		BoundsChange();
	}

}

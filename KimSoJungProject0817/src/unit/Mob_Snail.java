package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public class Mob_Snail extends Mob {

	public Mob_Snail(int xStart, int yStart, int range, int preStayCount) {
		prehp = 2;
		hp = 2;
		exp = 1;
		x = 37;
		y = 26;
		damage = 1;
		speed = 1;
		jen = 2;
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

		move = new ImageIcon[1];
		moveR = new ImageIcon[1];
		dieImage = new ImageIcon[8];
		dieImageR = new ImageIcon[8];

		stand = new ImageIcon(MyFrame.class.getResource("../mob0_image/stand.png")); // 기본이미지
		standR = new ImageIcon(MyFrame.class.getResource("../mob0_image/standR.png")); // 기본이미지
		move[0] = new ImageIcon(MyFrame.class.getResource("../mob0_image/move.gif")); // 이동 gif
		moveR[0] = new ImageIcon(MyFrame.class.getResource("../mob0_image/moveR.gif")); // 이동 gif
		hitImage = new ImageIcon(MyFrame.class.getResource("../mob0_image/hit.png"));
		hitImageR = new ImageIcon(MyFrame.class.getResource("../mob0_image/hitR.png"));

		dieImage[0] = new ImageIcon(MyFrame.class.getResource("../mob0_image/die1.png"));
		dieImageR[0] = new ImageIcon(MyFrame.class.getResource("../mob0_image/die1R.png"));
		dieImage[1] = new ImageIcon(MyFrame.class.getResource("../mob0_image/die2.png"));
		dieImageR[1] = new ImageIcon(MyFrame.class.getResource("../mob0_image/die2R.png"));
		dieImage[2] = new ImageIcon(MyFrame.class.getResource("../mob0_image/die3.png"));
		dieImageR[2] = new ImageIcon(MyFrame.class.getResource("../mob0_image/die3R.png"));
		dieImage[3] = new ImageIcon(MyFrame.class.getResource("../mob0_image/die4.png"));
		dieImageR[3] = new ImageIcon(MyFrame.class.getResource("../mob0_image/die4R.png"));
		dieImage[4] = new ImageIcon(MyFrame.class.getResource("../mob0_image/die5.png"));
		dieImageR[4] = new ImageIcon(MyFrame.class.getResource("../mob0_image/die5R.png"));
		dieImage[5] = new ImageIcon(MyFrame.class.getResource("../mob0_image/die6.png"));
		dieImageR[5] = new ImageIcon(MyFrame.class.getResource("../mob0_image/die6R.png"));
		dieImage[6] = new ImageIcon(MyFrame.class.getResource("../mob0_image/die7.png"));
		dieImageR[6] = new ImageIcon(MyFrame.class.getResource("../mob0_image/die7R.png"));
		dieImage[7] = new ImageIcon(MyFrame.class.getResource("../mob0_image/die8.png"));
		dieImageR[7] = new ImageIcon(MyFrame.class.getResource("../mob0_image/die8R.png"));

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
		
	}

	@Override
	public void hpChange() {
		jl.setBounds(xStart, yStart - 5, x * hp / 2, 4);
		j2.setBounds(xStart, yStart - 5, x, 4);
	}

	@Override
	public void moveIcon() {
		if (right) {
			setIcon(moveR[0]);
		} else {
			setIcon(move[0]);
		}
	}

	@Override
	public void BoundsChange() {
		setBounds(xStart, yStart, x, y);
		hpChange();
	}

	@Override
	public void dieIcon() {
		if (dieNum == dieImage.length - 1) {
			dieNum = -1;
		}
		dieNum++;
		if (right) {
			setIcon(dieImageR[dieNum]);
		} else {
			setIcon(dieImage[dieNum]);
		}
	}

	@Override
	public void dieBounds() {
		switch (dieNum) {
		case 0:
			x = 44;
			y = 31;
			xStart -= 3;
			yStart -= 5;
			break;
		case 1:
			x = 36;
			y = 24;
			xStart += 4;
			yStart += 7;
			break;
		case 2:
			x = 36;
			y = 24;
			break;
		case 3:
			x = 35;
			y = 23;
			yStart += 1;
			break;
		case 4:
			x = 35;
			y = 18;
			yStart += 5;
			break;
		case 5:
			x = 33;
			y = 14;
			xStart += 1;
			yStart += 4;
			break;
		case 6:
			x = 33;
			y = 10;
			yStart += 4;
			break;
		case 7:
			x = 33;
			y = 6;
			yStart += 4;
			break;
		}
		BoundsChange();
	}

}

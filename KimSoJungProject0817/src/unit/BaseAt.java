package unit;

import javax.swing.JLabel;

public class BaseAt extends Attack {

	public BaseAt() {
		x = 100;
		y = 50;
		xStart = -x;
		yStart = -y;
		damage = 1;
		setOpaque(false);
		hitJl = new JLabel();
	}

	@Override
	public void setBounds(Player pl) {
		xStart = pl.x - (x - pl.xSize) / 2;
		yStart = pl.floor - y;
		BoundsChange();
	}

	@Override
	public void BoundsChange() {
		setBounds(xStart, yStart, x, y);
	}

	@Override
	public void hitBounds(Mob mob) {
	}

}

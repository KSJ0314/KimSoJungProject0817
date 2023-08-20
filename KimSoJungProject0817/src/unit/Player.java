package unit;

import javax.swing.JLabel;

public class Player extends JLabel {
	
	public int x = 340;
	public int y = 370;
	public int xSize = 30;
	public int ySize = 50;
	public int floor = y+ySize;
	public int hp = 10;
	public int exp = 0;
	public int lv = 1;
	public boolean right;
	public int rightInt = -1;
	public boolean isJump;
	public boolean isLanding = true;
	public boolean isClimb;
	public boolean isHit;
	public boolean canMove = true;
	
	public Player() {
		setBounds(x, y, xSize, ySize);
		setOpaque(true);
	}

	public void BoundsChange() {
		setBounds(x, y, xSize, ySize);
		floor = y+ySize;
	}

}

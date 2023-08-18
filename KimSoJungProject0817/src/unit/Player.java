package unit;

import javax.swing.JLabel;

public class Player extends JLabel {
	
	public int x = 340;
	public int y = 364;
	public int hp = 10;
	public int exp = 0;
	public int lv = 1;
	public boolean right;
	
	public Player() {
		setBounds(x, y, 50, 50);
		setOpaque(true);
	}

}

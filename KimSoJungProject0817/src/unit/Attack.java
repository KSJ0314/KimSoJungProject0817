package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public abstract class Attack extends JLabel {

	public ImageIcon[] atImage;
	public ImageIcon[] atImageR;
	public ImageIcon[] hitImage;
	public ImageIcon[] hitImageR;
	public int x;
	public int y;
	public int xStart;
	public int yStart;
	public int hitX;
	public int hitY;
	public int hitXStart;
	public int hitYStart;
	public int[] uthitXStart;
	public int[] uthitYStart;
	public int damage;
	public JLabel hitJl;
	public JLabel[] uthitJl;
	public boolean hit;
	public boolean right;
	
	public abstract void setBounds(Player pl);
	public abstract void BoundsChange();
	public abstract void hitBounds(Mob mob);
	public void uthitBounds(Mob[] mob) {};
	public void hitChange() {};
	public void atChange() {};
	
}

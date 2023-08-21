package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public abstract class Mob extends JLabel {

	public ImageIcon stand;
	public ImageIcon standR;
	public ImageIcon[] move;
	public ImageIcon[] moveR;
	public ImageIcon hitImage;
	public ImageIcon hitImageR;
	public ImageIcon[] dieImage;
	public ImageIcon[] dieImageR;
	public int x;
	public int y;
	public int xStart;
	public int yStart;
	public int prex;
	public int prey;
	public int prexStart;
	public int preyStart;
	public int minX;
	public int maxX;
	public int hp;
	public int prehp;
	public int exp;
	public int damage;
	public JLabel jl;
	public JLabel j2;
	public boolean right;
	public int stayCount = 0;
	public int preStayCount;
	public boolean stay = false;
	public boolean hit;
	public int hittime = 0;
	public int moveNum = 0;
	public int dieNum = -1;
	public boolean isDie;
	public int speed;
	public boolean isMove;
	public int jen;
	public boolean startJen;
	
	public abstract void hpChange();
	
	public abstract void BoundsChange();
	
	public abstract void moveIcon();
	
	public abstract void dieIcon();
	
	public abstract void dieBounds();

}

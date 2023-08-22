package unit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import frame.MyFrame;

public class Player extends JLabel {

	public int x = 340;
	public int y = 360;
	public int xSize = 40;
//	public int xSize = 65;
	public int ySize = 60;
	public int floor = y + ySize;
	public int hp = 10;
	public int exp = 0;
	public int lv = 1;
	public boolean right;
	public boolean stand = true;
	public boolean attack;
	public boolean canAttack = true;
	public int rightInt = -1;
	public boolean isJump;
	public boolean isLanding = true;
	public boolean isClimb;
	public boolean isHit;
	public boolean iconChange;
	public int atAnimaNum = 0;

	public boolean canMove = true;
	public ImageIcon stand0 = new ImageIcon(MyFrame.class.getResource("../pl_image/stand0.gif"));
	public ImageIcon stand0_R = new ImageIcon(MyFrame.class.getResource("../pl_image/stand0_R.gif"));
	public ImageIcon stand1 = new ImageIcon(MyFrame.class.getResource("../pl_image/stand1.gif"));
	public ImageIcon stand1_R = new ImageIcon(MyFrame.class.getResource("../pl_image/stand1_R.gif"));
	public ImageIcon stand2 = new ImageIcon(MyFrame.class.getResource("../pl_image/stand2.gif"));
	public ImageIcon stand2_R = new ImageIcon(MyFrame.class.getResource("../pl_image/stand2_R.gif"));

	public ImageIcon swing0 = new ImageIcon(MyFrame.class.getResource("../pl_image/swing0.gif"));
	public ImageIcon swing0_R = new ImageIcon(MyFrame.class.getResource("../pl_image/swing0_R.gif"));
	public ImageIcon swing1 = new ImageIcon(MyFrame.class.getResource("../pl_image/swing1.gif"));
	public ImageIcon swing1_R = new ImageIcon(MyFrame.class.getResource("../pl_image/swing1_R.gif"));

	public ImageIcon swing2[] = new ImageIcon[3];
	public ImageIcon swing2_R[] = new ImageIcon[3];

	public ImageIcon walk0 = new ImageIcon(MyFrame.class.getResource("../pl_image/walk0.gif"));
	public ImageIcon walk0_R = new ImageIcon(MyFrame.class.getResource("../pl_image/walk0_R.gif"));
	public ImageIcon walk1 = new ImageIcon(MyFrame.class.getResource("../pl_image/walk1.gif"));
	public ImageIcon walk1_R = new ImageIcon(MyFrame.class.getResource("../pl_image/walk1_R.gif"));
	public ImageIcon walk2 = new ImageIcon(MyFrame.class.getResource("../pl_image/walk2.gif"));
	public ImageIcon walk2_R = new ImageIcon(MyFrame.class.getResource("../pl_image/walk2_R.gif"));

	public ImageIcon jump0 = new ImageIcon(MyFrame.class.getResource("../pl_image/jump0.png"));
	public ImageIcon jump0_R = new ImageIcon(MyFrame.class.getResource("../pl_image/jump0_R.png"));
	public ImageIcon jump1 = new ImageIcon(MyFrame.class.getResource("../pl_image/jump1.png"));
	public ImageIcon jump1_R = new ImageIcon(MyFrame.class.getResource("../pl_image/jump1_R.png"));
	public ImageIcon jump2 = new ImageIcon(MyFrame.class.getResource("../pl_image/jump2.png"));
	public ImageIcon jump2_R = new ImageIcon(MyFrame.class.getResource("../pl_image/jump2_R.png"));

	public ImageIcon lof0 = new ImageIcon(MyFrame.class.getResource("../pl_image/lof0.png"));
	public ImageIcon lof1 = new ImageIcon(MyFrame.class.getResource("../pl_image/lof1.png"));

	public Player() {
		setBounds(x, y, xSize, ySize);
		setOpaque(false);
		setIcon(stand0);

		swing2[0] = new ImageIcon(MyFrame.class.getResource("../pl_image/swing02.png"));
		swing2_R[0] = new ImageIcon(MyFrame.class.getResource("../pl_image/swing02_R.png"));
		swing2[1] = new ImageIcon(MyFrame.class.getResource("../pl_image/swing12.png"));
		swing2_R[1] = new ImageIcon(MyFrame.class.getResource("../pl_image/swing12_R.png"));
		swing2[2] = new ImageIcon(MyFrame.class.getResource("../pl_image/swing22.png"));
		swing2_R[2] = new ImageIcon(MyFrame.class.getResource("../pl_image/swing22_R.png"));
	}

	public void BoundsChange() {
		setBounds(x, y, xSize, ySize);
		floor = y + ySize;
	}

	public void iconCange() {
		if (attack) {
			if (right) {
				switch (lv) {
				case 1:
				case 2:
					setIcon(swing0_R);
					break;
				case 3:
				case 4:
					setIcon(swing1_R);
					break;
//				case 5:
//					setIcon(swing2_R);
//					break;
				}
			} else {
				switch (lv) {
				case 1:
				case 2:
					setIcon(swing0);
					break;
				case 3:
				case 4:
					setIcon(swing1);
					break;
//				case 5:
//					setIcon(swing2);
//					break;
				}
			}
		} else if (!isLanding && !isClimb) {
			if (right) {
				switch (lv) {
				case 1:
				case 2:
					setIcon(jump0_R);
					break;
				case 3:
				case 4:
					setIcon(jump1_R);
					break;
				case 5:
					setIcon(jump2_R);
					break;
				}
			} else {
				switch (lv) {
				case 1:
				case 2:
					setIcon(jump0);
					break;
				case 3:
				case 4:
					setIcon(jump1);
					break;
				case 5:
					setIcon(jump2);
					break;
				}
			}
		} else if (stand && !isClimb) {
			if (right) {
				switch (lv) {
				case 1:
				case 2:
					setIcon(stand0_R);
					break;
				case 3:
				case 4:
					setIcon(stand1_R);
					break;
				case 5:
					setIcon(stand2_R);
					break;
				}
			} else {
				switch (lv) {
				case 1:
				case 2:
					setIcon(stand0);
					break;
				case 3:
				case 4:
					setIcon(stand1);
					break;
				case 5:
					setIcon(stand2);
					break;
				}
			}
		} else if (!isClimb) {
			if (right) {
				switch (lv) {
				case 1:
				case 2:
					setIcon(walk0_R);
					break;
				case 3:
				case 4:
					setIcon(walk1_R);
					break;
				case 5:
					setIcon(walk2_R);
					break;
				}
			} else {
				switch (lv) {
				case 1:
				case 2:
					setIcon(walk0);
					break;
				case 3:
				case 4:
					setIcon(walk1);
					break;
				case 5:
					setIcon(walk2);
					break;
				}
			}
		}
	}

	public void atAni() {
		if (atAnimaNum == swing2.length) {
			atAnimaNum = 0;
		}
		switch (atAnimaNum) {
		case 0:
			xSize = 51;
			ySize = 70;
			y -= 20;
			if (right) {
				x-=17;
			} else {
				x+=30;
			}
			break;
		case 1:
			xSize = 36;
			ySize = 80;
			y -= 10;
			if (right) {
				x+=17;
			}
			break;
		case 2:
			xSize = 50;
			ySize = 90;
			y += 30;
			if (right) {
				x-=17;
			}
			System.out.println("hi");
			break;
		}
		if (right) {
			setIcon(swing2_R[atAnimaNum]);
		} else {
			setIcon(swing2[atAnimaNum]);
		}
		atAnimaNum++;

		BoundsChange();
	}
}

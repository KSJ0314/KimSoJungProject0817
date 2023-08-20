package main_;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import frame.MyFrame;
import unit.Attack;
import unit.Block;
import unit.Lof;
import unit.Mob;

public class Main {

	void visibleChange(JPanel jp1, JPanel jp2) {
		while (true) {
			try {
				Thread.sleep(100);
				if (!jp1.isVisible()) {
					jp2.setVisible(true);
					break;
				}
			} catch (Exception e) {
			}
		}
	}

	void mopCheck(MyFrame mf) {
		for (int i = 0; i < mf.mainPanel.mob.length; i++) {
			mf.mainPanel.mob[i].BoundsChange(); // ��ġ �缳��
			mf.mainPanel.mob[i].hpChange(); // hp �缳��

			if (mf.mainPanel.mob[i].hp <= 0) {
				if (!mf.mainPanel.mob[i].isDie) {
					mf.mainPanel.mob[i].isDie = true;
					mobDie(mf, mf.mainPanel.mob[i]);
				}
				continue;
			}

			if (mf.mainPanel.mob[i].hit) {
				if (mf.mainPanel.mob[i].hittime == 0) {
					mf.mainPanel.mob[i].hp--;
				}
				if (mf.mainPanel.mob[i].right) {
					mf.mainPanel.mob[i].setIcon(mf.mainPanel.mob[i].hitImageR);
				} else {
					mf.mainPanel.mob[i].setIcon(mf.mainPanel.mob[i].hitImage);
				}
				mf.mainPanel.mob[i].hittime++;
				if (mf.mainPanel.mob[i].hittime == 50) {
					mf.mainPanel.mob[i].hittime = 0;
					mf.mainPanel.mob[i].hit = false;
				}
				continue;
			} else if (mf.mainPanel.mob[i].stayCount == 0) {
				if (mf.mainPanel.mob[i].right) {
					mf.mainPanel.mob[i].xStart++;
				} else {
					mf.mainPanel.mob[i].xStart--;
				}
				mf.mainPanel.mob[i].moveIcon();
			}

			if (mf.mainPanel.mob[i].xStart < mf.mainPanel.mob[i].minX) {
				mf.mainPanel.mob[i].setIcon(mf.mainPanel.mob[i].stand);
				mf.mainPanel.mob[i].stayCount--;
			} else if (mf.mainPanel.mob[i].xStart > mf.mainPanel.mob[i].maxX) {
				mf.mainPanel.mob[i].setIcon(mf.mainPanel.mob[i].standR);
				mf.mainPanel.mob[i].stayCount++;
			}

			if (mf.mainPanel.mob[i].stayCount == -50) {
				mf.mainPanel.mob[i].stayCount = 0;
				mf.mainPanel.mob[i].right = true;
			} else if (mf.mainPanel.mob[i].stayCount == 50) {
				mf.mainPanel.mob[i].stayCount = 0;
				mf.mainPanel.mob[i].right = false;
			}

			if (mf.mainPanel.mob[i].xStart <= mf.mainPanel.attack[1].xStart + mf.mainPanel.attack[1].x
					&& mf.mainPanel.mob[i].xStart + mf.mainPanel.mob[i].x >= mf.mainPanel.attack[1].xStart
					&& mf.mainPanel.mob[i].yStart <= mf.mainPanel.attack[1].yStart + mf.mainPanel.attack[1].y
					&& mf.mainPanel.mob[i].yStart + mf.mainPanel.mob[i].y >= mf.mainPanel.attack[1].yStart) {
				mf.mainPanel.attack[1].hit = true;
				mf.mainPanel.mob[i].hit = true;
				mf.mainPanel.mob[i].hp -= mf.mainPanel.attack[1].damage;
				mobHit(mf.mainPanel.attack[1], mf.mainPanel.mob[i]);
			}

		}
	}

	void plCheck(MyFrame mf) {
		// ��ġ ����
		mf.mainPanel.pl.BoundsChange();

		// Hp ����
		mf.mainPanel.hp.hpCheck(mf.mainPanel.pl.hp);

		// exp ����
		switch (mf.mainPanel.pl.lv) {
		case 1:
			mf.mainPanel.exp.x = 720 * mf.mainPanel.pl.exp / 2;
			break;
		case 2:
			mf.mainPanel.exp.x = 720 * mf.mainPanel.pl.exp / 3;
			break;
		case 3:
			mf.mainPanel.exp.x = 720 * mf.mainPanel.pl.exp / 5;
			break;
		case 4:
			mf.mainPanel.exp.x = 720 * mf.mainPanel.pl.exp / 10;
			break;
		case 5:
			mf.mainPanel.exp.x = 720;
			break;
		}
		mf.mainPanel.exp.boundsChange();

		// skill ����
		mf.mainPanel.askill.iconChange();
		mf.mainPanel.sskill.iconChange();
		mf.mainPanel.dskill.iconChange();

		// �߷� ����
		int count = 0;
		for (Block i : mf.mainPanel.block) { // ������ ���� ���� ���� Ȯ��
			if (!mf.mainPanel.pl.isJump) {
				if (mf.mainPanel.pl.x + mf.mainPanel.pl.xSize >= i.xStart && mf.mainPanel.pl.x <= i.xStart + i.x
						&& mf.mainPanel.pl.floor >= i.yStart && mf.mainPanel.pl.floor <= i.yStart + 5) {
				} else {
					count++;
				}
			}
		}
		// ���� ���� ������ �ʾҰ� ������ �ö��� �ʾҰ� ������ �� �ִ� ��� player ��ġ �϶�
		if (count == mf.mainPanel.block.length && !mf.mainPanel.pl.isClimb && mf.mainPanel.pl.canMove) {
			mf.mainPanel.pl.y += 6;
		} else if (!mf.mainPanel.pl.isJump) { // ���� ���� �ְ� �������� �ƴϸ� player�� �ٴڿ� �ִٰ� �ν�
			mf.mainPanel.pl.isLanding = true;
		}

		// Hit ����
		for (Mob i : mf.mainPanel.mob) { // ������ ���� mob �� Ȯ��
			// ���� ���� �ְ� �̹� �°����� �ʴٸ�
			if (mf.mainPanel.pl.x + mf.mainPanel.pl.xSize >= i.xStart && mf.mainPanel.pl.x <= i.xStart + i.x
					&& mf.mainPanel.pl.floor >= i.yStart && mf.mainPanel.pl.y <= i.yStart + i.y
					&& !mf.mainPanel.pl.isHit && !i.isDie) {
				mf.mainPanel.pl.isHit = true;
				mf.mainPanel.pl.canMove = false;
				hit(mf, i);
			}
		}

		// levelUp ����
		switch (mf.mainPanel.pl.lv) {
		case 1:
			if (mf.mainPanel.pl.exp >= 2) {
				mf.mainPanel.pl.exp = 0;
				lvUp(mf);
				mf.mainPanel.askill.able = true;
			}
			break;
		case 2:
			if (mf.mainPanel.pl.exp >= 3) {
				mf.mainPanel.pl.exp = 0;
				lvUp(mf);
				mf.mainPanel.sskill.able = true;
			}
			break;
		case 3:
			if (mf.mainPanel.pl.exp >= 5) {
				mf.mainPanel.pl.exp = 0;
				lvUp(mf);
			}
			break;
		case 4:
			if (mf.mainPanel.pl.exp >= 10) {
				mf.mainPanel.pl.exp = 0;
				lvUp(mf);
				mf.mainPanel.dskill.able = true;
			}
			break;
		}
	}

	void jump(MyFrame mf) {
		Thread tr = new Thread() {
			int count = 0;

			@Override
			public void run() {
				while (true) {
					// player�� �ٴڿ� �꿩�ְų� ������ �ö� ��� ������ + x�� ���� ��
					if (mf.mainPanel.pl.isLanding || mf.mainPanel.pl.isClimb) {
						mf.mainPanel.pl.isJump = false;
						break;
					}
					try {
						Thread.sleep(8);
					} catch (Exception e) {
					}
					count++;
					// ȭ�� ���� ������, �ٴڿ� ���̱� ������ x�� ��� ����
					if (mf.mainPanel.pl.x >= 0 && mf.mainPanel.pl.x + mf.mainPanel.pl.xSize <= 720) {
						mf.mainPanel.pl.x += mf.mainPanel.pl.rightInt;
					}
					if (count < 30) { // player ��ġ ���
						mf.mainPanel.pl.y -= 2;
					} else if (count == 30) { // ������
						mf.mainPanel.pl.isJump = false;
					}
				}
			}
		};
		tr.start();
	}

	void climb(MyFrame mf, int updown) {
		int count = 0;
		for (Lof i : mf.mainPanel.lof) {
			if ((updown == -1 && mf.mainPanel.pl.x + mf.mainPanel.pl.xSize >= i.xStart
					&& mf.mainPanel.pl.x <= i.x + i.xStart && mf.mainPanel.pl.floor >= i.yStart
					&& mf.mainPanel.pl.floor <= i.yStart + i.y)
					|| (updown == 1 && mf.mainPanel.pl.x + mf.mainPanel.pl.xSize >= i.xStart
							&& mf.mainPanel.pl.x <= i.x + i.xStart && mf.mainPanel.pl.floor + 5 >= i.yStart
							&& mf.mainPanel.pl.floor <= i.yStart + i.y)) {
				mf.mainPanel.pl.isClimb = true;
				mf.mainPanel.pl.y += 4 * updown;
			} else {
				count++;
			}
			if (count == 3) {
				mf.mainPanel.pl.isClimb = false;
			}
		}

	}

	void hit(MyFrame mf, Mob mob) {
		Thread tr = new Thread() {

			@Override
			public void run() {
				mf.mainPanel.pl.hp -= mob.damage;
//				mf.mainPanel.pl.setIcon();

				try {
					for (int i = 0; i < 10; i++) {
						// ȭ�� ���� ������ �ڷ� �и�
						if (!mf.mainPanel.pl.isClimb) {
							if (mf.mainPanel.pl.x >= 0 && mf.mainPanel.pl.x + mf.mainPanel.pl.xSize <= 720) {
								mf.mainPanel.pl.x -= mf.mainPanel.pl.rightInt * 3;
							}
							if (i < 5) { // player ��ġ ���
								mf.mainPanel.pl.y -= 2;
							} else { // player ��ġ �϶�
								mf.mainPanel.pl.y += 2;
							}
						}
						Thread.sleep(10);
					}
					mf.mainPanel.pl.canMove = true;
					Thread.sleep(1500);
					mf.mainPanel.pl.isHit = false;
				} catch (Exception e) {
				}
			}
		};
		tr.start();
	}

	void lvUp(MyFrame mf) {
		mf.mainPanel.pl.lv++;
		mf.mainPanel.level.lv++;
		mf.mainPanel.level.levelUp();
		Thread tr = new Thread() {
			@Override
			public void run() {
				mf.mainPanel.levelUp.setVisible(true);
				try {
					for (int i = 0; i < 22; i++) {
						Thread.sleep(100);
						mf.mainPanel.levelUp.xStart = mf.mainPanel.pl.x
								- (mf.mainPanel.levelUp.x - mf.mainPanel.pl.xSize) / 2;
						mf.mainPanel.levelUp.yStart = mf.mainPanel.pl.floor - mf.mainPanel.levelUp.y;
						mf.mainPanel.levelUp.IconChange();
						mf.mainPanel.levelUp.BoundsChange();
					}
					mf.mainPanel.levelUp.setVisible(false);
				} catch (Exception e) {
				}
			}
		};
		tr.start();
	}

	void mobDie(MyFrame mf, Mob mob) {
		mob.hit = false;
		if (mob.right) {
			mob.setIcon(mob.dieImageR[0]);
		} else {
			mob.setIcon(mob.dieImage[0]);
		}
		Thread tr = new Thread() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < mob.dieImage.length; i++) {
						Thread.sleep(100);
						mob.dieIcon();
						mob.dieBounds();
					}
					mf.mainPanel.removeMop(mob);
					Thread.sleep(5000);
					mf.mainPanel.reMop(mob);
				} catch (Exception e) {
				}
			}
		};
		tr.start();
	}

	void aSkill(MyFrame mf) {
		Thread tr = new Thread() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 150; i++) {
						if (mf.mainPanel.attack[1].hit) {
							mf.mainPanel.attack[1].setVisible(false);
							mf.mainPanel.attack[1].xStart = 0;
							mf.mainPanel.attack[1].yStart = 0;
						} else {
							if (mf.mainPanel.attack[1].right) {
								mf.mainPanel.attack[1].xStart++;
							} else {
								mf.mainPanel.attack[1].xStart--;
							}
							mf.mainPanel.attack[1].BoundsChange();
						}
						Thread.sleep(5);
					}
					mf.mainPanel.attack[1].xStart = 0;
					mf.mainPanel.attack[1].yStart = 0;
					mf.mainPanel.attack[1].setVisible(false);
					Thread.sleep(2000);
				} catch (Exception e) {
				}
				mf.mainPanel.attack[1].hit = false;
				mf.mainPanel.askill.able = true;
			}
		};
		tr.start();
	}

	void mobHit(Attack at, Mob mob) {
		Thread tr = new Thread() {
			@Override
			public void run() {
				at.hitBounds(mob);
				try {
					Thread.sleep(400);
				} catch (Exception e) {
				}
				at.hitJl.setVisible(false);
			}
		};
		tr.start();
	}

	public static void main(String[] args) {

		MyFrame mf = new MyFrame();
		Main ma = new Main();

		mf.addKeyListener(new KeyAdapter() { // Ű �̺�Ʈ
			@Override
			public void keyPressed(KeyEvent e) { // Ű ��������
				switch (e.getKeyCode()) { // Ű �ڵ�� ����ġ
				case KeyEvent.VK_DOWN: // ����Ű(�Ʒ�) ��������
					ma.climb(mf, 1);
					break;
				case KeyEvent.VK_UP: // ����Ű(��)��������
					ma.climb(mf, -1);
					break;
				case KeyEvent.VK_LEFT: // ����Ű(��)��������
					if (mf.mainPanel.pl.canMove) {
						if (mf.mainPanel.pl.x >= 0 && !mf.mainPanel.pl.isClimb) {
							mf.mainPanel.pl.x -= 3;
							mf.mainPanel.pl.rightInt = -1;
							mf.mainPanel.pl.right = false;
						}
					}
					break;
				case KeyEvent.VK_RIGHT: // ����Ű(����)��������
					if (mf.mainPanel.pl.canMove) {
						if (mf.mainPanel.pl.x + mf.mainPanel.pl.xSize <= 720 && !mf.mainPanel.pl.isClimb) {
							mf.mainPanel.pl.x += 3;
							mf.mainPanel.pl.rightInt = 1;
							mf.mainPanel.pl.right = true;
						}
					}
					break;
				case KeyEvent.VK_ALT:
					if (mf.mainPanel.pl.canMove) {
						if (mf.mainPanel.pl.isLanding) {
							mf.mainPanel.pl.isLanding = false;
							mf.mainPanel.pl.isJump = true;
							ma.jump(mf);
						}
					}
					break;
				case KeyEvent.VK_CONTROL:
					mf.mainPanel.pl.exp++;
					break;
				case KeyEvent.VK_A:
					if (mf.mainPanel.askill.able) {
						mf.mainPanel.askill.able = false;
						System.out.println("a");
						mf.mainPanel.attack[1].setBounds(mf.mainPanel.pl);
						ma.aSkill(mf);
					}
					break;
				case KeyEvent.VK_S:
					if (mf.mainPanel.sskill.able) {
						System.out.println("s");
					}
					break;
				case KeyEvent.VK_D:
					if (mf.mainPanel.dskill.able) {
						System.out.println("d");
					}
					break;
				}
			}
		});

		try {
			Thread.sleep(100);
//			Thread.sleep(11000);
			mf.loadingPanel.setVisible(false);
		} catch (Exception e) {
		}

//		ma.visibleChange(mf.loadingPanel, mf.loginPanel);
//		ma.visibleChange(mf.loginPanel, mf.charSelectPanel);
//		ma.visibleChange(mf.charSelectPanel, mf.mainPanel);
		ma.visibleChange(mf.loadingPanel, mf.mainPanel);

		while (true) {
			try {
				Thread.sleep(20); // �ӵ� ����
			} catch (Exception e) {
			}
			ma.mopCheck(mf); // mob ��ġ, hpüũ, �׼�(move, hit, die, ���) ����
			ma.plCheck(mf); // player ��ġ, ������ ����
		}

	}
}

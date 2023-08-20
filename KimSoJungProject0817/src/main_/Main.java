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
			mf.mainPanel.mob[i].BoundsChange(); // 위치 재설정
			mf.mainPanel.mob[i].hpChange(); // hp 재설정

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
		// 위치 조정
		mf.mainPanel.pl.BoundsChange();

		// Hp 조정
		mf.mainPanel.hp.hpCheck(mf.mainPanel.pl.hp);

		// exp 조정
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

		// skill 조정
		mf.mainPanel.askill.iconChange();
		mf.mainPanel.sskill.iconChange();
		mf.mainPanel.dskill.iconChange();

		// 중력 구현
		int count = 0;
		for (Block i : mf.mainPanel.block) { // 닿이지 않은 블럭의 개수 확인
			if (!mf.mainPanel.pl.isJump) {
				if (mf.mainPanel.pl.x + mf.mainPanel.pl.xSize >= i.xStart && mf.mainPanel.pl.x <= i.xStart + i.x
						&& mf.mainPanel.pl.floor >= i.yStart && mf.mainPanel.pl.floor <= i.yStart + 5) {
				} else {
					count++;
				}
			}
		}
		// 블럭이 전부 닿이지 않았고 로프에 올라가지 않았고 움직일 수 있는 경우 player 위치 하락
		if (count == mf.mainPanel.block.length && !mf.mainPanel.pl.isClimb && mf.mainPanel.pl.canMove) {
			mf.mainPanel.pl.y += 6;
		} else if (!mf.mainPanel.pl.isJump) { // 닿인 블럭이 있고 점프중이 아니면 player가 바닥에 있다고 인식
			mf.mainPanel.pl.isLanding = true;
		}

		// Hit 구현
		for (Mob i : mf.mainPanel.mob) { // 닿이지 않은 mob 수 확인
			// 닿인 몹이 있고 이미 맞고있지 않다면
			if (mf.mainPanel.pl.x + mf.mainPanel.pl.xSize >= i.xStart && mf.mainPanel.pl.x <= i.xStart + i.x
					&& mf.mainPanel.pl.floor >= i.yStart && mf.mainPanel.pl.y <= i.yStart + i.y
					&& !mf.mainPanel.pl.isHit && !i.isDie) {
				mf.mainPanel.pl.isHit = true;
				mf.mainPanel.pl.canMove = false;
				hit(mf, i);
			}
		}

		// levelUp 구현
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
					// player가 바닥에 닿여있거나 로프에 올라간 경우 점프끝 + x값 변경 끝
					if (mf.mainPanel.pl.isLanding || mf.mainPanel.pl.isClimb) {
						mf.mainPanel.pl.isJump = false;
						break;
					}
					try {
						Thread.sleep(8);
					} catch (Exception e) {
					}
					count++;
					// 화면 범위 내에서, 바닥에 닿이기 전까지 x값 계속 변경
					if (mf.mainPanel.pl.x >= 0 && mf.mainPanel.pl.x + mf.mainPanel.pl.xSize <= 720) {
						mf.mainPanel.pl.x += mf.mainPanel.pl.rightInt;
					}
					if (count < 30) { // player 위치 상승
						mf.mainPanel.pl.y -= 2;
					} else if (count == 30) { // 점프끝
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
						// 화면 범위 내에서 뒤로 밀림
						if (!mf.mainPanel.pl.isClimb) {
							if (mf.mainPanel.pl.x >= 0 && mf.mainPanel.pl.x + mf.mainPanel.pl.xSize <= 720) {
								mf.mainPanel.pl.x -= mf.mainPanel.pl.rightInt * 3;
							}
							if (i < 5) { // player 위치 상승
								mf.mainPanel.pl.y -= 2;
							} else { // player 위치 하락
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

		mf.addKeyListener(new KeyAdapter() { // 키 이벤트
			@Override
			public void keyPressed(KeyEvent e) { // 키 눌렀을때
				switch (e.getKeyCode()) { // 키 코드로 스위치
				case KeyEvent.VK_DOWN: // 방향키(아래) 눌렀을때
					ma.climb(mf, 1);
					break;
				case KeyEvent.VK_UP: // 방향키(위)눌렀을때
					ma.climb(mf, -1);
					break;
				case KeyEvent.VK_LEFT: // 방향키(왼)눌렀을때
					if (mf.mainPanel.pl.canMove) {
						if (mf.mainPanel.pl.x >= 0 && !mf.mainPanel.pl.isClimb) {
							mf.mainPanel.pl.x -= 3;
							mf.mainPanel.pl.rightInt = -1;
							mf.mainPanel.pl.right = false;
						}
					}
					break;
				case KeyEvent.VK_RIGHT: // 방향키(오른)눌렀을때
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
				Thread.sleep(20); // 속도 지연
			} catch (Exception e) {
			}
			ma.mopCheck(mf); // mob 위치, hp체크, 액션(move, hit, die, 모션) 구현
			ma.plCheck(mf); // player 위치, 떨어짐 구현
		}

	}
}

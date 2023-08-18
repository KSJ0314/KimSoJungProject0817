package frame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import unit.*;

public class MainPanel extends JPanel {
	public Image background = new ImageIcon(MyFrame.class.getResource("../image/map1.png")).getImage();	// 배경화면
	public HpMp hpmp;
	public Hp hp;
	public Mp mp;
	public Askill askill;
	public Sskill sskill;
	public Dskill dskill;
	public Level level;
	public Exp exp;
	public Player pl;
	
	public MainPanel() {
		setSize(736, 542); // 사이즈 조정
		setLayout(null); // layout 자유설정 (id,pass 입력필드, 버튼 위치 상세조정을 위해 필요)
		setVisible(false);
		hpmp = new HpMp();
		hp = new Hp();
		mp = new Mp();
		askill = new Askill();
		sskill = new Sskill();
		dskill = new Dskill();
		level = new Level();
		exp = new Exp();
		pl = new Player();
		add(level);
		add(hpmp);
		add(hp);
		add(mp);
		add(askill);
		add(sskill);
		add(dskill);
		add(exp);
		addBlock();
		add(pl);
		
	}
	
	public void addBlock() {
		add(new Block(0,415,720));
		add(new Block(0,195,220));
		add(new Block(500,195,220));
		add(new Block(32,88,240));
		add(new Block(448,88,240));
		add(new Block(295,125,130));
		add(new Block(242,160,80));
		add(new Block(398,160,80));
		add(new Block(140,342,80));
		add(new Block(500,342,80));
		add(new Block(190,378,80));
		add(new Block(450,378,80));
		add(new Lof(96,195,150));
		add(new Lof(590,195,150));
		add(new Lof(278,0,60));
	}
	
	public void paintComponent(Graphics g) { // 백그라운드 이미지 설정
		g.drawImage(background, 0, 0, null);
	}

}

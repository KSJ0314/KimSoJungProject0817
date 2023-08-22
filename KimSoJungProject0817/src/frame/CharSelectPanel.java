package frame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CharSelectPanel extends JPanel implements ActionListener {

	public Image background = new ImageIcon(MyFrame.class.getResource("../image/charSelect.png")).getImage();	// 배경화면
	public JButton startBtn ;	// 게임시작버튼

	public CharSelectPanel() {
		setSize(736, 542); // 사이즈 조정
		setLayout(null);
		setVisible(false);
		
		startBtn = new JButton();
		startBtn.addActionListener(this);	// 버튼 클릭 이벤트 추가
		startBtn.setBorderPainted(false);	// 테두리 삭제
		startBtn.setContentAreaFilled(false);	// 버튼 내용 삭제 (버튼 투명화)
		startBtn.setBounds(510, 130, 100, 30); // 상위 객체가 setLayout(null)인 경우 필요, (위치x, 위치y, 사이즈x, 사이즈y)
		add(startBtn);
	}

	public void paintComponent(Graphics g) { // 백그라운드 이미지 설정
		g.drawImage(background, 0, 0, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	// 버튼에 클릭 이벤트 추가
		if (e.getSource() == startBtn) {
			setVisible(false);
		}
	}
}

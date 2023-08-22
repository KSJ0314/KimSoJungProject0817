package frame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CharSelectPanel extends JPanel implements ActionListener {

	public Image background = new ImageIcon(MyFrame.class.getResource("../image/charSelect.png")).getImage();	// ���ȭ��
	public JButton startBtn ;	// ���ӽ��۹�ư

	public CharSelectPanel() {
		setSize(736, 542); // ������ ����
		setLayout(null);
		setVisible(false);
		
		startBtn = new JButton();
		startBtn.addActionListener(this);	// ��ư Ŭ�� �̺�Ʈ �߰�
		startBtn.setBorderPainted(false);	// �׵θ� ����
		startBtn.setContentAreaFilled(false);	// ��ư ���� ���� (��ư ����ȭ)
		startBtn.setBounds(510, 130, 100, 30); // ���� ��ü�� setLayout(null)�� ��� �ʿ�, (��ġx, ��ġy, ������x, ������y)
		add(startBtn);
	}

	public void paintComponent(Graphics g) { // ��׶��� �̹��� ����
		g.drawImage(background, 0, 0, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	// ��ư�� Ŭ�� �̺�Ʈ �߰�
		if (e.getSource() == startBtn) {
			setVisible(false);
		}
	}
}

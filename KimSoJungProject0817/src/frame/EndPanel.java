package frame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndPanel extends JPanel implements ActionListener {

	public Image background = new ImageIcon(MyFrame.class.getResource("../image/charSelect.jpg")).getImage();
	public JButton reStartBtn; // ���ӽ��۹�ư

	public EndPanel() {
		setSize(736, 542); // ������ ����
		setLayout(null);
		setVisible(false);

		reStartBtn = new JButton();
		reStartBtn.addActionListener(this); // ��ư Ŭ�� �̺�Ʈ �߰�
		reStartBtn.setBorderPainted(false); // �׵θ� ����
		reStartBtn.setContentAreaFilled(true); // ��ư ���� ���� (��ư ����ȭ)
		reStartBtn.setBounds(510, 130, 100, 30); // ���� ��ü�� setLayout(null)�� ��� �ʿ�, (��ġx, ��ġy, ������x, ������y)
		add(reStartBtn);

	}

	public void paintComponent(Graphics g) { // ��׶��� �̹��� ����
		g.drawImage(background, 0, 0, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) { // ��ư�� Ŭ�� �̺�Ʈ �߰�
		if (e.getSource() == reStartBtn) {
			setVisible(false);
		}
	}
}

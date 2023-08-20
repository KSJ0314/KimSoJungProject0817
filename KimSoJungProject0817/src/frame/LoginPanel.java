package frame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LoginPanel extends JPanel implements ActionListener  {
	
	public Image background = new ImageIcon(MyFrame.class.getResource("../image/login.jpg")).getImage();	// ���ȭ��
	public JPasswordField passField;	// password �Է� �ʵ�
	public JTextField idField; // id �Է� �ʵ�
	public JButton loginBtn ;	// �α��� ��ư
	
	public LoginPanel() {
		setSize(736, 542); // ������ ����
		setLayout(null); // layout �������� (id,pass �Է��ʵ�, ��ư ��ġ �������� ���� �ʿ�)
		
		setVisible(false);

		passField = new JPasswordField() {
			public void setBorder(Border border) { // �Է� �ʵ� �׵θ� ����
			}
		};
		passField.setBounds(400, 240, 120, 20);
		passField.setOpaque(false); // ������
		add(passField); // LoginPanel�� password �Է� �ʵ� �߰�

		idField = new JTextField() {
			public void setBorder(Border border) {
			}
		};
		idField.setBounds(400, 210, 120, 20);
		idField.setOpaque(false);
		add(idField);
		
		loginBtn = new JButton();
		loginBtn.addActionListener(this);	// ��ư Ŭ�� �̺�Ʈ �߰�
		loginBtn.setBorderPainted(false);	// �׵θ� ����
		loginBtn.setContentAreaFilled(false);	// ��ư ���� ���� (��ư ����ȭ)
		loginBtn.setBounds(540, 210, 70, 50); // ���� ��ü�� setLayout(null)�� ��� �ʿ�, (��ġx, ��ġy, ������x, ������y)
		add(loginBtn);	// �α��� �гο� ��ư �߰�
		
	}

	public void paintComponent(Graphics g) { // ��׶��� �̹��� ����
		g.drawImage(background, 0, 0, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	// ��ư�� Ŭ�� �̺�Ʈ �߰�
		if (e.getSource() == loginBtn) {
			if (idField.getText().equals("test")) {
				System.out.println("id Ȯ��");
				if (passField.getText().equals("1234")) {
					System.out.println("password Ȯ��");
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "�н����尡 Ʋ�Ƚ��ϴ�.", "�α��� ����", JOptionPane.WARNING_MESSAGE);
					System.out.println("password ����");
					passField.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, "���̵� �������� �ʽ��ϴ�.", "�α��� ����", JOptionPane.WARNING_MESSAGE);
				System.out.println("id ����");
				idField.setText("");
				passField.setText("");
			}
		}
	}

}

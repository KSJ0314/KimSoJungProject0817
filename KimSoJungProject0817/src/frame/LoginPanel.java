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
	
	public Image background = new ImageIcon(MyFrame.class.getResource("../image/login.jpg")).getImage();	// 배경화면
	public JPasswordField passField;	// password 입력 필드
	public JTextField idField; // id 입력 필드
	public JButton loginBtn ;	// 로그인 버튼
	
	public LoginPanel() {
		setSize(736, 542); // 사이즈 조정
		setLayout(null); // layout 자유설정 (id,pass 입력필드, 버튼 위치 상세조정을 위해 필요)
		
		setVisible(false);

		passField = new JPasswordField() {
			public void setBorder(Border border) { // 입력 필드 테두리 삭제
			}
		};
		passField.setBounds(400, 240, 120, 20);
		passField.setOpaque(false); // 투명설정
		add(passField); // LoginPanel에 password 입력 필드 추가

		idField = new JTextField() {
			public void setBorder(Border border) {
			}
		};
		idField.setBounds(400, 210, 120, 20);
		idField.setOpaque(false);
		add(idField);
		
		loginBtn = new JButton();
		loginBtn.addActionListener(this);	// 버튼 클릭 이벤트 추가
		loginBtn.setBorderPainted(false);	// 테두리 삭제
		loginBtn.setContentAreaFilled(false);	// 버튼 내용 삭제 (버튼 투명화)
		loginBtn.setBounds(540, 210, 70, 50); // 상위 객체가 setLayout(null)인 경우 필요, (위치x, 위치y, 사이즈x, 사이즈y)
		add(loginBtn);	// 로그인 패널에 버튼 추가
		
	}

	public void paintComponent(Graphics g) { // 백그라운드 이미지 설정
		g.drawImage(background, 0, 0, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	// 버튼에 클릭 이벤트 추가
		if (e.getSource() == loginBtn) {
			if (idField.getText().equals("test")) {
				System.out.println("id 확인");
				if (passField.getText().equals("1234")) {
					System.out.println("password 확인");
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "패스워드가 틀렸습니다.", "로그인 실패", JOptionPane.WARNING_MESSAGE);
					System.out.println("password 오류");
					passField.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다.", "로그인 실패", JOptionPane.WARNING_MESSAGE);
				System.out.println("id 오류");
				idField.setText("");
				passField.setText("");
			}
		}
	}

}

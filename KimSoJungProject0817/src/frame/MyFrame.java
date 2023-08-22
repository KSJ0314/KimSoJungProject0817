package frame;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {	// ��ü ������

	public Image background3 = new ImageIcon(MyFrame.class.getResource("../image/charSelect.jpg")).getImage();
	public LoadingPanel loadingPanel;	// �ε� ��
	public LoginPanel loginPanel;	// �α��� ��
	public CharSelectPanel charSelectPanel;	// ĳ���ͼ��� ��
	public MainPanel mainPanel;	// �÷��� ��
	public EndPanel endPanel;	// ���� ��

	public MyFrame() { // ��ü ������

		setTitle("MapleStory_KSJ"); // Ÿ��Ʋ
		setSize(736, 578); // â ũ��
		setResizable(false); // â ũ�� ���� �Ұ�
		setLocationRelativeTo(null); // â ���
		setLayout(null);	// ���̾ƿ� ���� ����
		setVisible(true); // frame ���̱�
		setDefaultCloseOperation(EXIT_ON_CLOSE); // �ݱ� ��ư

		loadingPanel = new LoadingPanel();
		add(loadingPanel);
		
		loginPanel = new LoginPanel();
		add(loginPanel);
		
		charSelectPanel = new CharSelectPanel();
		add(charSelectPanel);
		
		mainPanel = new MainPanel();
		add(mainPanel);
		
		endPanel = new EndPanel();
		add(endPanel);
		
	}
	
}




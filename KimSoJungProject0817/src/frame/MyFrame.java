package frame;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {	// 전체 프레임

	public Image background3 = new ImageIcon(MyFrame.class.getResource("../image/charSelect.jpg")).getImage();
	public LoadingPanel loadingPanel;	// 로딩 씬
	public LoginPanel loginPanel;	// 로그인 씬
	public CharSelectPanel charSelectPanel;	// 캐릭터선택 씬
	public MainPanel mainPanel;	// 플레이 씬
	public EndPanel endPanel;	// 종료 씬

	public MyFrame() { // 전체 프레임

		setTitle("MapleStory_KSJ"); // 타이틀
		setSize(736, 578); // 창 크기
		setResizable(false); // 창 크기 변경 불가
		setLocationRelativeTo(null); // 창 가운데
		setLayout(null);	// 레이아웃 자유 설정
		setVisible(true); // frame 보이기
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 닫기 버튼

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




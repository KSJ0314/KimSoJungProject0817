package frame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoadingPanel extends JPanel  {
	
	public ImageIcon background = new ImageIcon(MyFrame.class.getResource("../image/gamestart.gif"));	// 배경화면
	
	public LoadingPanel() {
		setSize(736, 542); // 사이즈 조정
		setVisible(true);	// 화면 보이기, 로딩 gif 종료시 off
		
		JLabel loadinglabel = new JLabel();	// panel에 gif설정이 안되서 label을 추가하여 gif 설정
		loadinglabel.setSize(736, 542);
		loadinglabel.setIcon(background);	// 배경 추가 (gif)
		loadinglabel.setVisible(true);
		add(loadinglabel);
		
	}
}

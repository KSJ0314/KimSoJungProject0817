package frame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoadingPanel extends JPanel  {
	
	public ImageIcon background = new ImageIcon(MyFrame.class.getResource("../image/gamestart.gif"));	// ���ȭ��
	
	public LoadingPanel() {
		setSize(736, 542); // ������ ����
		setVisible(true);	// ȭ�� ���̱�, �ε� gif ����� off
		
		JLabel loadinglabel = new JLabel();	// panel�� gif������ �ȵǼ� label�� �߰��Ͽ� gif ����
		loadinglabel.setSize(736, 542);
		loadinglabel.setIcon(background);	// ��� �߰� (gif)
		loadinglabel.setVisible(true);
		add(loadinglabel);
		
	}
}

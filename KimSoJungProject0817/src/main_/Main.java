package main_;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import frame.MyFrame;

public class Main {
	
	void visibleChange(JPanel jp1, JPanel jp2) {
		while(true) {
			try {
				Thread.sleep(100);
				if (!jp1.isVisible()) {
					jp2.setVisible(true);
					break;
				}
			} catch (Exception e) {
			}
		}
	}
	
	public static void main(String[] args) {
		
		MyFrame mf = new MyFrame();
		Main ma = new Main();
		
		try {
			Thread.sleep(100);
//			Thread.sleep(11000);
			mf.loadingPanel.setVisible(false);
		} catch (Exception e) {
		}
		
//		ma.visibleChange(mf.loadingPanel, mf.loginPanel);
//		ma.visibleChange(mf.loginPanel, mf.charSelectPanel);
//		ma.visibleChange(mf.charSelectPanel, mf.mainPanel);
		ma.visibleChange(mf.loadingPanel, mf.mainPanel);
		
	}
}

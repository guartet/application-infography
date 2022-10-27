package main;
import java.awt.EventQueue;

import Cercle.cercle;
import infographie.ligne;
import menu.menu_3D;
import menu.menu_choix;
public class main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu_3D frame = new menu_3D();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

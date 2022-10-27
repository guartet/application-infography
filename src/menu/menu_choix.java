package menu;

import infographie.ligne;
import Cercle.cercle;
import Horlogee.Horloge;
import Trois_D.Cube;
import courbes.courbe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class menu_choix extends JFrame {

	private JPanel yd;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public menu_choix() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 396);
		yd = new JPanel();
		yd.setBackground(SystemColor.menu);
		yd.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(yd);
		yd.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/choise.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 79, 400, 280);
		yd.add(lblNewLabel);
		

		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(153, 50, 204));
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Segment"}));
		comboBox.addItem("Segment");
		comboBox.addItem("Cercle");
		comboBox.addItem("Horloge");
		
		
		comboBox.setBounds(396, 37, 165, 34);
		yd.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Un menu du choix entre les diff\u00E9rents programmes");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(10, 36, 376, 37);
       
		yd.add(lblNewLabel_1);
		
		
		JButton btnNewButton = new JButton("Entrer");
		btnNewButton.setForeground(new Color(153, 50, 204));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(438, 90, 102, 26);
		btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					String Value=(String)comboBox.getSelectedItem();
					
					if(comboBox.getSelectedItem()=="Segment"){ 
						//menu_chiox N=new menu_chiox();
						ligne V=new ligne();
						V.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						V.setVisible(true);
						V.setBounds(100, 100, 816, 606);
						V.setLayout(null);
						setVisible(false);
						
						//V.setSize(400, 600);
						//V.pack();
						//V.setLocationRelativeTo(null);
						
					}else if(comboBox.getSelectedItem()=="Cercle"){
						 cercle V=new cercle();
						 V.setVisible(true);
						 V.setBounds(100, 100, 816, 606);
						 setVisible(false);
						// V.pack();
						// V.setLocationRelativeTo(null);
						 V.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						 
					}
						
						
					else {
					Horloge V=new Horloge();	
					V.setVisible(true);
					 V.setBounds(100, 100, 816, 606);
					 setVisible(false);
					// V.pack();
					// V.setLocationRelativeTo(null);
					 V.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}
					
					
					
				}
				});
		yd.add(btnNewButton);
		
		
		
	}
}

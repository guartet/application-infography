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

public class menu_3D extends JFrame {

	private JPanel yd;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public menu_3D() {
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
		comboBox.addItem("2D");
		comboBox.addItem("3D");
		comboBox.addItem("Curves");
		
		comboBox.setBounds(396, 37, 165, 34);
		yd.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("A menu of choice between different programs");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(10, 36, 376, 37);
       
		yd.add(lblNewLabel_1);
		
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setForeground(new Color(153, 50, 204));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(438, 90, 102, 26);
		btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					String Value=(String)comboBox.getSelectedItem();
					if(comboBox.getSelectedItem()=="2D"){
					 
						//menu_chiox N=new menu_chiox();
						menu_choix V=new menu_choix();
						V.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						V.setVisible(true);
						V.setBounds(100, 100, 816, 606);
						V.setLayout(null);
						setVisible(false);
						
						//V.setSize(400, 600);
						//V.pack();
						//V.setLocationRelativeTo(null);
						
					
						 
					}else if(comboBox.getSelectedItem()=="3D"){
						
						
						 menu_3 V=new menu_3();
						 V.setVisible(true);
						 V.setBounds(100, 100, 816, 606);
						 setVisible(false);
						// V.pack();
						// V.setLocationRelativeTo(null);
						 V.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
					    else {
						 courbe V=new courbe();
						 V.setVisible(true);
						 V.setBounds(100, 100, 816, 606);
						 setVisible(false);
						// V.pack();
						// V.setLocationRelativeTo(null);
						 V.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
						 
					
					
					
				}
				});
		yd.add(btnNewButton);
		
		
		
	}
}

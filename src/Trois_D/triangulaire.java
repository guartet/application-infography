package Trois_D;



import menu.menu_3;
import menu.menu_choix;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import infographie.ligne;

import javax.swing.JTextField;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import javax.swing.JRadioButton;
import javax.swing.JMenuBar;
import javax.swing.Action;
import javax.swing.ButtonGroup;

public class triangulaire extends JFrame {

	private JPanel yd;
	private JTextField xd;
	JPanel Centre_panel = new JPanel();
	private JTextField textField;
	private JTextField xf;
	private JTextField yf;
	JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	//private final Action action = new SwingAction();
	
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	
	public triangulaire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 606);
		yd = new JPanel();
		yd.setForeground(new Color(255, 140, 0));
		yd.setBackground(SystemColor.menu);
		yd.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(yd);
		yd.setLayout(null);
		
		
		
		
		 
		
		Centre_panel.setBackground(Color.BLACK);
		Centre_panel.setBounds(20, 81, 772, 478);
		yd.add(Centre_panel);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(153, 50, 204));
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Segment"}));
		comboBox.addItem("Translation");
		comboBox.addItem("Symétrie");
		comboBox.addItem("Retation");
		
		
		comboBox.setBounds(40, 10, 95, 21);
		yd.add(comboBox);
		
		
		JRadioButton boton_BR = new JRadioButton("Par_rapportX",false);
		boton_BR.setForeground(new Color(128, 0, 0));
		buttonGroup.add(boton_BR);
		boton_BR.setBounds(190, 10, 120, 21);
		yd.add(boton_BR);
		
		JRadioButton botton_TR = new JRadioButton("Par_rapportY",false);
		botton_TR.setForeground(new Color(128, 0, 0));
		buttonGroup.add(botton_TR);
		botton_TR.setBounds(314, 10, 135, 21);
		yd.add(botton_TR);
		
		
		JButton envoyer = new JButton("Envoyer");
		envoyer.setFont(new Font("Tahoma", Font.BOLD, 12));
		envoyer.setForeground(Color.MAGENTA);
		envoyer.setBackground(Color.CYAN);
		envoyer.setBounds(464, 51, 85, 21);
		
		
		
			
			
		
		envoyer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			
				double[][] C=new double[8][4] ;
				double[][]	t={{0,0,0,100},{100,0,-100,100},{-100,0,-100,100},{0,50,0,100},{100,0,-50,100},{-100,-50,0,100}};
				double[][] D=new double[6][4] ;
				double[][] E=new double[6][4] ;
				double   [][] matProCavaliere={{1,0,0,0} ,{0,1,0,0} , {0 ,1,0,0} ,{0,0,0,1} };
				 Graphics g= Centre_panel.getGraphics();
					
					g.setColor(Color.orange);
					g.drawLine(320, 240, 560, 470);
					g.drawLine(320, 0, 320, 240);
					g.drawLine(320, 240, 0, 560);
				
					Tracer_tringle(D,g);				
				
				if(comboBox.getSelectedItem()=="Translation"){ 
					//menu_chiox N=new menu_chiox();
					if(boton_BR.isSelected()){  
						
						//double[][] B= {{0,-1,0,0},{1,0,0,0},{0,0,0,-1/20},{0,0,0,1}};
						double[][] B= {{1,0,0,0},{0,1,0,0},{0,0,1,0},{-2,0,0,1}};
						
						g.setColor(Color.red);
						//Tracer_tringle(t,g);
						Produit_Matrice(t,matProCavaliere,D,6,4);
						
						//Tracer_tringle(D,g);
						
						Produit_Matrice(D,B,C,8,4);
						//perspective(C);
						Tracer_tringle(C,g);
			            
						
						
					}else
					if(botton_TR.isSelected() ) {
						
						double[][] B= {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,-1,0,1}};
						 
						g.setColor(Color.red);
                      Produit_Matrice(t,matProCavaliere,D,6,4);
						
						//Tracer_tringle(D,g);
						
						Produit_Matrice(D,B,C,8,4);
						Tracer_tringle(C,g);
						
						//int YD = Integer.parseInt(textField.getText());
					}else {
						JOptionPane.showMessageDialog( frame, "seléctionez l'axe que vous voulez utiliser");  	
					}
					
					
				}else if(comboBox.getSelectedItem()=="Symétrie"){
					
                      if(boton_BR.isSelected()){  
						
                    	  //double[][] B= {{-1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
                    	  double[][] B= {{1,0,0,0},{0,1,0,0},{0,0,-1,0},{0,0,0,1}};
                    	 g.setColor(Color.red);
                    	 Produit_Matrice(t,matProCavaliere,D,6,4);
 						
 						//Tracer_tringle(D,g);
 						
 						Produit_Matrice(D,B,C,8,4);
 						Tracer_tringle(C,g);
					}else
					if(botton_TR.isSelected() ) {
						
						double[][] B= {{1,0,0,0},{0,-1,0,0},{0,0,1,0},{0,0,0,1}};
						g.setColor(Color.red);
                       Produit_Matrice(t,matProCavaliere,D,6,4);
						
						//Tracer_tringle(D,g);
						
						Produit_Matrice(D,B,C,8,4);
						Tracer_tringle(C,g);
					}else {
						JOptionPane.showMessageDialog( frame, "seléctionez l'axe que vous voulez utiliser");  	
					}
					
					
				}else {
					if(boton_BR.isSelected()){  
						double theta3 = Math.atan(Math.sqrt(2)) ;
						
						
						double[][] B= {{1,0,0,0},{0,1,-1,0},{0,1,0,0},{0,0,0,1}};
						//double[][] B= {{0,-1,0,0},{1,0,0,0},{0,0,0,-1/20},{0,-20,0,1}};
						 double [][]rotX={{1,0,0,0},{0,Math.cos(theta3),Math.sin(theta3),0},{0,-Math.sin(theta3),Math.cos(theta3),0},{0,0,0,1}};
						//int XD = Integer.parseInt(xd.getText());
                  	 g.setColor(Color.red);
						//Tracer_cube(A, g);
                  	Produit_Matrice(t,matProCavaliere,D,6,4);
					
					//Tracer_tringle(D,g);
					
					Produit_Matrice(D,rotX,C,6,4);
					Tracer_tringle(C,g);
		            
		            
					
					}else
					if(botton_TR.isSelected() ) {
						 double theta2 = Math.PI/2;
						//double[][] B= {{0,0,-1,0},{0,1,0,0},{1,0,0,0},{0,0,0,1}};
						//double[][] B= {{1,-0.85,0.75,0},{-0.75,1,0.7,0},{0.5,1,1,0},{0,0,0,1}};
						 double [][]rotY={{Math.cos(theta2),0,-Math.sin(theta2),0},{0,1,0,0},{Math.sin(theta2),0,Math.cos(theta2),0},{0,0,0,1}};
						g.setColor(Color.red);
                   //  Produit_Matrice(t,matProCavaliere,D,6,4);
						
						//Tracer_tringle(D,g);
						
						Produit_Matrice(t,rotY,C,6,4);
						 Produit_Matrice(C,matProCavaliere,E,6,4);
						Tracer_tringle(E,g);
						//int YD = Integer.parseInt(textField.getText());
					}else {
						JOptionPane.showMessageDialog( frame, "seléctionez l'axe que vous voulez utiliser");  	
					}
				}
				
			
			
			
				
			}
			
			private double[][] Produit_Matrice(double[][] A,double[][] B,double[][] C,int n,int m){
				double som=0;
				    for(int i=0;i<n;i++){
				        for(int j=0;j<m;j++){

				            for (int k = 0; k < m; k++) {
				                   som  +=  A[i][k] * B[k][j];
				               }
				        C[i][j] = som;
				        som=0;
				        }
				    }
				    return C;
				}
			private void pixel(int x1,int x2,Graphics g) {
				x1=x1+320;
				x2=240-x2;
				g.setColor(Color.white);
				g.drawString(".", x1, x2);
			}
			void ligne_octants_1_4_5_8(int xd, int yd, int Dx, int Dy,Graphics g){
			    int pas_x = (Dx>0)?1:-1;
			    int pas_y = (Dy>0)?1:-1;
			    Dx = Math.abs(Dx);
			    Dy = Math.abs(Dy);
			    int s = 2*Dy-Dx;
			    int i = 1;

			    while (i <= Dx){
			        if (s >= 0){
			            xd+=pas_x;
			            yd+=pas_y;
			            s += 2*(Dy-Dx);
			            pixel(xd, yd,g);
			            i++;
			        }
			        else{
			            xd+=pas_x;
			            s += 2*Dy;
			            pixel(xd, yd,g);
			            
			            i++;
			        }
			    }
			}
			void ligne_octants_2_3_6_7(int xd, int yd, int Dx, int Dy,Graphics g){
			    int pas_x = (Dx>0)?1:-1;
			    int pas_y = (Dy>0)?1:-1;
			    Dx = Math.abs(Dx);
			    Dy = Math.abs(Dy);
			    int s = 2*Dx-Dy;
			    int i = 1;

			    while (i <= Dy){
			        if (s >= 0){
			            xd+=pas_x;
			            yd+=pas_y;
			            s += 2*(Dx-Dy);
			            pixel(xd, yd,g);
			            i++;
			        }
			        else{
			            yd+=pas_y;
			            s += 2*Dx;
			            pixel(xd, yd,g);
			            i++;
			        }
			    }
			}
			
			void bresenham_line(int xd, int yd, int xf, int yf,Graphics g){
			    int Dx = xf-xd;
			    int Dy = yf-yd;

			    if(Math.abs(Dx)>=Math.abs(Dy)){
			        ligne_octants_1_4_5_8(xd, yd, Dx, Dy,g);
			    }
			    else{
			        ligne_octants_2_3_6_7(xd, yd, Dx, Dy,g);
			    }

			}
		
			
			private void Tracer_tringle(double[][] resRot,Graphics g){
				
				 g.drawString( "A ",320+(int)resRot[0][0],240-(int)resRot[0][1]);
				   g.drawString( "B ",320+(int)resRot[1][0],240-(int)resRot[1][1]);
				   g.drawString("C ",320+(int)resRot[2][0],240-(int)resRot[2][1] );
				   g.drawString("D ",320+(int)resRot[3][0],240-(int)resRot[3][1] );
				   g.drawString("E ",320+(int)resRot[4][0],240-(int)resRot[4][1] );
				   g.drawString("F ",320+(int)resRot[5][0],240-(int)resRot[5][1] );
				
				
			//bresenham_line((int)resRot[0][0],(int)resRot[0][1],(int)resRot[1][0],(int)resRot[1][1],g);
			   
			  // bresenham_line((int)resRot[0][0],(int)resRot[0][1],(int)resRot[2][0],(int)resRot[2][1],g);
			   
			   bresenham_line((int)resRot[0][0],(int)resRot[0][1],(int)resRot[3][0],(int)resRot[3][1],g);
			   bresenham_line((int)resRot[1][0],(int)resRot[1][1],(int)resRot[0][0],(int)resRot[0][1],g);
			   
			   bresenham_line((int)resRot[1][0],(int)resRot[1][1],(int)resRot[2][0],(int)resRot[2][1],g);
			   bresenham_line((int)resRot[1][0],(int)resRot[1][1],(int)resRot[4][0],(int)resRot[4][1],g);
			   
			   bresenham_line((int)resRot[2][0],(int)resRot[2][1],(int)resRot[5][0],(int)resRot[5][1],g);
			   bresenham_line((int)resRot[2][0],(int)resRot[2][1],(int)resRot[0][0],(int)resRot[0][1],g);
			   
			   bresenham_line((int)resRot[3][0],(int)resRot[3][1],(int)resRot[5][0],(int)resRot[5][1],g);
			 
			   bresenham_line((int)resRot[3][0],(int)resRot[3][1],(int)resRot[4][0],(int)resRot[4][1],g);
			   bresenham_line((int)resRot[4][0],(int)resRot[4][1],(int)resRot[5][0],(int)resRot[5][1],g);
			}
			   
			   private void perspective(double[][] M){

				   for(int i=0 ;i<8; i++){
				       if(M[i][3]!=100){

				         for(int a=0; a<4 ;a++){
				            M[i][a]=100*(M[i][a]/M[i][3]);
				            }
				        }
				    }

				}
            
			

			
		
				
				
			
		
	});
	
		yd.add(envoyer);
		
		JButton btnNewButton = new JButton("return");
		btnNewButton.setBackground(new Color(255, 192, 203));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(255, 140, 0));
		btnNewButton.setBounds(564, 51, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				menu_3 V=new menu_3();
				V.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				V.setBounds(100, 100, 591, 396);
				V.setVisible(true);
				setVisible(false);
				//V.pack();
				 //V.setLocationRelativeTo(null);
			}
			
});
		
		yd.add(btnNewButton);
		
		
		
		
		
		
	}
}
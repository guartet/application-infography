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

public class Cube extends JFrame {

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

	
	public Cube() {
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
		comboBox.addItem("Rotation");
		comboBox.addItem("Symétrie");
		
		
		
		comboBox.setBounds(40, 10, 95, 21);
		yd.add(comboBox);
		
		
		
		
		JButton envoyer = new JButton("Envoyer");
		envoyer.setFont(new Font("Tahoma", Font.BOLD, 12));
		envoyer.setForeground(Color.MAGENTA);
		envoyer.setBackground(Color.CYAN);
		envoyer.setBounds(464, 51, 85, 21);
		
		
		
			
			
		
		envoyer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//double[][]	A={{0,0,0,100},{100,0,0,100},{100,100,0,100},{0,100,0,100},{0,100,-100,100},{0,0,-100,100},{100,0,-100,100},{100,100,-100,100}};
				
				double[][] biseau={
						{0,0,0,1},
						{100,0,0,1},
						{100,100,0,1},
						{0,100,0,1},
						{0,0,50,1},
						{0,100,50,1},
						{50,100,25,1},
						{50,200,25,1}};
				
				double teta=(Math.PI/3);
	            double a=Math.cos(teta);
	            double b=Math.sin(teta);
	double[][] MT_cabinet={{1,0,0,0},{0,1,0,0},
	            {0.5*a,0.5*b,0,0},{0,0,0,1}};//Cabinet
	double[][] MT_cavalier={
								{1,0,0,0},
								{0,1,0,0},
	        					{a,b,0,0},
								{0,0,0,1}};//Cavalier
	double[][] Translation={
								{1,0,0,0},
								{0,1,0,0},
	       						{0,0,1,0},
								{-50,-100,-25,1}};//Translation
	double[][] RotY={
			{2/Math.sqrt(5),0,-1/Math.sqrt(5),0},
			{0,1,0,0},
	        {1/Math.sqrt(5),0,2/Math.sqrt(5),0},
			{0,0,0,1}};//RotationY
		double[][] RotZ={
			            {Math.cos(Math.PI/3),Math.sin(Math.PI/3),0,0},
			            {-Math.sin(Math.PI/3),Math.cos(Math.PI/3),0,0},
	        			{0,0,1,0},
						{0,0,0,1}};//RotationY
			double[][] TranslationInvr={
			{1,0,0,0},
			{0,1,0,0},
	        {0,0,1,0},
			{50,100,25,1}};//Translationinverse
			double [][] RotYInvr={
			{2/Math.sqrt(5),0,+1/Math.sqrt(5),0},
			{0,1,0,0},
	        {-1/Math.sqrt(5),0,2/Math.sqrt(5),0},
			{0,0,0,1}};//RotationY
				
				
				double[][] res1=new double[8][4] ;
				double[][] res2=new double[8][4] ;
				double[][] res3=new double[8][4] ;
				double[][] res4=new double[8][4] ;
				double[][] res5=new double[8][4] ;
				double[][] res6=new double[8][4] ;
				
				
				
				
				
				double[][] D=new double[8][4] ;
				 Graphics g= Centre_panel.getGraphics();
					
					g.setColor(Color.WHITE);
					g.drawLine(320, 240, 840, 240);
					g.drawLine(320, 0, 320, 240);
					g.drawLine(320, 240, 0, 560);
				
				
					
				if(comboBox.getSelectedItem()=="Translation"){ 
					
					
						
						g.setColor(Color.red);
						Produit_Matrice(biseau,Translation,res2,8,4);
						Produit_Matrice(res2,RotY,res3,8,4);
						Produit_Matrice(res3,RotZ,res4,8,4);
						Produit_Matrice(res4,RotYInvr,res5,8,4);
						Produit_Matrice(res5,TranslationInvr,res6,8,4);
						Tracer_cube(res5,g);
						
						
						
						
						
						
						
					}else {

						double[][] TranslationX={
								{1,0,0,0},
								{0,1,0,0},
						        {0,0,1,0},
								{-100,0,0,1}};//TranslationX
						double[][] TranslationXinv={
								{1,0,0,0},
								{0,1,0,0},
						        {0,0,1,0},
								{100,0,0,1}};//TranslationXinv
						double[][] SymtZ={
								{1,0,0,0},
								{0,1,0,0},
						        {0,0,-1,0},
								{0,0,0,1}};//Symetrie Z
						double[][] RotYY={
								{2/Math.sqrt(5),0,1/Math.sqrt(5),0},
								{0,1,0,0},
						        {-1/Math.sqrt(5),0,2/Math.sqrt(5),0},
								{0,0,0,1}};//RotationYY
						double[][] RotYYinv={
								{2/Math.sqrt(5),0,-1/Math.sqrt(5),0},
								{0,1,0,0},
						        {1/Math.sqrt(5),0,2/Math.sqrt(5),0},
								{0,0,0,1}};//RotationYYin
					
					double[][] B= {{1,0,0,0},{0,1,0,0},{0,0,0,-0.1},{-0.5,-0.5,0,1}};
					
					g.setColor(Color.red);
					Produit_Matrice(biseau,TranslationX,res2,8,4);
					Produit_Matrice(res2,RotYY,res3,8,4);
					Produit_Matrice(res3,SymtZ,res4,8,4);
					Produit_Matrice(res4,RotYYinv,res5,8,4);
					Produit_Matrice(res5,TranslationXinv,res6,8,4);
					Tracer_cube(res6,g);
					
					
					
					
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
				g.setColor(Color.orange);
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
			
		
			private void Tracer_cube(double[][] resRot,Graphics g){
				//g.setColor(Color.black);
				//Tracer_cube(resRot,g);
				

				//g.setColor(Color.red);
				   g.drawString( "A ",320+(int)resRot[0][0],240-(int)resRot[0][1]);
				   g.drawString( "B ",320+(int)resRot[1][0],240-(int)resRot[1][1]);
				   g.drawString("C ",320+(int)resRot[2][0],240-(int)resRot[2][1] );
				   g.drawString("D ",320+(int)resRot[3][0],240-(int)resRot[3][1] );
				   g.drawString("E ",320+(int)resRot[4][0],240-(int)resRot[4][1] );
				   g.drawString("F ",320+(int)resRot[5][0],240-(int)resRot[5][1] );
				   g.drawString("G ",320+(int)resRot[6][0],240-(int)resRot[6][1] );
				  // g.drawString("h ",320+(int)resRot[7][0],240-(int)resRot[7][1] );
				   
				   
				   
				 
				   
                  bresenham_line((int)resRot[0][0],(int)resRot[0][1],(int)resRot[4][0],(int)resRot[4][1],g);
				   
				   bresenham_line((int)resRot[0][0],(int)resRot[0][1],(int)resRot[3][0],(int)resRot[3][1],g);
				   
				   bresenham_line((int)resRot[1][0],(int)resRot[1][1],(int)resRot[0][0],(int)resRot[0][1],g);
				   
				   bresenham_line((int)resRot[1][0],(int)resRot[1][1],(int)resRot[4][0],(int)resRot[4][1],g);
				   bresenham_line((int)resRot[1][0],(int)resRot[1][1],(int)resRot[2][0],(int)resRot[2][1],g);
				   
				   bresenham_line((int)resRot[2][0],(int)resRot[2][1],(int)resRot[3][0],(int)resRot[3][1],g);
				   
				  
				   bresenham_line((int)resRot[5][0],(int)resRot[5][1],(int)resRot[2][0],(int)resRot[2][1],g);
				   bresenham_line((int)resRot[5][0],(int)resRot[5][1],(int)resRot[4][0],(int)resRot[4][1],g);
				   bresenham_line((int)resRot[5][0],(int)resRot[5][1],(int)resRot[3][0],(int)resRot[3][1],g);
				   bresenham_line((int)resRot[6][0],(int)resRot[6][1],(int)resRot[7][0],(int)resRot[7][1],g);
				   
				   
				   
				   
				   
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
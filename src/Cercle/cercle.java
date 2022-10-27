package Cercle;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import menu.menu_choix;

import javax.swing.JTextField;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class cercle extends JFrame {

	private JPanel yd;
	private JTextField xd;
	JPanel Centre_panel = new JPanel();
	private JTextField textField;
	private JTextField xf;
	private JTextField yf;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JFrame frame;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public cercle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 606);
		yd = new JPanel();
		yd.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(yd);
		yd.setLayout(null);
		
		
		Centre_panel.setBackground(Color.BLACK);
		Centre_panel.setBounds(20, 81, 772, 478);
		yd.add(Centre_panel);
		
		xd = new JTextField();
		//xd.setBackground(Color.WHITE);
		//xd.setForeground(Color.BLACK);
	    xd.setForeground(new Color(0, 0, 0));
		xd.setBounds(10, 52, 96, 19);
		xd.setColumns(10);
		yd.add(xd);
		
		
		JLabel Xd = new JLabel("R");
		Xd.setForeground(Color.BLUE);
		Xd.setBackground(Color.PINK);
		Xd.setBounds(10, 29, 76, 13);
		yd.add(Xd);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setBounds(116, 52, 96, 19);
		textField.setColumns(10);
		yd.add(textField);
		
		JLabel Yd = new JLabel("H");
		Yd.setForeground(Color.BLUE);
		Yd.setBounds(121, 29, 56, 13);
		yd.add(Yd);
		
		xf = new JTextField();
		xf.setForeground(new Color(0, 0, 0));
		xf.setBounds(222, 52, 96, 19);
		xf.setColumns(10);
		yd.add(xf);
		
		
		JLabel Xf = new JLabel("K");
		Xf.setForeground(Color.BLUE);
		Xf.setBounds(222, 29, 45, 13);
		yd.add(Xf);
		
		
		
		JRadioButton boton_BR = new JRadioButton("BRESENHAM",true);
		boton_BR.setForeground(new Color(128, 0, 0));
		buttonGroup.add(boton_BR);
		boton_BR.setBounds(215, 2, 120, 21);
		yd.add(boton_BR);
		
		JRadioButton botton_TR = new JRadioButton("Trigonométrique",false);
		botton_TR.setForeground(new Color(128, 0, 0));
		buttonGroup.add(botton_TR);
		botton_TR.setBounds(414, 2, 135, 21);
		yd.add(botton_TR);
		
		JRadioButton botton_PL = new JRadioButton("POLYNOMIALE",false);
		botton_PL.setForeground(new Color(128, 0, 0));
		buttonGroup.add(botton_PL);
		botton_PL.setBounds(555, 2, 145, 21);
		yd.add(botton_PL);
		
		JLabel lblNewLabel = new JLabel("choisis la m\u00E9thode a utilis\u00E9:");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setBounds(39, 4, 173, 17);
		yd.add(lblNewLabel);
		
		JButton envoyer = new JButton("Envoyer");
		envoyer.setForeground(Color.MAGENTA);
		envoyer.setBackground(Color.CYAN);
		envoyer.setBounds(445, 51, 85, 21);
		envoyer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int R = Integer.parseInt(xd.getText());
				int H = Integer.parseInt(textField.getText());
				int K = Integer.parseInt(xf.getText());
				
				Graphics g= Centre_panel.getGraphics();
				g.setColor(Color.WHITE);
				g.drawLine(0, 240, 740, 240);
				g.drawLine(320, 0, 320, 480);
				g.setColor(Color.blue);
				if(boton_BR.isSelected()){  
					

				cercle_Bres(R ,H, K, g);
			}else 
				if(botton_TR.isSelected() ) {
				 cercle_trigo(R ,H, K,  g);
			}else
				if(botton_PL.isSelected() ) {
					 cercle_poly(R ,H, K,  g);
				}
				else {
				JOptionPane.showMessageDialog( frame, "seléctionez la méthode que vous voulez utiliser");  	
			}
			}
			/*public void paint(Graphics g)
			{
			
				initgr();
				paintCoordinateSystem(g);;
				droite_bresenham(g, 1, 1,8,5);
			}*/
          /*  private void trace_Pixel(int x1,int x2, int color) {
            	
            	x1+=320;
            	x2=240-x2;
            	pixelSize=20;
            	
            }*/
			private void pixel(int x1,int x2,Graphics g) {
				x1=x1+320;
				x2=240-x2;
				g.setColor(Color.orange);
				g.drawString(".", x1, x2);
			}
			private void cercle_Bres(int r, int h, int k, Graphics g) {
				// TODO Auto-generated method stub
				int  x = 0 ;
				   int y = r ;

				   int S = 3 - 2*r ;
				   int i = 1;

				   while ( i<3){
				       if ( S > 0){

				        x += 1 ;
				        y -= 1 ;
				        S+= 4*(x-y)+10 ;

				        i++;
				       }else{
				           x+=1;
				           S+= 4*x + 6 ;

				           i++;
				       }
				       pixel(x+h , y+k , g);   pixel(y+h , x+k , g);

				       pixel(-y+h , x+k , g); pixel(-x+h , y+k , g);

				       pixel(-x+h , -y+k , g); pixel(-y+h ,-x+k , g);

				       pixel(y+h ,-x+k , g);  pixel(x+h ,-y+k , g );
				   }
			}
			///polynomiale
			private void cercle_trigo(int r ,int h , int k ,   Graphics g){
				int x,y;
				float a=0;
				while(a<=Math.PI/4) {
                x=(int)(Math.cos(a))*r;
                y=(int)(Math.sin(a))*r;
				
				pixel(x+h , y+k , g);   pixel(y+h , x+k , g);

			       pixel(-y+h , x+k , g); pixel(-x+h , y+k , g);

			       pixel(-x+h , -y+k , g); pixel(-y+h ,-x+k , g);

			       pixel(y+h ,-x+k , g);  pixel(x+h ,-y+k , g );
			       a+=Math.PI/50;
				}
			}
			private void cercle_poly(int r ,int h , int k ,   Graphics g){
				int x=0,y;
				
				while(x<=r/Math.sqrt(2)) {
              y=(int)(Math.sqrt(r*r-(x-h)*x-h)+k);
              x++;
				
				pixel(x+h , y+k , g);   pixel(y+h , x+k , g);

			       pixel(-y+h , x+k , g); pixel(-x+h , y+k , g);

			       pixel(-x+h , -y+k , g); pixel(-y+h ,-x+k , g);

			       pixel(y+h ,-x+k , g);  pixel(x+h ,-y+k , g );
			      
				}
			}

			/*public void repere( Graphics g)
			{
			
				
			}*/
		
				
				
			
		
	});
	
		yd.add(envoyer);
		
		JButton btnNewButton = new JButton("return");
		btnNewButton.setBackground(new Color(255, 192, 203));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(255, 140, 0));
		btnNewButton.setBounds(564, 51, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				menu_choix V=new menu_choix();
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

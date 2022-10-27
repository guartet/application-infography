package infographie;
import menu.menu_choix;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JMenuBar;
import javax.swing.Action;
import javax.swing.ButtonGroup;

public class ligne extends JFrame {

	private JPanel yd;
	private JTextField xd;
	JPanel Centre_panel = new JPanel();
	private JTextField textField;
	private JTextField xf;
	private JTextField yf;
	JFrame frame;
	//private final Action action = new SwingAction();
	
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	 

	/**
	 * Create the frame.
	 */
	public ligne() {
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
		
		xd = new JTextField();
		//xd.setBackground(Color.WHITE);
		//xd.setForeground(Color.BLACK);
	    xd.setForeground(new Color(0, 0, 0));
		xd.setBounds(10, 52, 96, 19);
		xd.setColumns(10);
		yd.add(xd);
		
		
		JLabel Xd = new JLabel("Xd");
		Xd.setForeground(Color.BLUE);
		Xd.setBackground(Color.PINK);
		Xd.setBounds(10, 29, 76, 13);
		yd.add(Xd);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setBounds(116, 52, 96, 19);
		textField.setColumns(10);
		yd.add(textField);
		
		JLabel Yd = new JLabel("Yd");
		Yd.setForeground(Color.BLUE);
		Yd.setBounds(121, 29, 56, 13);
		yd.add(Yd);
		
		xf = new JTextField();
		xf.setForeground(new Color(0, 0, 0));
		xf.setBounds(222, 52, 96, 19);
		xf.setColumns(10);
		yd.add(xf);
		
		
		JLabel Xf = new JLabel("Xf");
		Xf.setForeground(Color.BLUE);
		Xf.setBounds(222, 29, 45, 13);
		yd.add(Xf);
		
		yf = new JTextField();
		yf.setForeground(new Color(0, 0, 0));
		yf.setBounds(328, 52, 96, 19);
		yf.setColumns(10);
		yd.add(yf);
		
		
		JLabel Yf = new JLabel("Yf");
		Yf.setForeground(Color.BLUE);
		Yf.setBounds(329, 29, 45, 13);
		yd.add(Yf);
		
		JRadioButton boton_BR = new JRadioButton("BRESENHAM");
		buttonGroup_1.add(boton_BR);
		boton_BR.setForeground(new Color(128, 0, 0));
		boton_BR.setBounds(266, 2, 120, 21);
		yd.add(boton_BR);
		
		JRadioButton botton_go = new JRadioButton("Polynomiale");
		buttonGroup_1.add(botton_go);
		botton_go.setForeground(new Color(128, 0, 0));
		botton_go.setBounds(414, 2, 135, 21);
		yd.add(botton_go);
		
		
		
		JLabel lblNewLabel = new JLabel("choisis la m\u00E9thode a utilis\u00E9:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setBounds(39, 4, 194, 17);
		yd.add(lblNewLabel);
		
		JButton envoyer = new JButton("Envoyer");
		envoyer.setFont(new Font("Tahoma", Font.BOLD, 12));
		envoyer.setForeground(Color.MAGENTA);
		envoyer.setBackground(Color.CYAN);
		envoyer.setBounds(445, 51, 85, 21);
		envoyer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int XD = Integer.parseInt(xd.getText());
				int YD = Integer.parseInt(textField.getText());
				int XF = Integer.parseInt(xf.getText());
				int YF = Integer.parseInt(yf.getText());
				Graphics g= Centre_panel.getGraphics();
				
				g.setColor(Color.WHITE);
				g.drawLine(0, 240, 740, 240);
				g.drawLine(320, 0, 320, 480);
				if(boton_BR.isSelected()){  
                 //String a="+ Tra\\u00E7age du premiere octant\\r\\n\\r\\n\\r\\n";
                 //String b="+ Algorithme de PREZENHAM";
                // methode("abdo","guartet");
				LineBres(XD ,YD, XF, YF, g);
			}else if(botton_go.isSelected() ) {
				
				 ligne_poly(XD ,YD, XF, YF, g);
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
          /*private void methode(String a,String b) {
            	
        	  JLabel lblNewLabel_1 = new JLabel(a);
      		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
      		lblNewLabel_1.setForeground(new Color(160, 82, 45));
      		lblNewLabel_1.setBounds(559, 10, 233, 28);
      		yd.add(lblNewLabel_1);
      		
      		JLabel lblNewLabel_2 = new JLabel(b);
      		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
      		lblNewLabel_2.setForeground(new Color(160, 82, 45));
      		lblNewLabel_2.setBounds(559, 48, 219, 23);
      		yd.add(lblNewLabel_2);
      		
            }*/
			private void LineBres(int XD, int YD, int XF, int YF, Graphics g) {
				// TODO Auto-generated method stub
				int s ;
		        int x,y,i,dx,dy, x1, x2;

			x=XD;
			y=YD;
			dx =Math.abs(XF-XD);
			dy=Math.abs(YF-YD);
			s=2*YD-XD;
			i=1;
			
		if(dx>= dy){
		 //premier octatnt
		    if(dx>0){
			
			while (i<dx){
				if(s>0){
					x=x+1;
					y=y+1;
					s=s+2*(dy-dx);
					
				}
				else{
					x=x+1;
					s=s+2*dy;
					
				}
				x1=x+320;
				x2=240-y;
				g.drawString(".", x1, x2);
				i+=1;
			}
		  }else{
		     while (i>dx){
		     		if(s>0){
					x=x-1;
					y=y+1;
					s=s+2*(dy-dx);
					
				}
				else{
					x=x-1;
					s=s+2*dy;
					
				}
		     		x1=x+320;
					x2=240-y;
					g.drawString(".", x1, x2);
				i-=1;
		     }
		     }	
			}
		//deuxieme octont
		else{
			 
			 // 2eme octatnt
			 
			     if(dy>0){
				
				
				
				while (i<dy){
					if(s>0){
						x=x+1;
						y=y+1;
						s=s+2*(dx-dy);
						
					}
					else{
						y=y+1;
						s=s+2*dy;
						
					}
					x1=x+320;
					x2=240-y;
					g.drawString(".", x1, x2);
					i+=1;
				}
			  }else{
			     while (i>dy){
			     		if(s>0){
						x=x+1;
						y=y-1;
						s=s+2*(dx-dy);
						
					}
					else{
						y=y-1;
						s=s+2*dx;
						
					}
			     		x1=x+320;
						x2=240-y;
						g.drawString(".", x1, x2);
					
					i-=1;
				 }
			     	
			     	
			    }	
			  } 

		     	
			}
			///polynomiale
			private void ligne_poly(int xd ,int yd , int xf , int yf , Graphics g){

				   float pente,bi;
				   int   Dx = xf-xd;
				   int  Dy = yf-yd ;

				    int x , y,x1, x2 ;
				     int P_incrX = (xd >= xf )? -1 :1 ;
				     int P_incrY = (yf >=yd )? -1 :1 ;

				    if ( Dx >= Dy){
				        pente= (float)Dy/Dx;
				        bi = yd-xd*pente;

				         for(x = xd+P_incrX ; x!=xf ; x = x+P_incrX  ){

				            y = Math.round(pente*x +bi );
				            x1=x+320;
							x2=240-y;
				            g.drawString(".", x1, x2);
				            
				         }

				    } else{
				        pente= (float)Dy/Dx;
				        bi = yd-xd*pente;

				        for(y = yd+P_incrY ; y!=yf ; y = y+P_incrX  ){
				             x = Math.round(pente*y +bi) ;
				             x1=x+320;
							x2=240-y;
				             g.drawString(".", x1, x2);
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
	/*private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}*/

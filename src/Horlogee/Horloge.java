package Horlogee;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalTime;

import javax.swing.JFrame;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import menu.menu_choix;

public class Horloge extends JFrame {
	
	
	
	

	private JPanel yd;
	private JTextField xd;
	JPanel Centre_panel = new JPanel();
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JFrame frame;
	private int h=220;
	private static int w=320;
	private static int R=180;
	//private double PI=3.14;
	double r;
	private static int i=0;
	
	int x1, y1, x2, y2;
	/**
	 * Launch the application.
*/
		
	/**
	 * Create the frame.
	 */
	public Horloge() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//b.setSize(300, 300);
		
		setBounds(100, 100, 816, 606);
		yd = new JPanel();
		yd.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(yd);
		yd.setLayout(null);
		
		
		
		
		Centre_panel.setBackground(Color.WHITE);
		Centre_panel.setBounds(20, 81, 772, 478);
		yd.add(Centre_panel);
		
		
		JButton envoyer = new JButton("Envoyer");
		envoyer.setForeground(Color.MAGENTA);
		envoyer.setBackground(Color.CYAN);
		envoyer.setBounds(445, 51, 85, 21);
		envoyer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				Graphics g= Centre_panel.getGraphics();
				
				
				
					
					Horloge( g);
			
			
			}
			public void pixel(int x1,int x2,Graphics g) {
				x1=x1+320;
				x2=240-x2;
				g.setColor(Color.black);
				g.drawString(".", x1, x2);
			
			}
			
			private void cercle_Bres(int r, int h, int k, Graphics g) {
				// TODO Auto-generated method stub
				int  x = 0 ;
				   int y = r ;

				   int S = 3 - 2*r ;
				   int i = 1;

				   while ( x < y){
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
			void Horloge(Graphics g) {
			    double alpha,teta, gama;
			    LocalTime localTime = LocalTime.now();
			    gama = localTime.getHour()*30 ;
				alpha = localTime.getMinute()*6;
				teta = localTime.getSecond()*6 ;
				
				int i= (localTime.getSecond()*6 ) + (60 - localTime.getSecond()) * 6;
				int j= (localTime.getMinute()*6 ) + (60 - localTime.getMinute()) * 6;
			    int x,y,x1,y1,x2,y2;
			  
			    g.setColor(Color.red);
			    cercle_Bres(R+10, 0, 20,g);
			    nombre(g);

			    while(true) {
			    	 

			       //g.setColor(Color.red);
			    	
					   	   
					
			      
				   	    
			   	   x=(int)((R-20)*Math.sin(Math.toRadians(teta)));
			   	   y=(int)((R-20)*Math.cos(Math.toRadians(teta)));

			   	   
			   	   x1=(int)((R-40)*(Math.sin(Math.toRadians(alpha))));
			   	   y1=(int)((R-40)*Math.cos(Math.toRadians(alpha)));
			   	   
			   	
			   	   x2=(int)((R-50)*Math.sin(Math.toRadians(gama)));
			   	   y2=(int)((R-50)*Math.cos(Math.toRadians(gama)));

			   	 
			   	    g.setColor(Color.red);
			   	    g.drawLine(w,h, w+x, h-y);
			     	g.setColor(Color.BLUE);
				   	g.drawLine(w,h, x1+w, h-y1);
				    g.setColor(Color.orange);
				    g.drawLine(w,h, x2+w, h-y2);
				   	
			   	  

			   	  
				   
			   	   
			   	 try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
			    	
			    	 teta+= 6;
					   	if (teta == i) {
							i += 360;
					   	   alpha+= 6;}
					   	if (alpha == j) {
							j += 360;
				   	       gama+=30;
					   	}
				   		g.setColor(Color.white);
				   	    g.drawLine(w,h, x+w, h-y);
				   	    g.drawLine(w,h, x1+w, h-y1);
				   	    g.drawLine(w,h, x2+w, h-y2);
			   	
			   
			    
			    }}
			private void dessi_string(int x2,int y2,int theta ,double r) {
				r = Math.toRadians(theta);
				//x1 = (int) (180 * Math.cos(r));
				//y1 = (int) (180 * Math.sin(r));
				x2 = (int) (160 * Math.cos(r));
				y2 = (int) (160 * Math.sin(r));
			}
			 void nombre(Graphics g) {
				
			
				int theta ;
				String i ;
				 
					theta = 0;
					while (theta <= 360) {
						r = Math.toRadians(theta);
						x1 = (int) (180 * Math.cos(r));
						y1 = (int) (180 * Math.sin(r));
						x2 = (int) (170 * Math.cos(r));
						y2 = (int) (170 * Math.sin(r));
						g.drawLine(320 + x1, 220 - y1, 320 + x2, 220 - y2);
						g.setColor(Color.BLUE);
						theta += 6;
					}
					theta=0;
					while (theta <= 360) {
						r = Math.toRadians(theta);
						x1 = (int) (180 * Math.cos(r));
						y1 = (int) (180 * Math.sin(r));
						x2 = (int) (160 * Math.cos(r));
						y2 = (int) (160 * Math.sin(r));
						
						g.drawLine(320 + x1, 220 - y1, 320 + x2, 220 - y2);
						
						g.setColor(Color.black);
						
						theta += 30;

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

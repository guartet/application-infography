package courbes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import menu.menu_3D;
import menu.menu_choix;

public class courbe extends JFrame{
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

	
	public courbe() {
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
		comboBox.addItem("Premiere");
		comboBox.addItem("deuxiéme");
		
		comboBox.setBounds(40, 10, 95, 21);
		yd.add(comboBox);
		
		JButton envoyer = new JButton("Envoyer");
		envoyer.setFont(new Font("Tahoma", Font.BOLD, 12));
		envoyer.setForeground(Color.MAGENTA);
		envoyer.setBackground(Color.CYAN);
		envoyer.setBounds(464, 51, 85, 21);
		
		
		
			
			
		
		envoyer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				 Graphics g= Centre_panel.getGraphics();
					
					g.setColor(Color.WHITE);
					g.drawLine(320, 240, 840, 240);
					g.drawLine(320, 0, 320, 240);
					g.drawLine(320, 240, 0, 560);
					if(comboBox.getSelectedItem()=="Premiere"){ 
						//menu_chiox N=new menu_chiox();
						int x[] = {0,  40 , 160, 190, 300, 310 };
					    int y[] = {0,  150 , 130 , -40, -10 , 170} ;
					    g.setColor(Color.BLACK);
					    point2( g);
						Tracer_courbe(x,y, g);
						
					    g.setColor(Color.orange);	
						Tracer_courb(x,y, g);
						g.setColor(Color.red);
						point1( g);
							
							
						}else {
							int x[] = {0,  60 , 120, 160, 250, 250 };
						    int y[] = {0,  60 , 80 , 80, 40 , 0} ;
						    g.setColor(Color.BLACK);
						    point1( g);
						    g.setColor(Color.BLACK);
							Tracer_courb(x,y, g);
							
				    g.setColor(Color.orange);
					Tracer_courbe(x,y, g);
					g.setColor(Color.red);
					point2( g);
						}
				
				
				
					
				
					
			
			
				
			}
			
			
			private void pixel(int x1,int x2,Graphics g) {
				x1=x1+320;
				x2=240-x2;
				//g.setColor(Color.blue);
				
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
		  
				private int fact(int n) {
					int i, fact=1;
					
					for(i=1;i<=n;i++)
					  fact=fact*i;
					return fact;
				}
				private void point2(Graphics g) {
					
					g.drawString( "B0 ",320+0,240-0);
					  g.drawString( "B1 ",320+60,240-0);
					   g.drawString("B1 ",320+60,240-60 );
					   g.drawString("B2 ",320+120,240-80 );
					   g.drawString("B3 ",320+160,240- 80);
					   g.drawString("B4 ",320+250,240- 40);
					   g.drawString("B5 ",320+250,240-0 );
				}
private void point1(Graphics g) {
					
	//g.setColor(Color.red);
	   g.drawString( "B0 ",320+0,240-0);
	   g.drawString( "B1 ",320+60,240-0);
	   g.drawString("B1 ",320+40,240-150 );
	   g.drawString("B2 ",320+160,240-130 );
	   g.drawString("B3 ",320+190,240+ 40);
	   g.drawString("B4 ",320+300,240+ 10);
	   g.drawString("B5 ",320+310,240-170 );
				}
			private void Tracer_courbe(int x[],int y[],Graphics g){
				//g.setColor(Color.orange);
				 bresenham_line(0,0,60,60,g);
				  //bresenham_line(60,0,80,40,g);
				  bresenham_line(60,60,120,80,g);
				  bresenham_line(120,80,160,80,g);
				  bresenham_line(160,80,250,40,g);
				  bresenham_line(250,40,250,0,g);
				  
				  
				
				   
				   int j,r=0;
				   double t,xt=0,yt=0;
				   int n=6,m=6;

				   for (t = 0.0; t < 1.0; t += 0.0005){
                            /* for(j=0;j<6;j++) {
                            	  xt+= (fact(n)/fact(n-r)*fact(r))*Math.pow(1-t, m-1)*Math.pow(t,r)*x[r];
                            	  yt+= (fact(n)/fact(n-r)*fact(r))*Math.pow(1-t, m-1)*Math.pow(t,r)*y[r];                  
                            	  r++;
                            	  m--;
                            	  
                            	 
                             }*/
					    xt= ( Math.pow(1-t,6) * x[0] ) + ( 5*t*Math.pow (1-t,4)* x[1] ) +( 10*t*t*Math.pow(1-t,3)*x[2]) + ( 10*t*t*t*Math.pow(1-t,2)*x[3] ) + ( 5*t*t*t*t*Math.pow(1-t,1)*x[4] )    +Math.pow(t,5) *x[5]   ;
					      yt=( Math.pow(1-t,6) * y[0] ) + ( 5*t*Math.pow (1-t,4)* y[1] ) +( 10*t*t*Math.pow(1-t,3)*y[2]) + ( 10*t*t*t*Math.pow(1-t,2)*y[3] ) + ( 5*t*t*t*t*Math.pow(1-t,1)*y[4] )  +  Math.pow(t,5) *y[5]  ;
					    // //pixel (xt, yt, YELLOW);
					      g.setColor(Color.blue);
                             pixel((int)xt, (int)yt,g);
				    }
			}
			
			      
			private void Tracer_courb(int x[],int y[],Graphics g){
				//g.setColor(Color.orange);
				 bresenham_line(0,0,40,150,g);
				  bresenham_line(60,0,80,40,g);
				  bresenham_line(40,150,160,130,g);
				  bresenham_line(160,130,190,-40,g);
				  bresenham_line(190,-40,300,-10,g);
				  bresenham_line(300,-10,310,170,g);
				  
				  
				  
				  
				
				   
				   int j,r=0;
				   double t,xt=0,yt=0;
				   int n=6,m=6;

				   for (t = 0.0; t < 1.0; t += 0.0005){
                            /* for(j=0;j<6;j++) {
                            	  xt+= (fact(n)/fact(n-r)*fact(r))*Math.pow(1-t, m-1)*Math.pow(t,r)*x[r];
                            	  yt+= (fact(n)/fact(n-r)*fact(r))*Math.pow(1-t, m-1)*Math.pow(t,r)*y[r];                  
                            	  r++;
                            	  m--;
                            	  
                            	 
                             }*/
					    xt= ( Math.pow(1-t,6) * x[0] ) + ( 5*t*Math.pow (1-t,4)* x[1] ) +( 10*t*t*Math.pow(1-t,3)*x[2]) + ( 10*t*t*t*Math.pow(1-t,2)*x[3] ) + ( 5*t*t*t*t*Math.pow(1-t,1)*x[4] )    +Math.pow(t,5) *x[5]   ;
					      yt=( Math.pow(1-t,6) * y[0] ) + ( 5*t*Math.pow (1-t,4)* y[1] ) +( 10*t*t*Math.pow(1-t,3)*y[2]) + ( 10*t*t*t*Math.pow(1-t,2)*y[3] ) + ( 5*t*t*t*t*Math.pow(1-t,1)*y[4] )  +  Math.pow(t,5) *y[5]  ;
					    // //pixel (xt, yt, YELLOW);
					      g.setColor(Color.blue);
                             pixel((int)xt, (int)yt,g);
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
				menu_3D V=new menu_3D();
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

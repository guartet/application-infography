package cylindre;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import menu.menu_choix;

public class cylindre extends JFrame{

private JPanel yd;
private JTextField xd;
JPanel Centre_panel = new JPanel();

private final ButtonGroup buttonGroup = new ButtonGroup();
JFrame frame;
private static int y=240;
private static int x=320;

//private double PI=3.14;

/**
 * Launch the application.
*/
	
/**
 * Create the frame.
 */
public cylindre() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	
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
			
			g.setColor(Color.WHITE);
			g.drawLine(320, 240, 840, 240);
			g.drawLine(320, 0, 320, 240);
			g.drawLine(320, 240, 0, 560);
			
			Cylindre(g);
				
		
		
		}
		public void pixel(int x1,double d,Graphics g) {
			x1=x1+320;
			d=240-d;
			g.setColor(Color.black);
			g.drawString(".", x1, (int)d);
		
		}
		void ligne_octants_1_4_5_8(int xd, double d, int Dx, int Dy,Graphics g){
		    int pas_x = (Dx>0)?1:-1;
		    int pas_y = (Dy>0)?1:-1;
		    Dx = Math.abs(Dx);
		    Dy = Math.abs(Dy);
		    int s = 2*Dy-Dx;
		    int i = 1;

		    while (i <= Dx){
		        if (s >= 0){
		            xd+=pas_x;
		            d+=pas_y;
		            s += 2*(Dy-Dx);
		            pixel(xd, d,g);
		            i++;
		        }
		        else{
		            xd+=pas_x;
		            s += 2*Dy;
		            pixel(xd, d,g);
		            
		            i++;
		        }
		    }
		}
		void ligne_octants_2_3_6_7(int xd, double d, int Dx, int Dy,Graphics g){
		    int pas_x = (Dx>0)?1:-1;
		    int pas_y = (Dy>0)?1:-1;
		    Dx = Math.abs(Dx);
		    Dy = Math.abs(Dy);
		    int s = 2*Dx-Dy;
		    int i = 1;

		    while (i <= Dy){
		        if (s >= 0){
		            xd+=pas_x;
		            d+=pas_y;
		            s += 2*(Dx-Dy);
		            pixel(xd, d,g);
		            i++;
		        }
		        else{
		            d+=pas_y;
		            s += 2*Dx;
		            pixel(xd, d,g);
		            i++;
		        }
		    }
		}
		
		void bresenham_line(int xd, double d, int xf, double e,Graphics g){
		    int Dx = xf-xd;
		    int Dy = (int) (e-d);

		    if(Math.abs(Dx)>=Math.abs(Dy)){
		        ligne_octants_1_4_5_8(xd, d, Dx, Dy,g);
		    }
		    else{
		        ligne_octants_2_3_6_7(xd, d, Dx, Dy,g);
		    }

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
		
		
		 
		private void Produit_Cylindre(double [][]a,double [][]b,double [][]c){
			for(int i=0;i<480;i++){
			        for(int j=0;j<4;j++){
			                c[i][j]=0;
			            for(int k=0;k<4;k++){
			                c[i][j]+=a[i][k]*b[k][j];
			                }
			        }
			}
			}
			private void Cylindre(Graphics l){
			
			double w;
			double z;
			double[][] cyl=new double[480][4] ;
			double[][] cyl1=new double[480][4] ;
			double[][] cyl2=new double[480][4] ;
			
			double [][]cabinet={{1.0,0.0,0.0,0.0},
				                      {0.0,1.0,0.0,0.0},
									  {0.433012,0.250001,0.0,0.0},
									  {0.0,0.0,0.0,100.0}};
			int k=0;
			for(z=-240;z<240;z+=20){
					for(w=0;w<=2*Math.PI;w+=Math.PI/10){
					cyl[k][0]=100*Math.cos(w);
					cyl[k][1]=100*Math.sin(w);
					cyl[k][2]=z;
					cyl[k][3]=1;
							k++;
			     	}
				}
			double g;
			for(g=0.0;g<=Math.PI;g+=Math.PI/100){
				double	[][]mry={{Math.cos(g),0.0,Math.sin(g),0.0},
					                {0.0,1.0,0.0,0.0},
					                {Math.sin(g),0.0,Math.cos(g),0.0},
					                 {0.0,0.0,0.0,1.0}
							  };
			        Produit_Cylindre(cyl,mry,cyl1);
			        Produit_Cylindre(cyl1,cabinet,cyl2);
			        }

			for(int k1=0;k1<479;k1++){
			    //setcolor(RED);
				bresenham_line((int)cyl2[k1][0]+x,(int)y-cyl2[k1][1],(int)cyl2[k1+1][0]+x,(int)y-cyl2[k1+1][1],l);
			  }
			/*for(int k1=0;k1<479;k1++){
			    //pixel(cyl2[k][0],cyl2[k][1],10);
			   // setcolor(RED);
			    bresenham_line((int)cyl2[k1][0]+x,(int)y-cyl2[k1][1],(int)cyl2[k1+1][0]+x,(int)y-cyl2[k1+1][1],l);
			    for(int k11=0;k11<460;k11++){
			            pixel((int)cyl2[k11][0],cyl2[k11][1],l);
			            bresenham_line((int)cyl1[k11][0],(int)cyl1[k11][1],(int)cyl1[k11+1][0],(int)cyl1[k11+1][0],l);
			            bresenham_line((int)cyl2[k11][0],(int)cyl2[k11][1],(int)cyl2[k11+20][0],(int)cyl2[k11+20][1],l);

			    }
			 

		   
			}*/}
		
	
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


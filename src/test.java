import java.awt.Color;
import java.awt.Graphics;
import java.time.LocalTime;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class test extends JFrame implements Runnable {
	LocalTime localTime = LocalTime.now();
	int theta;
	int x1, y1, x2, y2;
	int i = (localTime.getSecond() + 270) + (60 - localTime.getSecond()) * 6;
	double r;
	double sectheta, mintheta, hrtheta;

	@Override
	public void run() {
		while (true) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			sectheta = sectheta + 6;
			if (sectheta == i) {
				i += 360;
				mintheta = mintheta + 6;

			}

			hrtheta = hrtheta + (30 / 3600);
			repaint();

		}
	}

	

	public void init() {
		LocalTime localTime = LocalTime.now();
		hrtheta = localTime.getHour() * 30 + 270;
		mintheta = localTime.getMinute() * 6 + 270;
		sectheta = localTime.getSecond() + 270;
//		hrtheta = 270;
//		mintheta = 270;
//		sectheta = 270;
		Thread th = new Thread(this);
		th.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		//g.drawOval(50, 50, 200, 200);
		theta = 0;

		while (theta <= 360) {
			r = Math.toRadians(theta);
			x1 = (int) (100 * Math.cos(r));
			y1 = (int) (100 * Math.sin(r));
			x2 = (int) (80 * Math.cos(r));
			y2 = (int) (80 * Math.sin(r));
			g.drawLine(150 + x1, 150 + y1, 150 + x2, 150 + y2);
			g.setColor(Color.RED);
			theta += 30;

		}
		theta = 0;
		while (theta <= 360) {
			r = Math.toRadians(theta);
			x1 = (int) (100 * Math.cos(r));
			y1 = (int) (100 * Math.sin(r));
			x2 = (int) (95 * Math.cos(r));
			y2 = (int) (95 * Math.sin(r));
			g.drawLine(150 + x1, 150 + y1, 150 + x2, 150 + y2);
			g.setColor(Color.BLUE);
			theta += 6;
		}

		g.drawLine(150, 150, 150 + (int) (80 * Math.cos(Math.toRadians(sectheta))),
				150 + (int) (80 * Math.sin(Math.toRadians(sectheta))));

		g.drawLine(150, 150, 150 + (int) (65 * Math.cos(Math.toRadians(mintheta))),
				150 + (int) (65 * Math.sin(Math.toRadians(mintheta))));
		g.drawLine(150, 150, 150 + (int) (55 * Math.cos(Math.toRadians(hrtheta))),
				150 + (int) (55 * Math.sin(Math.toRadians(hrtheta))));

	}

	public static void main(String[] args) {
		test b = new test();
		b.init();
		b.setSize(300, 300);
		b.setTitle("Horloge");
		b.setVisible(true);

	}

}

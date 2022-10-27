import java.time.LocalTime;

public class test2 {
	public static void main(String[] args) {
		double sectheta, mintheta, hrtheta;
		double r;
		int x1;
		int theta=0;

		LocalTime localTime = LocalTime.now();
		hrtheta = localTime.getHour() * 30+100 ;
		mintheta = localTime.getMinute() * 6+100 ;
		r = Math.toRadians(theta)+100;
		x1 = (int) (100 * Math.cos(r));
		sectheta = localTime.getSecond();
		System.out.println(sectheta  );
		System.out.println(mintheta  );
		System.out.println(hrtheta  );
		System.out.println(x1  );
	}
}

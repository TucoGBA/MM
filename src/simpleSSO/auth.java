package simpleSSO;
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Calendar;
import java.util.EventListener;

public class auth {

	public static void main(String[] args) {

		Runtime.getRuntime().addShutdownHook(new Thread());

		int time = 60;
		
				try {

					if (0 < args.length) { 
					try {
						time = Integer.parseInt( args[0] );	
					} catch (NumberFormatException e) {
						System.out.print(e.toString());
						return;
					}
					
					
					}
					
					Calendar c = Calendar.getInstance();
					Calendar d = (Calendar) c.clone();
					d.add(Calendar.MINUTE, time);
					
					Robot r = new Robot();
					int x, y;

					System.out.println("Started at: " + c.getTime());
					System.out.println("Will be finished at: " + d.getTime());

					while (d.after(c)) {

						int delay = (int) (Math.random() * 5000);
						r.delay(delay + 25000);
						
						Point p = MouseInfo.getPointerInfo().getLocation();
						x = (int) p.x + 1;
						y = (int) p.y + 1;
						
						System.out.println(x + " " + y + " " + delay);
					
						r.mouseMove(x, y);

						c = Calendar.getInstance();
					}

					System.out.println("Ended at: " + c.getTime());

				} catch (AWTException e) {
					e.printStackTrace();
				}
			

	}
};

package de.martin_ueding.physik.ampel;

import java.util.LinkedList;
import java.util.Timer;

import javax.swing.JFrame;

public class Ampel {
	
	public static final double RED_TIME = 40.0;
	public static final double GREEN_TIME = 20.0;
	
	public static final double TIMER_PERIOD = 0.050;
	
	public static final double STRECKE = 100;
	
	public static double timeLeft = GREEN_TIME;
	public static boolean isGreen = true;
	
	static LinkedList<Car> cars;
	public static Anzeige anzeige;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		cars = new LinkedList<Car>();
		
		cars.add(new Racer());
		cars.add(new Schleicher());
		cars.add(new Ultraschleicher());
		cars.add(new Bremser());
		
		
		JFrame f = new JFrame("Traffic Light Simulator");
		f.setSize(800, 820);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		anzeige = new Anzeige();
		f.add(anzeige);
		f.setVisible(true);
		
		Timer timer = new Timer();
		timer.schedule(new CarMovingTask(), 200, (int)(TIMER_PERIOD*1000));

	}

}

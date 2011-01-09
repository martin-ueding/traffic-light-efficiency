package de.martin_ueding.physik.ampel;

import java.util.TimerTask;

public class CarMovingTask extends TimerTask {

	@Override
	public void run() {
		// Decrease the time left till next switch
		Ampel.timeLeft -= Ampel.TIMER_PERIOD;
		
		if (Ampel.timeLeft <= 0) {
			// Switch the light to the other state
			Ampel.isGreen = !Ampel.isGreen;
			Ampel.timeLeft = Ampel.isGreen ? Ampel.GREEN_TIME : Ampel.RED_TIME;
		}
		
		for (Car car : Ampel.cars) {
			car.move();
		}

		Ampel.anzeige.repaint();
	}

}

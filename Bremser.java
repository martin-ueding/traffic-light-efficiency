public class Bremser extends Car {
	
	public void move () {
		super.move();
		
		if (!Ampel.isGreen) {
			if (velocity*Ampel.timeLeft >= distanceToLight) {
				stopping = true;
				decelerate(1.0);
			}
		}
		else
			stopping = false;
		
		if (!stopping && velocity < Car.SPEED_LIMIT)
			accelerate(0.7);
	}

}

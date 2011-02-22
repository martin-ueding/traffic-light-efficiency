// Copyright (c) 2010 Martin Ueding <dev@martin-ueding.de>

public class Racer extends Car {
	
	public void move () {
		super.move();
		
		
		if (!Ampel.isGreen) {
			if (stopping || distanceToLight*MAX_DEC*2 * 0.95 < Math.pow(velocity, 2)) {
				decelerate(1.0);
				stopping = true;
			}
		}
		else
			stopping = false;
		
		if (!stopping && velocity < Car.SPEED_LIMIT)
			accelerate(1.0);
	}

}

// Copyright (c) 2010 Martin Ueding <dev@martin-ueding.de>

public class Ultraschleicher extends Car {
	
	public void move () {
		super.move();
		
		if (!Ampel.isGreen) {
			if (distanceToLight*MAX_DEC*2 * 0.98 < Math.pow(velocity, 2)) {
				stopping = true;
				decelerate(1.0);
			}
			else if (stopping || distanceToLight*MAX_DEC*2 * 0.3 * 0.98 < Math.pow(velocity, 2)) {
				stopping = true;
				decelerate(0.3);
			}
		}
		else
			stopping = false;
		
		if (!stopping && velocity < Car.SPEED_LIMIT)
			accelerate(0.2);
	}
}

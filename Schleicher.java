// Copyright (c) 2010 Martin Ueding <dev@martin-ueding.de>

public class Schleicher extends Car {
	
	public void move () {
		super.move();
		
		if (!Ampel.isGreen) {
			if (distanceToLight*MAX_DEC*2 * 0.97 < Math.pow(velocity, 2)) {
				stopping = true;
				decelerate(1.0);
			}
			else if (stopping || distanceToLight*MAX_DEC*2 * 0.6 * 0.97 < Math.pow(velocity, 2)) {
				stopping = true;
				decelerate(0.6);
			}
		}
		else
			stopping = false;
		
		if (!stopping && velocity < Car.SPEED_LIMIT)
			accelerate(0.3);
	}

}

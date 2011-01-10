public class Car {
	
	static final double MASS = 1000.0; // kg
	static final double MAX_ACC = 2.0; // m/s^2
	static final double MAX_DEC = 7.0; // m/s^2
	static final double SPEED_LIMIT = 14000.0; // m/s
	
	double energyUsed;	// energy needed for acceleration
	double velocity;	// angular velocity
	double phi, phi2;	// position in circle [0, 2 pi)
	
	double distanceToLight;
	double timeToLight;
	
	boolean stopping = false;
	
	public Car () {
		energyUsed = 0.0;
		velocity = 0.0;
		phi = 0.0;
	}
	
	void move () {
		
		// Move the car with current velocity and apply wrap at 2 pi.
		double omega = 2*Math.PI* velocity / (Ampel.STRECKE);
		phi += omega * Ampel.TIMER_PERIOD;
		phi2 += omega * Ampel.TIMER_PERIOD;
		while (phi >= 2*Math.PI) {
			phi -= 2*Math.PI;
			if (!Ampel.isGreen)
				System.out.println("Warnung: Car drove over red light!");
		}
		
		distanceToLight = (2*Math.PI-phi) / (2*Math.PI) * Ampel.STRECKE;
		timeToLight = distanceToLight / velocity;
	}
	
	/**
	 * This will accelerate the car for this cycle with a given percentage of
	 * the maximum power.
	 * @param percentage
	 */
	protected void accelerate (double percentage) {
		double velocity_new = velocity + MAX_ACC*Ampel.TIMER_PERIOD*percentage;
		if (velocity_new <= SPEED_LIMIT) {
			energyUsed += 0.5 * MASS * (Math.pow(velocity_new, 2) - Math.pow(velocity, 2));
			velocity = velocity_new;
		}
	}
	
	protected void decelerate (double percentage) {
		double velocity_new = velocity -= MAX_DEC*Ampel.TIMER_PERIOD*percentage;
		velocity = Math.max(velocity_new, 0.0);
	}

}

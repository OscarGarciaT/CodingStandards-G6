package maven;

public class Vacation {

	private String destination;
	private int numberOfTravelers;
	private int duration;
	private float cost;
	
	public Vacation(String destination, int numberOfTravelers, int duration) {
		this.cost = 1000;
		this.destination = destination;
		this.numberOfTravelers = numberOfTravelers;
		this.duration = duration;
	}
	
	public float getTotalCost() {
		float costoAdicional = 0;
		if((this.getDestination()).equals("Paris")) {
			costoAdicional = this.getCost() + 500;
		} else if((this.getDestination()).equals("New York City")){
			costoAdicional = this.getCost() + 600;
		}
		
		return costoAdicional;
	}
	
	public float getDiscount(int numberOfTravelers) {
		float discount = 0;
		if (4 < numberOfTravelers && numberOfTravelers < 10) {
			discount = (float) 0.10;
		}
		
		return discount;
		
	}
	
	public void applyDiscount(float discount) {
		this.setCost(this.getCost() * discount); 
	}
	
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getNumberOfTravelers() {
		return numberOfTravelers;
	}

	public void setNumberOfTravelers(int numberOfTravelers) {
		this.numberOfTravelers = numberOfTravelers;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public float getCost() {
		return cost;
	}

	public float setCost(float costAdditional) {
		return this.cost = costAdditional;
	}
}

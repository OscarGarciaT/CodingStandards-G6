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

	public float setCost(float cost) {
		return this.cost = cost;
	}
	
	public float getTotalForTrip() {
		float additionalPriceForDestination = Destinations.getAddPriceDestination(this.destination);
		float discountFromTravelers = getDiscountFromTravelers();
		float durationPrice = getDurationPrice();
		
		return (this.cost + additionalPriceForDestination + durationPrice) * discountFromTravelers ;
	}

	private float getDurationPrice() {
		float localDurationPrice = 0;
		if(lessOrEqualThanSevenDays()) {
			localDurationPrice = 200;
		} else if ( moreOrEqualThanThirtyDays() || this.numberOfTravelers == 2) {
			localDurationPrice = -200;
		}
		
		return localDurationPrice;
	}
	
	private boolean lessOrEqualThanSevenDays() {
		return this.duration <= 7;
	}
	
	private boolean moreOrEqualThanThirtyDays() {
		return this.duration >= 30;
	}
	
	

	private float getDiscountFromTravelers() {
		float totalDiscount = 0;
		
		if (this.numberOfTravelers > 4 && this.numberOfTravelers < 10) {
			totalDiscount = 0.1f;
		} else if (this.numberOfTravelers >= 10) {
			totalDiscount = 0.2f;
		}
		
		return 1 - totalDiscount;
	}
	
	
}

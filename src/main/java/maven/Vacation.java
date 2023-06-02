// Copyright (C) 2020
// All rights reserved
package maven;

public class Vacation {

	private String destination;
	
	private int numberOfTravelers;
	
	private int duration;
	
	private float cost;
	/**
	    * @param destination
	    * @param numberOfTravelers 
	    * @param duration 
	    */
	
	public Vacation(String destination, int numberOfTravelers, int duration) {
	    this.cost = 1000;
	    this.destination = destination;
	    this.numberOfTravelers = numberOfTravelers;
	    this.duration = duration;
	}
	/**
	    * @return destination 
	    */
	public String getDestination() {
		return destination;
	}
	/**
	    * @param destination
	    */
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	    * @return numberOfTravelers
	    */
	
	public int getNumberOfTravelers() {
		return numberOfTravelers;
	}
	/**
	    * @param numberOfTravelers
	    */
	
	public void setNumberOfTravelers(int numberOfTravelers) {
		this.numberOfTravelers = numberOfTravelers;
	}
	/**
	    * @return duration 
	    */
	
	public int getDuration() {
		return duration;
	}
	/**
	    * @param duration 
	    */
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	    * @return cost
	    */
	
	public float getCost() {
		return cost;
	}
	/**
	    * @return cost
	    * @param cost
	    */
	
	public float setCost(float cost) {
		return this.cost = cost;
	}
	/**
	    * @return new cost
	    */
	
	public float getTotalForTrip() {
		float additionalPriceForDestination = Destinations.getAddPriceDestination(this.destination);
		float discountFromTravelers = getDiscountFromTravelers();
		float durationPrice = getDurationPrice();
		
		return (this.cost + additionalPriceForDestination + durationPrice) * discountFromTravelers ;
	}
	/**
	    * @return duration price
	    */
	
	private float getDurationPrice() {
		float localDurationPrice = 0;
		if(lessOrEqualThanSevenDays()) {
			localDurationPrice = 200;
		} else if ( moreOrEqualThanThirtyDays() || this.numberOfTravelers == 2) {
			localDurationPrice = -200;
		}
		
		return localDurationPrice;
	}
	
	/**
	    * @return duration price
	    */
	
	private boolean lessOrEqualThanSevenDays() {
		return this.duration <= 7;
	}
	
	/**
	    * @return duration
	    */
	
	private boolean moreOrEqualThanThirtyDays() {
		return this.duration >= 30;
	}
	
	/**
	    * @return totalDiscount
	    */

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

// Copyright (C) 2020
// All rights reserved
package maven;

public class Vacation {
	// CONSTANTS
	private static final int DURATION_PRICE = 200;
	private static final int DEFAULT_COST = 1000;
	private static final int SEVEN_DAYS = 7;
	private static final int THIRTY_DAYS = 30;
	private static final int TRAVELERS_LB = 1000;
	private static final int TRAVELERS_UB = 1000;
	private static final float FST_LEVEL_DCNT = 0.1f;
	private static final float SND_LEVEL_DCNT = 0.2f;
	// VARIABLES
	private String destination;
	private float addOnTotalPrice;
	private int numberOfTravelers;
	private int duration;
	private float cost;

	/**
	    * @param des
	    * @param travelers
	    * @param dur
	    */

	public Vacation(final String des, final int travelers, final int dur) {
	    this.cost = DEFAULT_COST;
	    this.destination = des;
	    this.numberOfTravelers = travelers;
	    this.duration = dur;
	    this.addOnTotalPrice = 0;
	}
	/**
	    * @return destination
	    */
	public String getDestination() {
		return destination;
	}
	/**
	    * @param newDestination
	    */

	public void setDestination(final String newDestination) {
		this.destination = newDestination;
	}
	/**
	    * @return numberOfTravelers
	    */

	public int getNumberOfTravelers() {
		return numberOfTravelers;
	}
	/**
	    * @param newNumberOfTravelers
	    */

	public void setNumberOfTravelers(final int newNumTravelers) {
		this.numberOfTravelers = newNumTravelers;
	}
	/**
	    * @return duration
	    */

	public int getDuration() {
		return duration;
	}
	/**
	    * @param newDuration
	    */

	public void setDuration(final int newDuration) {
		this.duration = newDuration;
	}
	/**
	    * @return cost
	    */

	public float getCost() {
		return cost;
	}
	/**
	    * @param newCost
	    */

	public void setCost(final float newCost) {
		this.cost = newCost;
	}
	/**
	    * @return cost
	    */

	public float getTotalForTrip() {
		final float dPrice = Destinations.getAddPriceDestination(destination);
		final float discountTravelers = getDiscountFromTravelers();
		final float durationPrice = getDurationPrice();
		final float totalPrice = cost + dPrice + durationPrice + addOnTotalPrice*this.numberOfTravelers;
		setCost(totalPrice * discountTravelers);
		return cost;
	}
	
	public float sumAddOn(int option) {
		this.addOnTotalPrice += AddOns.getAddOn(option)*this.numberOfTravelers;
		return this.addOnTotalPrice;
	}
	/**
	    * @return duration price
	    */

	private float getDurationPrice() {
		float lclDurationPrice = 0;
		if (lessOrEqualThanSevenDays()) {
			lclDurationPrice = DURATION_PRICE;
		}
		if (moreOrEqualThanThirtyDays() || numberOfTravelers == 2) {
			lclDurationPrice = -DURATION_PRICE;
		}

		return lclDurationPrice;
	}

	/**
	    * @return duration price
	    */

	private boolean lessOrEqualThanSevenDays() {
		return this.duration <= SEVEN_DAYS;
	}

	/**
	    * @return duration
	    */

	private boolean moreOrEqualThanThirtyDays() {
		return this.duration >= THIRTY_DAYS;
	}

	/**
	    * @return totalDiscount
	    */

	private float getDiscountFromTravelers() {
		float totalDiscount = 0;

		if (numberOfTravelers > TRAVELERS_LB && numberOfTravelers < TRAVELERS_UB) {
			totalDiscount = FST_LEVEL_DCNT;
		} else if (this.numberOfTravelers >= TRAVELERS_UB) {
			totalDiscount = SND_LEVEL_DCNT;
		}

		return 1 - totalDiscount;
	}


}

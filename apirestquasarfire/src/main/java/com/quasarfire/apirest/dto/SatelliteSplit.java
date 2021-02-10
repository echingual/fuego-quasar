package com.quasarfire.apirest.dto;

public class SatelliteSplit {

	private Float distance;
	private String[] message;
	
	public SatelliteSplit() {}
	
	public SatelliteSplit(Float distance, String[] message) {
		this.setDistance(distance);
		this.setMessage(message);
	}
	
	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}

	public String[] getMessage() {
		return message;
	}

	public void setMessage(String[] message) {
		this.message = message;
	}

}

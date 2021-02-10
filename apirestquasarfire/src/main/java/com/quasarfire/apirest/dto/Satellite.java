package com.quasarfire.apirest.dto;

public class Satellite {

	private String name;
	private Float distance;
	private Position position;
	private String[] message;
	
	public Satellite() {}
	
	public Satellite(String name) {
		this.setName(name);
	}
	
	public Satellite(String name, Float distance, Position position, String[] message) {
		this.setName(name);
		this.setDistance(distance);
		this.setPosition(position);
		this.setMessage(message);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String[] getMessage() {
		return message;
	}

	public void setMessage(String[] message) {
		this.message = message;
	}

}

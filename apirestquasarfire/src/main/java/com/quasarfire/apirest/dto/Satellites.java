package com.quasarfire.apirest.dto;

import java.io.Serializable;

public class Satellites implements Serializable {
	
	private static final long serialVersionUID = -1962894995047646986L;
	private Satellite[] satellites;
	
	public Satellites() {}
	
	public Satellites(Satellite[] satellites) {
		this.satellites = satellites;
	}

	public Satellite[] getSatellites() {
		return satellites;
	}

	public void setSatellites(Satellite[] satellites) {
		this.satellites = satellites;
	}

}

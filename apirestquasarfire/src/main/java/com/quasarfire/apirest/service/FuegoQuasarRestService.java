package com.quasarfire.apirest.service;

import com.quasarfire.apirest.dto.Position;

public interface FuegoQuasarRestService {
	
	/**
	 * Metodo que devulve la posición x,y de la fuente
	 * @param distance1
	 * @param distance2
	 * @param distance3
	 * @return Position
	 */
	Position getLocation(Float distance1, Float distance2, Float distance3);
	
	/**
	 * Metodo que decifra el mensaje emitido por la fuente
	 * @param message1
	 * @param message2
	 * @param message3
	 * @return String
	 */
	String getMessage(String[] message1, String[] message2, String[] message3);

}

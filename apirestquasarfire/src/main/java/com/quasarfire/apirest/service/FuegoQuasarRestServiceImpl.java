package com.quasarfire.apirest.service;

import org.springframework.stereotype.Service;

import com.quasarfire.apirest.dto.Position;

@Service
public class FuegoQuasarRestServiceImpl implements FuegoQuasarRestService {

	@Override
	public Position getLocation(Float distance1, Float distance2, Float distance3) {
		Position position = new Position();
		Float x = (float) ((Math.pow(distance1, 2) - Math.pow(distance2, 2) + (360000))/(1200));
		Float y = (float) (((Math.pow(distance1, 2) - Math.pow(distance3, 2) + (1000000) + (90000))/(600)) - ((1000/300)*x));
		position.setX(x - 500);
		position.setY(y - 200);
		return position;
	}

	@Override
	public String getMessage(String[] message1, String[] message2, String[] message3) {
		String mensajeDec = "";
		int tam = 0;
		if (message1.length > message2.length && message1.length > message3.length) {
			tam = message1.length;
		} else if (message2.length > message3.length && message2.length > message1.length) {
			tam = message2.length;
		} else {
			tam = message3.length;
		}
		
		for (int i = 0;	i < tam; i++) {
			if (!message1[i].equals("")) {
				mensajeDec = mensajeDec + message1[i] + " ";
			} else if (!message2[i].equals("")) {
				mensajeDec = mensajeDec + message2[i] + " ";
			} else if (!message3[i].equals("")) {
				mensajeDec = mensajeDec + message3[i] + " ";
			} else {
				mensajeDec = "No se puede determinar el mensaje";
				break;
			}
		}
		return mensajeDec;
	}

}

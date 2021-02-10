package com.quasarfire.apirest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.google.gson.Gson;
import com.quasarfire.apirest.dto.Position;
import com.quasarfire.apirest.dto.Satellite;
import com.quasarfire.apirest.dto.SatelliteSplit;
import com.quasarfire.apirest.dto.Satellites;
import com.quasarfire.apirest.dto.Source;
import com.quasarfire.apirest.service.FuegoQuasarRestService;


@RestController
@RequestMapping("/FuegoQuasar") //URL raiz, http://localhost:8080/FuegoQuasar
public class FuegoQuasarRestController {

	private Satellite kenobi;
	private Satellite skywalker;
	private Satellite sato;
	private boolean bkenobi = false;
	private boolean bskywalker = false;
	private boolean bsato = false;

	@Autowired
	private FuegoQuasarRestService fuegoQuasarRestService;

	@PostMapping("/topsecret/")
	public Source topsecret(@RequestBody String entrada) throws Exception {
		System.out.println(entrada);
		Gson gson = new Gson();
		Satellites satellites = gson.fromJson(entrada, Satellites.class);
		for (Satellite satT : satellites.getSatellites()) {
			setSatelite(satT);
		}
		String MensajeDes = fuegoQuasarRestService.getMessage(kenobi.getMessage(), skywalker.getMessage(), sato.getMessage());
		Position posFuente = fuegoQuasarRestService.getLocation(kenobi.getDistance(),skywalker.getDistance(),sato.getDistance());
		if(!MensajeDes.equals("No se puede determinar el mensaje")) {
			Source fuente = new Source();
			fuente.setMessage(MensajeDes);
			fuente.setPosition(posFuente);
			return fuente;		
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puede determinar el mensaje");
	}
	
	@PostMapping("/topsecret_split/{satellite}")
	public Source topsecretSplit(@PathVariable String satellite, @RequestBody String entrada) {
		System.out.println(entrada);
		Gson gson = new Gson();
		SatelliteSplit satSplit = gson.fromJson(entrada, SatelliteSplit.class);
		if (satellite.equals("kenobi")) {
			setSatelite(new Satellite("kenobi"));
			this.kenobi.setDistance(satSplit.getDistance());
			this.kenobi.setMessage(satSplit.getMessage());
			bkenobi = true;
		} else if (satellite.equals("skywalker")) {
			setSatelite(new Satellite("skywalker"));
			this.skywalker.setDistance(satSplit.getDistance());
			this.skywalker.setMessage(satSplit.getMessage());
			bskywalker = true;
		} else {
			setSatelite(new Satellite("sato"));
			this.sato.setDistance(satSplit.getDistance());
			this.sato.setMessage(satSplit.getMessage());
			bsato = true;
		}
		
		if (bkenobi && bskywalker && bsato) {
			String MensajeDes = fuegoQuasarRestService.getMessage(kenobi.getMessage(), skywalker.getMessage(), sato.getMessage());
			Position posFuente = fuegoQuasarRestService.getLocation(kenobi.getDistance(),skywalker.getDistance(),sato.getDistance());
			Source fuente = new Source();
			fuente.setMessage(MensajeDes);
			fuente.setPosition(posFuente);
			return fuente;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay suficiente información");
	}

	@GetMapping("/topsecret_split/{satellite}")
	public Source topsecretSplit2(@PathVariable String satellite) {
		try {
			if (satellite.equals("kenobi")||satellite.equals("skywalker")||satellite.equals("sato")) {
				String MensajeDes = fuegoQuasarRestService.getMessage(kenobi.getMessage(), skywalker.getMessage(), sato.getMessage());
				Position posFuente = fuegoQuasarRestService.getLocation(kenobi.getDistance(),skywalker.getDistance(),sato.getDistance());
				Source fuente = new Source();
				fuente.setMessage(MensajeDes);
				fuente.setPosition(posFuente);
				return fuente;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay suficiente información", e);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay suficiente información");
	}

	
	/**
	 * Metodo que Setea los satelites del json a objetos del sistema
	 * @param satelite
	 */
	public void setSatelite(Satellite satelite) {
		if("kenobi".equals(satelite.getName())) {
			this.kenobi = new Satellite("kenobi",satelite.getDistance(), new Position(new Float(-500),new Float(-200)),satelite.getMessage());
		} else if("skywalker".equals(satelite.getName())) {
			this.skywalker = new Satellite("skywalker",satelite.getDistance(), new Position(new Float(100),new Float(-100)),satelite.getMessage());
		} else if("sato".equals(satelite.getName())) {
			this.sato = new Satellite("sato",satelite.getDistance(), new Position(new Float(500),new Float(100)),satelite.getMessage());
		}
	}

}

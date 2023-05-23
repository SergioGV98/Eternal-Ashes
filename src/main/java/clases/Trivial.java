package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import enums.TipoPregunta;
import utils.Config;

public class Trivial {

	private ArrayList<Pregunta> preguntas;

	public Trivial(byte cantidadPreguntas) throws SQLException {
		this.preguntas = obtenerPreguntasSinRepetir(cantidadPreguntas);
	}
	
	public Trivial() throws SQLException {
		this.preguntas = new ArrayList<>();
		preguntas.add(generarPreguntaAleatoria());
	}

	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(ArrayList<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	

	private Pregunta generarPreguntaAleatoria() throws SQLException {
		TipoPregunta generoPregunta = obtenerGeneroPreguntaAleatorio();
		Pregunta pregunta = new Pregunta(generoPregunta);
		return pregunta;
	}

	private TipoPregunta obtenerGeneroPreguntaAleatorio() {
		Random random = new Random();
		int indiceAleatorio = random.nextInt(TipoPregunta.values().length);
		return TipoPregunta.values()[indiceAleatorio];
	}
	
	private ArrayList<Pregunta> obtenerPreguntasSinRepetir(byte cantidadPreguntas) throws SQLException{
		ArrayList<String> preguntasRepetidas = new ArrayList<String>();
		ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
		Pregunta nuevaPregunta;
		for (byte i = 0; i < cantidadPreguntas; i++) {
			nuevaPregunta = generarPreguntaAleatoria();
			if (!preguntasRepetidas.contains(nuevaPregunta.getEnunciado())) {
				preguntas.add(nuevaPregunta);
				preguntasRepetidas.add(nuevaPregunta.getEnunciado());
			} else {
				--i;
				if (Config.verboseMode) {
					System.out.println("Pregunta repetida");
				}
			}
			preguntasRepetidas.add(nuevaPregunta.getEnunciado());
		}
		if(Config.verboseMode) {
			System.out.println(preguntas.size());
		}
		return preguntas;
	}
	
	public ArrayList<String> respuestas(Trivial trivial) {
		Pregunta pregunta = trivial.getPreguntas().get(0);
		ArrayList<String> respuestas = new ArrayList<String>();
		Iterator<Map.Entry<String, Boolean>> it = pregunta.getRespuestas().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Boolean> entry = it.next();
			respuestas.add(entry.getKey());
		}
		return respuestas;
	}
	
	public String respuestaCorrecta(Trivial trivial) {
		Pregunta pregunta = trivial.getPreguntas().get(0);
		String respuestaCorrecta = null;
		Iterator<Map.Entry<String, Boolean>> it = pregunta.getRespuestas().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Boolean> entry = it.next();
			if (entry.getValue()) {
				return respuestaCorrecta =  entry.getKey();
			}
		}
		return respuestaCorrecta;
	}
	
	@Override
	public String toString() {
		return "Trivial [preguntas=" + preguntas;
	}

}

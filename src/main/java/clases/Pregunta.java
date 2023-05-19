package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Random;

import enums.TipoPregunta;
import utils.Config;
import utils.DAO;

public class Pregunta {

	private String enunciado;
	private TipoPregunta generoPregunta;
	private HashMap<String, Boolean> respuestas;

	public Pregunta(TipoPregunta genero) throws SQLException {
		this.respuestas = new HashMap<>();

		ArrayList<Object> pregunta = obtenerPregunta(genero);

		this.enunciado = (String) pregunta.get(0);

		if (pregunta.get(1).equals("Anime")) {
			this.generoPregunta = TipoPregunta.ANIME;
		} else if (pregunta.get(1).equals("Matemáticas")) {
			this.generoPregunta = TipoPregunta.MATEMATICAS;
		} else if (pregunta.get(1).equals("Juegos")) {
			this.generoPregunta = TipoPregunta.JUEGOS;
		}
		this.respuestas.put((String) pregunta.get(2), false);
		this.respuestas.put((String) pregunta.get(3), false);
		this.respuestas.put((String) pregunta.get(4), false);
		this.respuestas.put((String) pregunta.get(5), true);
	}

	public String getEnunciado() {
		return enunciado;
	}

	public TipoPregunta getGeneroPregunta() {
		return generoPregunta;
	}

	public HashMap<String, Boolean> getRespuestas() {
		return respuestas;
	}

	public ArrayList<Object> obtenerPregunta(TipoPregunta tipo) throws SQLException {
		ArrayList<Object> pregunta;
		HashMap<String, Object> restricciones = new HashMap<String, Object>();
		if (tipo == TipoPregunta.ANIME) {
			restricciones.put("genero", "Anime");
		} else if (tipo == TipoPregunta.MATEMATICAS) {
			restricciones.put("genero", "Matemáticas");
		} else if(tipo == TipoPregunta.MATEMATICAS) {
			restricciones.put("genero", "Juegos");
		}
		LinkedHashSet<String> consulta = new LinkedHashSet<String>();
		consulta.add("enunciado");
		consulta.add("genero");
		consulta.add("respuestaincorrecta1");
		consulta.add("respuestaincorrecta2");
		consulta.add("respuestaincorrecta3");
		consulta.add("respuestacorrecta");
		pregunta = DAO.consultar("preguntas", restricciones, consulta);

		if (!pregunta.isEmpty()) {
			Random r = new Random();
			int indiceAleatorio = r.nextInt(pregunta.size() / 6) * 6;
			ArrayList<Object> preguntaAleatoria = new ArrayList<>(
					pregunta.subList(indiceAleatorio, indiceAleatorio + 6));
			if(Config.verboseMode) {
				System.out.println(preguntaAleatoria);
			}
			return preguntaAleatoria;
		} else {
			return null; 
		}
	}

	@Override
	public String toString() {
		return "\nEnunciado=" + enunciado + "\nGeneroPregunta=" + generoPregunta + "\nRespuestas=" + respuestas + "\n";
	}

}

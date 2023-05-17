package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Random;

import enums.TipoPregunta;
import utils.DAO;

public class Pregunta {

	private String enunciado;
	private TipoPregunta generoPregunta;
	private HashMap <String, Boolean> respuestas;
	
	public Pregunta(TipoPregunta genero) throws SQLException {
        this.respuestas = new HashMap<>();

        ArrayList<Object> pregunta = obtenerPregunta(genero);
        
        this.enunciado = (String) pregunta.get(0);
        
        if(pregunta.get(1).equals("Anime")) {
        	this.generoPregunta = TipoPregunta.ANIME;
        }
        
        // Agregar las respuestas incorrectas al HashMap
        this.respuestas.put((String) pregunta.get(2), false);
        this.respuestas.put((String) pregunta.get(3), false);
        this.respuestas.put((String) pregunta.get(4), false);

        // Agregar la respuesta correcta al HashMap
        this.respuestas.put((String) pregunta.get(5), true);
    }
	
	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public TipoPregunta getGeneroPregunta() {
		return generoPregunta;
	}

	public void setGeneroPregunta(TipoPregunta generoPregunta) {
		this.generoPregunta = generoPregunta;
	}

	public HashMap<String, Boolean> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(HashMap<String, Boolean> respuestas) {
		this.respuestas = respuestas;
	}

	public ArrayList<Object> obtenerPregunta(TipoPregunta tipo) throws SQLException{
		ArrayList<Object> pregunta;
		HashMap<String, Object> restricciones = new HashMap<String, Object>();
		if(tipo == TipoPregunta.ANIME) {
			restricciones.put("genero", "Anime");
		}
		LinkedHashSet<String> consulta = new LinkedHashSet<String>();
		consulta.add("enunciado");
		consulta.add("genero");
		consulta.add("respuestaincorrecta1");
		consulta.add("respuestaincorrecta2");
		consulta.add("respuestaincorrecta3");
		consulta.add("respuestacorrecta");
		pregunta = DAO.consultar("preguntas", restricciones, consulta);
		Random r = new Random();
		byte cuenta = 0;
		for(short i = 0; i < pregunta.size(); i += 6) {
			++cuenta;
			System.out.println(cuenta);
		}
		r.nextInt(0, pregunta.size());
		System.out.println(pregunta.size());
		return pregunta;
	}
	
}

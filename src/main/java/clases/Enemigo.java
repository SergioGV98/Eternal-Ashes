package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import utils.Config;

public class Enemigo extends ElementoVivo {

	private short ataque;
	private Trivial trivial;
	private Botin botin;

	public Enemigo(String nombre, short vida, short ataque, Trivial trivial) throws SQLException {
		super(nombre, vida);
		this.ataque = ataque;

		Scanner sc = new Scanner(System.in);
		while (vida >= 0) {
			trivial = new Trivial();
			Pregunta pregunta = trivial.getPreguntas().get(0);
			ArrayList<String> respuestas = new ArrayList<String>();
			byte eleccion = 0;
			String respuestaCorrecta = null;
			Iterator<Map.Entry<String, Boolean>> it = pregunta.getRespuestas().entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, Boolean> entry = it.next();
				respuestas.add(entry.getKey());
				if (entry.getValue()) {
					respuestaCorrecta = entry.getKey();
				}
			}

			if (Config.verboseMode) {
				System.out.println(respuestas.get(0));
				System.out.println(respuestas.get(1));
				System.out.println(respuestas.get(2));
				System.out.println(respuestas.get(3));
			}

			eleccion = Byte.parseByte(sc.nextLine());
			if (respuestaCorrecta.equals(respuestas.get(eleccion - 1))) {
				if (Config.verboseMode) {
					System.out.println("¡Respuesta correcta!");
				}

			} else {
				if (Config.verboseMode) {
					System.out.println("¡Respuesta incorrecta!");
				}
			}
		}
	}
	
	public Enemigo(String nombre, short vida, short ataque, Trivial trivial, Botin botin) throws SQLException {
		super(nombre, vida);
		this.ataque = ataque;

		Scanner sc = new Scanner(System.in);
		while (vida >= 0) {
			trivial = new Trivial();
			Pregunta pregunta = trivial.getPreguntas().get(0);
			ArrayList<String> respuestas = new ArrayList<String>();
			byte eleccion = 0;
			String respuestaCorrecta = null;
			Iterator<Map.Entry<String, Boolean>> it = pregunta.getRespuestas().entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, Boolean> entry = it.next();
				respuestas.add(entry.getKey());
				if (entry.getValue()) {
					respuestaCorrecta = entry.getKey();
				}
			}

			if (Config.verboseMode) {
				System.out.println(respuestas.get(0));
				System.out.println(respuestas.get(1));
				System.out.println(respuestas.get(2));
				System.out.println(respuestas.get(3));
			}

			eleccion = Byte.parseByte(sc.nextLine());
			if (respuestaCorrecta.equals(respuestas.get(eleccion - 1))) {
				if (Config.verboseMode) {
					System.out.println("¡Respuesta correcta!");
				}

			} else {
				if (Config.verboseMode) {
					System.out.println("¡Respuesta incorrecta!");
				}
			}
		}
		//Asignarle el botin al jugador.
	}

	public short getAtaque() {
		return ataque;
	}

	public void setAtaque(short ataque) {
		this.ataque = ataque;
	}

	public Trivial getTrivial() {
		return trivial;
	}

	public void setTrivial(Trivial trivial) {
		this.trivial = trivial;
	}

	public Botin getBotin() {
		return botin;
	}

	public void setBotin(Botin botin) {
		this.botin = botin;
	}

	@Override
	public String toString() {
		return "Enemigo [ataque=" + ataque + ", trivial=" + trivial + ", botin=" + botin + "]";
	}

}

package main;

import java.sql.SQLException;

import clases.Arma;
import clases.Enemigo;
import clases.Jugador;
import clases.Pregunta;
import clases.Trivial;
import enums.TipoPregunta;
import exceptions.NombreConNumeroException;
import exceptions.NombreLargoException;
import exceptions.NombreVacioException;
import interfaces.GeneralWindow;

public class Main {

	public static void main(String[] args) {
		GeneralWindow w = new GeneralWindow();
		/*try {
			Trivial trivial = new Trivial((byte) 5);
			System.out.println(trivial);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		/*try {
			Trivial trivial = new Trivial();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try {
			Arma arma = new Arma("Vi", 5);
			Jugador jugador = null;
			try {
				jugador = new Jugador("Paco", (short) 1000, arma);
			} catch (NombreConNumeroException | NombreLargoException | NombreVacioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Trivial trivial = new Trivial();
			Enemigo enemigo = new Enemigo("Paco", (short) 1000, (short) 5, trivial, jugador);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}

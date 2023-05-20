package main;

import java.sql.SQLException;

import clases.Enemigo;
import clases.Pregunta;
import clases.Trivial;
import enums.TipoPregunta;
import interfaces.GeneralWindow;

public class Main {

	public static void main(String[] args) {
		//GeneralWindow w = new GeneralWindow();
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
		try {
			Trivial trivial = new Trivial();
			Enemigo enemigo = new Enemigo("Paco", (short) 100, (short) 5, trivial);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

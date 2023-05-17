package main;

import java.sql.SQLException;

import clases.Pregunta;
import enums.TipoPregunta;
import interfaces.GeneralWindow;

public class Main {

	public static void main(String[] args) {
		GeneralWindow w = new GeneralWindow();
		try {
			Pregunta pregunta = new Pregunta(TipoPregunta.ANIME);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

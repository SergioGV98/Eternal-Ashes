package clases;

import exceptions.NombreConNumeroException;
import exceptions.NombreLargoException;

public class Jugador extends ElementoVivo{
	
	private Arma arma;

	public Jugador(String nombre, short vida, Arma arma) throws NombreConNumeroException, NombreLargoException {
		super(nombre, vida);
		this.arma = arma;
		this.setNombre(nombre);
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	@Override
	public String toString() {
		return "Arma=" + arma;
	}

}

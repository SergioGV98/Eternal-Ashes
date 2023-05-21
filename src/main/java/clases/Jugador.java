package clases;

import exceptions.NombreConNumeroException;
import exceptions.NombreLargoException;
import exceptions.NombreVacioException;

public class Jugador extends ElementoVivo{
	
	private Arma arma;

	public Jugador(String nombre, short vida, Arma arma) throws NombreConNumeroException, NombreLargoException, NombreVacioException {
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
	
	public boolean jugadorVivo() {
		if(this.getVida() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void restarVidaJugador(Enemigo enemigo) {
		this.setVida((short) (this.getVida() - enemigo.getAtaque()));
	}
	
	@Override
	public String toString() {
		return "Arma=" + arma;
	}
	
}

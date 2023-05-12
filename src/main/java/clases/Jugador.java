package clases;

public class Jugador extends ElementoVivo{
	
	private Arma arma;

	public Jugador(String nombre, short vida, Arma arma) {
		super(nombre, vida);
		this.arma = arma;
	}
	
	

}

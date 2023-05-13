package clases;

public class Jugador extends ElementoVivo{
	
	private Arma arma;

	public Jugador(String nombre, short vida, Arma arma) {
		super(nombre, vida);
		this.arma = arma;
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

package clases;

public class Arma extends ElementoConNombre{
	
	private int daño;

	public Arma(String nombre, int daño)  {
		super(nombre);
		this.daño = daño;
	}

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	@Override
	public String toString() {
		return "Arma [daño=" + daño + "]";
	}
	
	
}

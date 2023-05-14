package clases;

public class ElementoVivo extends ElementoConNombre{
	
	private short vida;

	public ElementoVivo(String nombre, short vida) {
		super(nombre);
		this.vida = vida;
	}

	public short getVida() {
		return vida;
	}

	public void setVida(short vida) {
		this.vida = vida;
	}

	@Override
	public String toString() {
		return "Vida=" + vida ;
	}
	
}

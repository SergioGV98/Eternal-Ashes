package clases;

import exceptions.NombreConNumeroException;
import exceptions.NombreLargoException;
import exceptions.NombreVacioException;

public class ElementoConNombre {

	private String nombre;

	public ElementoConNombre(String nombre){
		super();
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws NombreConNumeroException, NombreLargoException, NombreVacioException {
		String numeros = "1234567890";
		for(byte i = 0; i < nombre.length(); i++) {
			if(numeros.contains("" + nombre.charAt(i))) {
				throw new NombreConNumeroException ("El nombre no puede contener numeros");
			}
		}
		
		if(nombre.length() == 0) {
			throw new NombreVacioException("El nombre no puede ser una cadena vacia");
		}
		
		if(nombre.length() > 15) {
			throw new NombreLargoException("El nombre es demasiado largo");
		}
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Nombre= " + nombre;
	}
	
	
}

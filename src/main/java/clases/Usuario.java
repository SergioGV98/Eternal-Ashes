package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import exceptions.ContraseñaInvalidaException;
import exceptions.UsuarioNoExisteExceptions;
import utils.DAO;

public class Usuario {
	
	private String usuario;
	private String email;
	private String contraseña;
	
	public Usuario(String usuario, String email, String contraseña) throws SQLException {
		HashMap<String, Object> insertar = new HashMap<String, Object>();
		insertar.put("usuario", this.usuario = usuario);
		insertar.put("email", this.email = email);
		insertar.put("contraseña", this.contraseña = contraseña);
		DAO.insertar("usuarios", insertar);
	}

	public Usuario(String usuario, String contraseña) throws SQLException, UsuarioNoExisteExceptions, ContraseñaInvalidaException {
		LinkedHashSet<String> consulta = new LinkedHashSet<String>();
		this.usuario = usuario;
		this.contraseña = contraseña;
		consulta.add("usuario");
		consulta.add("contraseña");
		HashMap<String, Object> restricciones = new HashMap<String, Object>();
		restricciones.put("usuario", usuario);
		restricciones.put("contraseña", contraseña);
		ArrayList<Object> informacion = DAO.consultar("usuarios", restricciones, consulta);
		System.out.println(informacion);
		if (informacion.isEmpty()) {
			throw new UsuarioNoExisteExceptions("El usuario no existe en la base de datos.");
		} else if (!informacion.get(1).equals(contraseña)) {
			throw new ContraseñaInvalidaException("La contraseña proporcionada no es valida.");
		}
	}
	
	public String getUsuario() {
		return usuario;
	}

	public String getEmail() {
		return email;
	}

	public String getContraseña() {
		return contraseña;
	}

	@Override
	public String toString() {
		return "Usuario=" + usuario + "\nEmail=" + email + "\nContraseña=" + contraseña;
	}
	
}

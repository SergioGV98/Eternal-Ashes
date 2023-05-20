package clases;

import java.sql.SQLException;

public class Botin {

	private Trivial trivial;
	private Arma recompensa;
	
	public Botin(Arma recompensa) throws SQLException {
		super();
		Trivial trivial = new Trivial((byte) 5);
		this.trivial = trivial;
		this.recompensa = recompensa;
	}

	public Trivial getTrivial() {
		return trivial;
	}

	public void setTrivial(Trivial trivial) {
		this.trivial = trivial;
	}

	public Arma getRecompensa() {
		return recompensa;
	}

	public void setRecompensa(Arma recompensa) {
		this.recompensa = recompensa;
	}

	@Override
	public String toString() {
		return "Botin [trivial=" + trivial + ", recompensa=" + recompensa + "]";
	}
	
}

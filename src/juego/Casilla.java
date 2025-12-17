package juego;

public class Casilla {
	private boolean mina;
	private boolean blanco;
	private boolean bandera;
	private boolean visible;
	private int numero;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isMina() {
		return mina;
	}

	public void setMina(boolean mina) {
		this.mina = mina;
	}

	public boolean isBlanco() {
		return blanco;
	}

	public void setBlanco(boolean blanco) {
		this.blanco = blanco;
	}

	public boolean isBandera() {
		return bandera;
	}

	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}

	// Mostrar únicamente el símbolo correspondiente según la lógica de la casilla

	public String toString() {
		return "Casilla [mina=" + mina + ", blanco=" + blanco + ", bandera=" + bandera + ", visible=" + visible
				+ ", numero=" + numero + "]";
	}
}

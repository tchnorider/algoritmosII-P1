package estructuraAB;

public class Nodo {

	private int dato;
	public Nodo nodoDer;
	public Nodo nodoIzq;

	public Nodo() {

	}

	public Nodo(int d) {
		this.dato = d;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}
}

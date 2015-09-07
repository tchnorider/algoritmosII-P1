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

	public void insertarHijo(int d) {
		Nodo neo = new Nodo(d);
		if (this.nodoIzq == null) {
			this.nodoIzq = neo;
		} else if (this.nodoDer == null) {
			this.nodoDer = neo;
		}
	}
}

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

	public void insertarHijo(Integer hijo) {
		if (this.nodoIzq == null) {
			this.nodoIzq = new Nodo(hijo);
		} else {
			insertarHijo(this.nodoIzq, hijo);
		}
	}

	private void insertarHijo(Nodo nodo, Integer hijo) {
		if (nodo.nodoIzq == null) {
			nodo.nodoIzq = new Nodo(hijo);
		} else {
			insertarHijo(nodo.nodoIzq, hijo);
		}
	}
}

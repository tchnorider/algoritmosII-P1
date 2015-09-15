package estructuraAB;

public class Nodo {

	private Integer dato;
	public Nodo nodoDer;
	public Nodo nodoIzq;

	public Nodo() {

	}

	public Nodo(int d) {
		this.dato = d;
	}

	public Integer getDato() {
		return dato;
	}

	public void setDato(Integer dato) {
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

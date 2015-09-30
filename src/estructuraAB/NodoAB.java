package estructuraAB;

public class NodoAB {

	private Integer dato;
	public NodoAB nodoDer;
	public NodoAB nodoIzq;

	public NodoAB() {

	}

	public NodoAB(int d) {
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
			this.nodoIzq = new NodoAB(hijo);
		} else {
			insertarHijo(this.nodoIzq, hijo);
		}
	}

	private void insertarHijo(NodoAB nodo, Integer hijo) {
		if (nodo.nodoIzq == null) {
			nodo.nodoIzq = new NodoAB(hijo);
		} else {
			insertarHijo(nodo.nodoIzq, hijo);
		}
	}
}

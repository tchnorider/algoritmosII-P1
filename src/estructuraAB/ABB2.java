package estructuraAB;

public class ABB2 {

	private Nodo raiz;

	public ABB2() {
		this.raiz = null;
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	// Ejercicio 3 - a
	public void insertar(Integer x) {
		Nodo nuevoNodo = new Nodo(x);
		if (this.raiz == null) {
			this.raiz = nuevoNodo;
		} else {
			insertar(nuevoNodo, this.raiz);
		}
	}

	private void insertar(Nodo nuevoNodo, Nodo n) {
		if (n == null) {
			n = nuevoNodo;
		} else if (n.getDato() > nuevoNodo.getDato()) {
			insertar(nuevoNodo, n.nodoIzq);
		} else {
			insertar(nuevoNodo, n.nodoDer);
		}
	}

	// Ejercicio 3 - b
	public void borrarMinimo() {
		if (this.raiz == null) {
			return;
		}
		borrarMin(this.raiz);
	}

	private void borrarMin(Nodo nodo) {
		if (nodo.nodoIzq == null) {
			nodo = null;
		} else {
			borrarMin(nodo.nodoIzq);
		}
	}

	// Ejercicio 3 - d
	public boolean pertenece(Integer entero) {
		if (this.raiz == null) {
			return false;
		}
		return pertenece(this.raiz, entero);
	}

	private boolean pertenece(Nodo nodo, Integer entero) {
		if (nodo.getDato() == entero) {
			return true;
		} else if (nodo.getDato() > entero) {
			return pertenece(nodo.nodoIzq, entero);
		} else {
			return pertenece(nodo.nodoDer, entero);
		}
	}

}

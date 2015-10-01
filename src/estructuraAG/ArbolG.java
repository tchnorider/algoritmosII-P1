package estructuraAG;

import estructuraAB.Lista;
import estructuraAB.NodoAB;

public class ArbolG {
	public NodoG raiz;

	// ?
	// NodoG primerHijo;

	Integer hojas;

	public ArbolG() {

	}

	NodoG buscar(String str) {

		return buscar(this.raiz, str);
	}

	NodoG buscar(NodoG nodo, String str) {
		if (nodo == null) {
			return null;
		}
		if (nodo.dato.equals(str)) {
			return nodo;
		}
		NodoG aux = buscar(nodo.sigHermano, str);
		if (aux == null) {
			aux = buscar(nodo.primerHijo, str);
		}
		return aux;
	}

	public Integer cantHojas() {
		return cantHojas(this.raiz);
	}

	private Integer cantHojas(NodoG nodo) {
		if (nodo == null) {
			return 0;
		}
		if (nodo.primerHijo == null) {
			hojas++;
		} else {
			cantHojas(nodo.primerHijo);
		}
		if (nodo.sigHermano != null) {
			cantHojas(nodo.sigHermano);
		}
		return hojas;
	}

	public Integer cantHojasClase() {
		return cantHojas(this.raiz);
	}

	@SuppressWarnings("unused")
	private Integer cantHojasClase(NodoG nodo) {
		if (nodo == null) {
			return 0;
		}
		if (nodo.primerHijo == null) {
			return 1 + cantHojas(nodo.sigHermano);
		}
		return cantHojas(nodo.primerHijo) + cantHojas(nodo.sigHermano);
	}

	public void insertar(String str) {
		insertar(this.raiz, str);

	}

	private void insertar(NodoG raiz2, String str) {
		// TODO Auto-generated method stub

	}

	public Lista getNodosNivelClase(int nivel) {
		Lista res = new Lista();
		getNN(this.raiz, nivel, 0, res);
		return res;
	}

	private void getNN(NodoG n, int nivel, int nivelActual, Lista res) {
		if (n == null) {
			return;
		}
		if (nivel == nivelActual) {
			res.agregar(n.datoInt);
			getNN(n.primerHijo, nivel, nivelActual, res);
		} else {
			getNN(n.primerHijo, nivel, nivelActual + 1, res);
			getNN(n.sigHermano, nivel, nivelActual, res);
		}
	}

}

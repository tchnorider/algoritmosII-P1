package estructuraAG;

import estructuraAB.Lista;
import estructuraAB.NodoAB;

public class ArbolG {
	public NodoG raiz;
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

	public String camino(String p) {
		String camino = "";
		return camino(this.raiz, p, camino);

	}

	private String camino(NodoG n, String p, String camino) {
		if (n == null) {
			return "";
		}
		if (n.dato == p) {
			return camino = camino + "-" + n.dato;

		} else {
			if (n.primerHijo.dato == p) {
				camino = camino + "-" + n.dato;
				return camino(n.primerHijo, p, camino);
			}
			if (n.sigHermano != null) {
				return camino(n.sigHermano, p, camino);
			}
		}
		return camino;
	}

	public String caminoClase(String p) {

		return caminoClase(this.raiz, p);

	}

	private String caminoClase(NodoG n, String p) {
		if (n == null) {
			return "";
		}
		if (n.dato.equals(p)) {
			return n.dato;
		}
		String aux = caminoClase(n.primerHijo, p);
		if (!aux.equals(" ")) {
			return aux + "|" + n.dato;
		}
		return caminoClase(n.sigHermano, p);
	}
}

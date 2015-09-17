package estructuraAG;

public class ArbolG {
	NodoG raiz;
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

}

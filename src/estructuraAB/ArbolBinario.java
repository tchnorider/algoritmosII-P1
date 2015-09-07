package estructuraAB;

public class ArbolBinario {

	private Nodo raiz;
	private int cantNodos;
	private int cantHojas;
	private int peso;
	private int altura;

	public ArbolBinario() {
		this.raiz = null;
	}

	public ArbolBinario(int dato) {
		this.raiz = new Nodo();
		raiz.setDato(dato);
		this.cantHojas = 0;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	public int getCantHojas() {
		return cantHojas;
	}

	public void setCantHojas(int cantHojas) {
		this.cantHojas = cantHojas;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public Nodo getRaiz() {
		return this.raiz;
	}

	public void imprimir() {
		imprimir(this.raiz);
	}

	private void imprimir(Nodo n) {
		if (n == null) {
			return;
		}
		System.out.println(n.getDato());
		imprimir(n.nodoIzq);
		imprimir(n.nodoDer);
	}

	public boolean existe(int d) {
		return existe(this.raiz, d);
	}

	private boolean existe(Nodo n, int d) {
		if (n == null) {
			return false;
		}
		if (n.getDato() == d) {
			return true;
		}
		/*
		 * existe(n.nodoIzq, d); existe(n.nodoDer, d); // "||" operador lazy, si
		 * la llamada izq retorna true, no evalua la llamada derecha
		 */
		return existe(n.nodoIzq, d) || existe(n.nodoDer, d);
	}

	public Nodo buscar(int d) {
		return buscar(this.raiz, d);
	}

	private Nodo buscar(Nodo n, int d) {
		if (n == null) {
			return null;
		}
		if (n.getDato() == d) {
			return n;
		}

		Nodo nodoAux = buscar(n.nodoIzq, d);
		if (nodoAux == null) {
			return buscar(n.nodoDer, d);
		} else {
			return nodoAux;
		}
	}

	public int cantidadDeHojas() {
		return cantidadDeHojas(this.raiz);
	}

	private int cantidadDeHojas(Nodo n) {
		if (n == null) {
			return cantHojas;
		}
		if (n.nodoIzq == null) {
			this.cantHojas++;
		} else if (n.nodoDer == null) {
			this.cantHojas++;
		}
		cantidadDeHojas(n.nodoIzq);
		cantidadDeHojas(n.nodoDer);
		return this.cantHojas;
	}

	public int altura() {
		return altura(this.raiz);
	}

	private int altura(Nodo n) {
		if (n == null) {
			return -1;
		}
		int altIzq = altura(n.nodoIzq);
		int altDer = altura(n.nodoDer);
		// (IF ? THEN:ELSE)
		// MayorEntre(IF izq or der)
		return 1 + (altIzq > altDer ? altIzq : altDer);

	}

}

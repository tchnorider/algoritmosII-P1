package estructuraAB;

import java.util.List;

public class ArbolB {

	private NodoAB raiz;
	private int cantNodos;
	private int cantHojas;

	public ArbolB() {
		this.raiz = null;
	}

	public ArbolB(int dato) {
		this.raiz = new NodoAB();
		raiz.setDato(dato);
		this.cantHojas = 0;
	}

	private void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	public Integer getCantNodos() {
		return calcularCantidadNodos(this.raiz);
	}

	public int getCantHojas() {
		return cantHojas;
	}

	public Integer getPeso() {
		return calcularPeso(this.raiz) - 1;
	}

	public NodoAB getRaiz() {
		return this.raiz;
	}

	// E.3 | A | insert(x)
	public void insertar(int x) {
		NodoAB n = new NodoAB(x);
		if (this.raiz == null) {
			this.raiz = n;
		} else {
			insertar(n, this.raiz);
		}
	}

	// Precondition: n <> null
	private void insertar(NodoAB n, NodoAB raiz) {
		if (raiz.getDato() > n.getDato()) {
			if (n.nodoIzq == null) {
				n.nodoIzq = n;
			} else {
				insertar(n, n.nodoIzq);
			}
		} else {
			if (n.nodoDer == null) {
				n.nodoDer = n;
			} else {
				insertar(n, n.nodoDer);
			}
		}
	}

	public void imprimir() {
		imprimir(this.raiz);
	}

	private void imprimir(NodoAB n) {
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

	// Use of the lazy operator ('||'): if the call with the left node returns
	// true then the right call never gets done because there's no need to
	// evaluate this return since either way the result will be true even if
	// this return is false.
	private boolean existe(NodoAB n, int d) {
		if (n == null) {
			return false;
		}
		if (n.getDato() == d) {
			return true;
		}
		return existe(n.nodoIzq, d) || existe(n.nodoDer, d);
	}

	public NodoAB buscar(int d) {
		return buscar(this.raiz, d);
	}

	private NodoAB buscar(NodoAB n, int d) {
		if (n == null) {
			return null;
		}
		if (n.getDato() == d) {
			return n;
		}

		NodoAB nodoAux = buscar(n.nodoIzq, d);
		if (nodoAux == null) {
			return buscar(n.nodoDer, d);
		} else {
			return nodoAux;
		}
	}

	public int cantidadDeHojas() {
		return cantidadDeHojas(this.raiz);
	}

	private int cantidadDeHojas(NodoAB n) {
		if (n == null) {
			return cantHojas;
		}
		if (n.nodoIzq == null && n.nodoDer == null) {
			cantHojas++;
		} else {
			if (n.nodoIzq != null) {
				cantidadDeHojas(n.nodoIzq);
			} else if (n.nodoDer != null) {
				cantidadDeHojas(n.nodoDer);
			}
		}
		return this.cantHojas;
	}

	public Integer getAltura() {
		return altura(this.raiz);
	}

	private Integer altura(NodoAB n) {
		if (n == null) {
			return -1;
		}
		Integer altIzq = altura(n.nodoIzq);
		Integer altDer = altura(n.nodoDer);
		return 1 + (altIzq > altDer ? altIzq : altDer);
	}

	// Pre order: the father gets evaluated first
	public void imprimirPreOrder(NodoAB n) {
		if (n == null) {
			return;
		}
		imprimirPreOrder(n.nodoDer);
		imprimirPreOrder(n.nodoIzq);
	}

	// Post order: the children gets evaluated first
	public void imprimirPostOrder(NodoAB n) {
		if (n == null) {
			return;
		}
		imprimirPostOrder(n.nodoDer);
		imprimirPostOrder(n.nodoIzq);
		System.out.println(n.getDato());
	}

	// in order: evaluate right children first, then the father then the left
	// children
	public void imprimirInOrder(NodoAB n) {
		if (n == null) {
			return;
		}
		imprimirPostOrder(n.nodoDer);
		System.out.println(n.getDato());
		imprimirPostOrder(n.nodoIzq);
	}

	private Integer calcularCantidadNodos(NodoAB nodo) {
		if (nodo == null) {
			return 0;
		}
		this.setCantNodos(cantNodos + calcularCantidadNodos(nodo.nodoDer));
		this.setCantNodos(cantNodos + calcularCantidadNodos(nodo.nodoIzq));
		cantNodos++;
		return cantNodos;
	}

	private int calcularPeso(NodoAB nodo) {
		if (nodo == null) {
			return 0;
		}
		Integer aux = calcularPeso(nodo.nodoDer) + calcularPeso(nodo.nodoIzq);
		aux++;
		return aux;
	}

	public boolean todosPares() {
		return sonPares(this.raiz);
	}

	private boolean sonPares(NodoAB nodo) {
		if (nodo == null) {
			return false;
		}
		if (nodo.getDato() % 2 == 0) {
			return true;
		}
		return sonPares(nodo.nodoIzq) && sonPares(nodo.nodoDer) == true ? true : false;
	}

	public boolean esIgualA(ArbolB a2) {
		return sonIguales(a2.raiz, this.raiz);
	}

	// XOR (^) in case you need to evaluate both sides for one negative.
	private boolean sonIguales(NodoAB nodo2, NodoAB nodo) {
		if (nodo2 == null && nodo == null) {
			return true;
		} else if (nodo2.nodoIzq == null ^ nodo.nodoIzq == null) {
			return false;
		} else if (nodo2.nodoDer == null ^ nodo.nodoDer == null) {
			return false;
		} else if (nodo2.getDato() == nodo.getDato()) {
			return true;
		}
		return sonIguales(nodo2.nodoIzq, nodo.nodoIzq) && sonIguales(nodo2.nodoDer, nodo.nodoDer);
	}

	// another solution to above function
	// this is class's solution below
	public boolean identical(ArbolB a2) {
		return identical(a2.raiz, this.raiz);
	}

	private boolean identical(NodoAB nodo2, NodoAB nodo) {
		if (nodo2 == null && nodo == null) {
			return true;
		} else if (nodo2 == null || nodo == null) {
			return false;
		} else if (nodo2.getDato() == nodo.getDato()) {
			return true;
		}
		return sonIguales(nodo2.nodoIzq, nodo.nodoIzq) && sonIguales(nodo2.nodoDer, nodo.nodoDer);
	}

	public ArbolB clon() {
		ArbolB clon = new ArbolB();
		if (this.raiz != null) {
			NodoAB raizClon = new NodoAB();
			raizClon = this.raiz;
			clon.raiz = raizClon;
			clonar(this.raiz, clon.raiz);
		}
		return clon;
	}

	private void clonar(NodoAB nodo, NodoAB nodoClon) {
		if (nodo.nodoIzq != null) {
			nodoClon.nodoIzq = new NodoAB();
			nodoClon.nodoIzq = nodo.nodoIzq;
			clonar(nodo.nodoIzq, nodoClon.nodoIzq);
		}
		if (nodo.nodoDer != null) {
			nodoClon.nodoDer = new NodoAB();
			nodoClon.nodoDer = nodo.nodoDer;
			clonar(nodo.nodoDer, nodoClon.nodoDer);
		}
	}

	public ArbolB espejoClase(ArbolB a) {
		ArbolB arbEspejo = new ArbolB();
		if (this.raiz != null) {
			arbEspejo.raiz = new NodoAB(a.raiz.getDato());
			espejoClase(a.raiz, arbEspejo.raiz);
		}
		System.out.println("arbol");
		this.imprimir();
		System.out.println("arbol espejo");
		arbEspejo.imprimir();
		return arbEspejo;
	}

	private void espejoClase(NodoAB nodo, NodoAB nodoEsp) {
		if (nodo.nodoIzq == null && nodo.nodoDer == null) {
			return;
		}
		if (nodo.nodoIzq != null) {
			nodoEsp.nodoDer = new NodoAB(nodo.nodoIzq.getDato());
			espejo(nodo.nodoDer, nodoEsp.nodoDer);
		}
		if (nodo.nodoDer != null) {
			nodoEsp.nodoIzq = new NodoAB(nodo.nodoDer.getDato());
			espejo(nodo.nodoIzq, nodoEsp.nodoIzq);
		}
	}

	public ArbolB espejo() {
		ArbolB arbEspejo = new ArbolB();
		if (this.raiz != null) {
			NodoAB nodoEsp = new NodoAB();
			nodoEsp = this.raiz;
			arbEspejo.raiz = nodoEsp;
			espejo(this.raiz, arbEspejo.raiz);
		}
		System.out.println("arbol");
		this.imprimir();
		System.out.println("arbol espejo");
		arbEspejo.imprimir();
		return arbEspejo;
	}

	private void espejo(NodoAB nodo, NodoAB nodoEsp) {
		if (nodo.nodoDer != null) {
			NodoAB n = new NodoAB();
			n = nodo.nodoDer;
			nodoEsp.nodoIzq = n;
			espejo(nodo.nodoIzq, nodoEsp.nodoIzq);
		} else {
			nodo.nodoIzq = null;
		}
		if (nodo.nodoIzq != null) {
			NodoAB n = new NodoAB();
			n = nodo.nodoIzq;
			nodoEsp.nodoDer = n;
			espejo(nodo.nodoDer, nodoEsp.nodoDer);
		} else {
			nodo.nodoDer = null;
		}
	}

	public void getNodosNivel(int i) {
		Lista enterosNivelI = new Lista();
		;
		if (this.raiz != null) {
			nodosNivelI(this.raiz, enterosNivelI, 0, i);
		}
	}

	private void nodosNivelI(NodoAB n, Lista enterosNivelI, int currentLevel, int level) {

		if (n != null) {
			if (n.nodoIzq != null && currentLevel < level) {
				nodosNivelI(n.nodoIzq, enterosNivelI, currentLevel, level);
			} else if (n.nodoDer == null) {
				// enterosNivelI.add(n);
			}

		}
	}

	public Lista getNodosNivelClase(int nivel) {
		Lista res = new Lista();
		getNN(this.getRaiz(), nivel, 0, res);
		return res;
	}

	private void getNN(NodoAB n, int nivel, int nivelActual, Lista res) {
		if (n == null) {
			return;
		}
		if (nivel == nivelActual) {
			res.agregar(n.getDato());
		} else {
			getNN(n.nodoIzq, nivel, nivelActual + 1, res);
			getNN(n.nodoDer, nivel, nivelActual + 1, res);
		}
	}

	/*
	 * thinking outloud.. private void clonar(Nodo nodo, Nodo nodoClon) { if
	 * (nodo != null) { nodoClon = nodo; } if (nodo.nodoIzq != null) {
	 * nodoClon.nodoIzq = nodo.nodoIzq; clonar(nodo.nodoIzq, nodoClon.nodoIzq);
	 * } else { nodoClon.nodoIzq = null; } if (nodo.nodoDer != null) {
	 * nodoClon.nodoDer = nodo.nodoDer; clonar(nodo.nodoDer, nodoClon.nodoDer);
	 * } else { nodoClon.nodoDer = null; } }
	 */
}

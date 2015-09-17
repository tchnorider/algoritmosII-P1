package estructuraAB;

public class ArbolB {

	private Nodo raiz;
	private int cantNodos;
	private int cantHojas;

	public ArbolB() {
		this.raiz = null;
	}

	public ArbolB(int dato) {
		this.raiz = new Nodo();
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

	public Nodo getRaiz() {
		return this.raiz;
	}

	// E.3 | A | insert(x)
	public void insertar(int x) {
		Nodo n = new Nodo(x);
		if (this.raiz == null) {
			this.raiz = n;
		} else {
			insertar(n, this.raiz);
		}
	}

	// Precondition: n <> null
	private void insertar(Nodo n, Nodo raiz) {
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

	// Use of the lazy operator ('||'): if the call with the left node returns
	// true then the right call never gets done because there's no need to
	// evaluate this return since either way the result will be true even if
	// this return is false.
	private boolean existe(Nodo n, int d) {
		if (n == null) {
			return false;
		}
		if (n.getDato() == d) {
			return true;
		}
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

	private Integer altura(Nodo n) {
		if (n == null) {
			return -1;
		}
		Integer altIzq = altura(n.nodoIzq);
		Integer altDer = altura(n.nodoDer);
		return 1 + (altIzq > altDer ? altIzq : altDer);
	}

	// Pre order: the father gets evaluated first
	public void imprimirPreOrder(Nodo n) {
		if (n == null) {
			return;
		}
		imprimirPreOrder(n.nodoDer);
		imprimirPreOrder(n.nodoIzq);
	}

	// Post order: the children gets evaluated first
	public void imprimirPostOrder(Nodo n) {
		if (n == null) {
			return;
		}
		imprimirPostOrder(n.nodoDer);
		imprimirPostOrder(n.nodoIzq);
		System.out.println(n.getDato());
	}

	// in order: evaluate right children first, then the father then the left
	// children
	public void imprimirInOrder(Nodo n) {
		if (n == null) {
			return;
		}
		imprimirPostOrder(n.nodoDer);
		System.out.println(n.getDato());
		imprimirPostOrder(n.nodoIzq);
	}

	private Integer calcularCantidadNodos(Nodo nodo) {
		if (nodo == null) {
			return 0;
		}
		this.setCantNodos(cantNodos + calcularCantidadNodos(nodo.nodoDer));
		this.setCantNodos(cantNodos + calcularCantidadNodos(nodo.nodoIzq));
		cantNodos++;
		return cantNodos;
	}

	private int calcularPeso(Nodo nodo) {
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

	private boolean sonPares(Nodo nodo) {
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
	private boolean sonIguales(Nodo nodo2, Nodo nodo) {
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

	private boolean identical(Nodo nodo2, Nodo nodo) {
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
			Nodo raizClon = new Nodo();
			raizClon = this.raiz;
			clon.raiz = raizClon;
			clonar(this.raiz, clon.raiz);
		}
		return clon;
	}

	private void clonar(Nodo nodo, Nodo nodoClon) {
		if (nodo.nodoIzq != null) {
			nodoClon.nodoIzq = new Nodo();
			nodoClon.nodoIzq = nodo.nodoIzq;
			clonar(nodo.nodoIzq, nodoClon.nodoIzq);
		}
		if (nodo.nodoDer != null) {
			nodoClon.nodoDer = new Nodo();
			nodoClon.nodoDer = nodo.nodoDer;
			clonar(nodo.nodoDer, nodoClon.nodoDer);
		}
	}

	public ArbolB espejoClase(ArbolB a) {
		ArbolB arbEspejo = new ArbolB();
		if (this.raiz != null) {
			arbEspejo.raiz = new Nodo(a.raiz.getDato());
			espejoClase(a.raiz, arbEspejo.raiz);
		}
		System.out.println("arbol");
		this.imprimir();
		System.out.println("arbol espejo");
		arbEspejo.imprimir();
		return arbEspejo;
	}

	private void espejoClase(Nodo nodo, Nodo nodoEsp) {
		if (nodo.nodoIzq == null && nodo.nodoDer == null) {
			return;
		}
		if (nodo.nodoIzq != null) {
			nodoEsp.nodoDer = new Nodo(nodo.nodoIzq.getDato());
			espejo(nodo.nodoDer, nodoEsp.nodoDer);
		}
		if (nodo.nodoDer != null) {
			nodoEsp.nodoIzq = new Nodo(nodo.nodoDer.getDato());
			espejo(nodo.nodoIzq, nodoEsp.nodoIzq);
		}
	}

	public ArbolB espejo() {
		ArbolB arbEspejo = new ArbolB();
		if (this.raiz != null) {
			Nodo nodoEsp = new Nodo();
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

	private void espejo(Nodo nodo, Nodo nodoEsp) {
		if (nodo.nodoDer != null) {
			Nodo n = new Nodo();
			n = nodo.nodoDer;
			nodoEsp.nodoIzq = n;
			espejo(nodo.nodoIzq, nodoEsp.nodoIzq);
		} else {
			nodo.nodoIzq = null;
		}
		if (nodo.nodoIzq != null) {
			Nodo n = new Nodo();
			n = nodo.nodoIzq;
			nodoEsp.nodoDer = n;
			espejo(nodo.nodoDer, nodoEsp.nodoDer);
		} else {
			nodo.nodoDer = null;
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

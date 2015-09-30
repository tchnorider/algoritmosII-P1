package estructuraAG;

public class NodoG {
	String dato;
	int datoInt;
	public NodoG primerHijo;
	public NodoG sigHermano;

	public NodoG() {

	}

	public NodoG(int d, NodoG pHijo, NodoG sHerm) {
		this.datoInt = d;
		this.primerHijo = pHijo;
		this.sigHermano = sHerm;
	}

	public NodoG(int d) {
		this.datoInt = d;
	}
}

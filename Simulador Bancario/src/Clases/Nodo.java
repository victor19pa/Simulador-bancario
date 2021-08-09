package Clases;


public class Nodo {
	Object Dato;
	int Encadenamiento;
	
	
	public Nodo(Object dato){
		this.Dato = Dato;
	}
	
	public Nodo(Object dato, int encadenamiento) {
		this.Dato = dato;
		this.Encadenamiento = encadenamiento;
	}

	public Object getDato() {
		return Dato;
	}

	public void setDato(Object dato) {
		Dato = dato;
	}

	public int getEncadenamiento() {
		return Encadenamiento;
	}

	public void setEncadenamiento(int encadenamiento) {
		Encadenamiento = encadenamiento;
	}
	
	

}

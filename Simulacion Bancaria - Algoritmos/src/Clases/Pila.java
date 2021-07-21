package Clases;


public class Pila {
	public Lista pila = new Lista();
	
	public int METE(Object x){
		return pila.INSERTA(x, pila.PRIMERO());
	};
	
	public Object TOPE(){
		return pila.RECUPERA(pila.PRIMERO());
	};
	
	public void SACA(){
		pila.SUPRIME(pila.PRIMERO());
	};
	
	public void ANULA(){
		pila.ANULA();
	};
	
	public boolean VACIA(){
		return pila.VACIA();
	}
}

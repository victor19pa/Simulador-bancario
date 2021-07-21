package Clases;


public class Cola {
	Lista cola = new Lista();
	
	public int PONE_EN_COLA(Object x){
		return cola.INSERTA(x, cola.FIN());
	};
	
	public Object FRENTE(){
		return cola.RECUPERA(cola.PRIMERO());
	};
	
	public void QUITA_DE_COLA(){
		cola.SUPRIME(cola.PRIMERO());
	};
	
	public void ANULA(){
		cola.ANULA();
	};
	
	public boolean VACIA(){
		return cola.VACIA();
	}
}

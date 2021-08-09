package Clases;


public class Lista {
	public Cursor contenedor = new Cursor();

	public int INSERTA(Object x, int p){
		return contenedor.INSERTA(x, p);
	};
	public int LOCALIZA(Object x){
		return 	contenedor.LOCALIZA(x);
	};
	public Object RECUPERA(int p){
		return contenedor.RECUPERA(p);
	};
	public void SUPRIME(int p){
		contenedor.SUPRIME(p);
	};
	public int SIGUIENTE(int p){
		return contenedor.SIGUIENTE(p);
	};
	public int ANTERIOR(int p){
		return contenedor.ANTERIOR(p);
	};
	public void ANULA(){
		contenedor.ANULA();
	};
	public int PRIMERO(){
		return contenedor.PRIMERO();
	};
	public int FIN(){
		return contenedor.FIN();
	};
	public boolean VACIA(){
		return contenedor.VACIA();
	}
}

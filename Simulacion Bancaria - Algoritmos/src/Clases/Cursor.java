package Clases;


public class Cursor {
	private static int MAX = 100000;
	private int Cabeza;

	private Nodo arreglo[] = new Nodo[MAX];
	private boolean memoria[] = new boolean[MAX];

	private int numElementos;
	private boolean empty;
	
	private int indice;
	private int index = 0;
	
	public boolean suprOK;

	public Cursor() {
		for(int i = 0; i<MAX;i++){
			memoria[i] = false;
		}

		for(int i = 0; i<MAX;i++){
			arreglo[i] = new Nodo(null);
		}

	}

	public int LOCALIZA(Object x){
		int in = Cabeza, cont = -1;
		//posicion = -1;
		/*for(int k = 0; k < MAX; k++){
			if(arreglo[in].Dato==x){
				cont=cont+2;
				break;
			}
			cont++;
			in = arreglo[in].Encadenamiento;
		}*/
		/*for(int i = 0; i<MAX;i++){
			if((x==arreglo[i].Dato)){
				posicion = i;
				break;
			}
		}*/
		for(int k = 0; k < MAX; k++){
			System.out.println("Local " + (k+1)+" "+arreglo[in].Dato);
			if(arreglo[in].Encadenamiento==-1){
				if(arreglo[in].Dato!=x){
					break;
				}
			}
			if(arreglo[in].Dato==x){
				cont = k+1;
				break;
			}
			in = arreglo[in].Encadenamiento;
		}
		if(cont!=(-1)){
			return cont;
		} else{
			return FIN();
		}
		
	}

	public int INSERTA(Object x, int p){
		index = indexActual();
		if((FIN()>=p)&&(PRIMERO()<=p)&&(index!=-1)){
			if(VACIA()){
				Cabeza=index;
				//index = indexActual();
				arreglo[index].Dato = x;
				memoria[index] = true;
				arreglo[index].Encadenamiento = -1;
			}else if(p==PRIMERO()){
				//index = indexActual();
				arreglo[index].Dato = x;
				arreglo[index].Encadenamiento = Cabeza;
				memoria[index] = true;
				Cabeza = index;
			}else if(p==FIN()){
				int in = 0;
				for(int k = 0; k < MAX; k++){
					if(arreglo[k].Encadenamiento==-1){
						in = k;
						break;
					}
				}
				//System.out.println("------in " +in);
				//index = indexActual();
				arreglo[in].Encadenamiento = index;
				arreglo[index].Dato = x;
				arreglo[index].Encadenamiento = -1;
				memoria[index] = true;
			}else{
				int in = Cabeza, anter = in;
				//System.out.println("------ " +p+" +++++ Cabeza "+ Cabeza);
				for(int k = 0; k < p-1; k++){
					anter=in;
					in = arreglo[in].Encadenamiento;
					//System.out.println("k:  " +k+" +++++ in "+ in);
				}
				//index = indexActual();
				//System.out.println("pos:  " +p+" +++++ in "+ in+" "+arreglo[in].Dato);
				arreglo[anter].Encadenamiento = index;
				arreglo[index].Dato = x;
				arreglo[index].Encadenamiento = in;
				memoria[index] = true;
			}
			suprOK = true;
			return p;
		}else {
			System.out.println("********No se puede insertar ahí");
			return -1;
		}
	};
	
	public void SUPRIME(int p){
		if((FIN()>p)&&(PRIMERO()<=p)){
			if(VACIA()){
				System.out.println("No puede se puede suprimir si esta vacia");
			}else 
				suprOK = true;
				if(p==PRIMERO()){
				memoria[Cabeza] = false;
				Cabeza = arreglo[Cabeza].Encadenamiento;
			}else{
				int in = Cabeza, anter = in, sig = arreglo[in].Encadenamiento;
				for(int k = 0; k < p-1; k++){
					anter=in;
					in = arreglo[in].Encadenamiento;
					sig = arreglo[in].Encadenamiento;
				}
				arreglo[anter].Encadenamiento = sig;
				memoria[in] = false;
			}
		}else {
			suprOK = false;
			System.out.println("********No se puede Suprimir ahí");
		}
	}
	
	public Object RECUPERA(int p){
		int in = Cabeza;
		if(!VACIA()){
			for(int k = 0; k < p-1; k++){
				in = arreglo[in].Encadenamiento;
			}
			return arreglo[in].Dato;
		}
		return null;
	}

	public void ANULA(){
		Cabeza = -1;
		numElementos = 0;
		empty = true;
		for(int k = 0; k < MAX; k++){
			memoria[k] = false;
			arreglo[k].Dato = null;
		}
		System.out.println("La lista ahora se encuentra vacia\n");
	}
	
	public boolean VACIA(){
		for(int k = 0; k < MAX; k++){
			if(memoria[k]==true){
				empty = false;
				break;
			}else{
				empty = true;
			}
		}
		return empty;
	}

	//Clases de apoyo
	public int ANTERIOR(int p){
		return p-1;
	}

	public int SIGUIENTE(int p){
		return p+1;
	}

	public int PRIMERO(){
		return 1;
	}

	public int FIN(){
		numElementos = 0;
		for(int i = 0; i<MAX;i++){
			if(memoria[i]!=false){
				numElementos++;
			}
		}
		return numElementos+1;
	}
	
	//Verdaderos metodos de apoyo
	public int indexActual(){
		indice = -1;
		for(int k = 0; k < MAX; k++){
			if(memoria[k]==false){
				indice = k;
				break;
			}
		}
		return indice;
	}
	
	public void imprimeLista(){
		int in = Cabeza;
		if(!VACIA()){
			for(int k = 0; k < MAX; k++){
				System.out.println((k+1)+" "+arreglo[in].Dato);
				if(arreglo[in].Encadenamiento==-1){
					System.out.println();
					break;
				}
				in = arreglo[in].Encadenamiento;
			}
		}else {
			System.out.println("Esta Vacia");
		}
	}
}

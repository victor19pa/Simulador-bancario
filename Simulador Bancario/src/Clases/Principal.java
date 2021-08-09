package Clases;

//import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		Lista listaA = new Lista();
		//Pila pilaA = new Pila();
		//Cola colaA = new Cola();
		//colaA.PONE_EN_COLA(new Cliente(2,2,3));
		/*int opcion = 0;
		do{
			opcion = Integer.valueOf(JOptionPane.showInputDialog(
					"0 Salir\n"
					+ "1 Agregar Primero a La Lista\n"
					+ "2 Agregar Final de Lista\n"
					+ "3 Agregar de Segundo\n"
					+ "4 Mostrar Lista."));
			switch(opcion){
				case 0:
					System.out.println("Adios");
					break;
				case 1:
					agregarRegistro();
					break;
				case 2:
					modificarRegistro();
					break;
				case 3:
					eliminarRegistro();
					break;
				case 4:
					mostrarInformacion();
					break;
			}			
		}while(opcion!=0);*/
		listaA.INSERTA("Juana", listaA.PRIMERO());
		listaA.INSERTA("Pedro", listaA.ANTERIOR(listaA.FIN()));
		listaA.INSERTA("Maria", listaA.PRIMERO());
		listaA.INSERTA("Sara", listaA.SIGUIENTE(listaA.PRIMERO()));
		System.out.println("Vacia? " + listaA.VACIA()+ " FIN:"+listaA.FIN());
		listaA.INSERTA("Karina", listaA.SIGUIENTE(listaA.PRIMERO()));
		listaA.contenedor.imprimeLista();
		System.out.println("Vacia? " + listaA.PRIMERO()+ " Localiza:"+listaA.LOCALIZA("Sara"));
		listaA.contenedor.imprimeLista();
		System.out.println("Vacia? " + listaA.VACIA()+ " FIN:"+listaA.FIN());
		listaA.ANULA();
		listaA.INSERTA("Juana", listaA.PRIMERO());
		listaA.INSERTA("Pedro", listaA.SIGUIENTE(listaA.PRIMERO()));
		listaA.INSERTA("Maria", listaA.PRIMERO());
		listaA.INSERTA("Sara", listaA.ANTERIOR(listaA.FIN()));
		listaA.contenedor.imprimeLista();
		System.out.println("Vacia? " + listaA.VACIA()+ " FIN:"+listaA.FIN());
		//listaA.ANULA();
		listaA.INSERTA("Karina", listaA.SIGUIENTE(listaA.PRIMERO()));
		System.out.println("Vacia? " + listaA.PRIMERO()+ " Localiza:"+listaA.LOCALIZA("Sara"));
		listaA.contenedor.imprimeLista();
		System.out.println("Vacia? " + listaA.VACIA()+ " FIN:"+listaA.FIN());
		System.out.println("Recupera " + listaA.RECUPERA(listaA.ANTERIOR(listaA.FIN())));
		System.out.println("Vacia? " + listaA.PRIMERO()+ " Localiza:"+listaA.LOCALIZA("Pedro"));
		System.out.println("<<<<");
		listaA.contenedor.imprimeLista();
		listaA.SUPRIME(listaA.FIN());
		System.out.println("<<<<");
		listaA.contenedor.imprimeLista();
		System.out.println("Vacia? " + listaA.VACIA()+ " FIN:"+listaA.FIN());
		System.out.println("Vacia? " + listaA.PRIMERO()+ " Localiza:"+listaA.LOCALIZA("Sara")+"\n");
		
		/*pilaA.METE("Andrea");
		pilaA.METE("Sara");
		pilaA.METE("Karol");
		pilaA.METE("Celeste");
		pilaA.METE("Rebeca");
		pilaA.pila.contenedor.imprimeLista();
		System.out.println("----" + pilaA.TOPE());
		pilaA.SACA();
		pilaA.SACA();
		System.out.println("----");
		pilaA.pila.contenedor.imprimeLista();
		System.out.println("----" + pilaA.TOPE());
		pilaA.SACA();
		pilaA.SACA();
		pilaA.SACA();
		pilaA.pila.contenedor.imprimeLista();
		System.out.println("----" + pilaA.TOPE());*/
		
		/*System.out.println("---- " + pilaA.pila.contenedor.suprOK);
		pilaA.METE(new Cliente(2,2,3));
		pilaA.METE(new Cliente(27,78,3));
		pilaA.METE(new Cliente(78,2,3));
		pilaA.METE(new Cliente(55,45,3));
		pilaA.METE(new Cliente(2,4,3));
		pilaA.METE(new Cliente(54,2,8));
		pilaA.pila.contenedor.imprimeLista();
		pilaA.SACA();
		System.out.println("---- " + pilaA.pila.contenedor.suprOK);
		pilaA.SACA();
		pilaA.pila.contenedor.imprimeLista();*/
		
		/*colaA.PONE_EN_COLA("Pamela");
		colaA.PONE_EN_COLA("La Britany");
		colaA.PONE_EN_COLA("Alejandra");
		colaA.PONE_EN_COLA("EL Brayan");
		colaA.PONE_EN_COLA("Raven");
		colaA.cola.contenedor.imprimeLista();
		colaA.QUITA_DE_COLA();
		System.out.println("----");
		colaA.cola.contenedor.imprimeLista();
		System.out.println("----" + colaA.FRENTE() + " ¿Vacia? " + colaA.VACIA());
		colaA.QUITA_DE_COLA();
		colaA.PONE_EN_COLA("Alejandra");
		colaA.PONE_EN_COLA("EL Brayan");
		colaA.QUITA_DE_COLA();
		colaA.QUITA_DE_COLA();
		colaA.cola.contenedor.imprimeLista();
		colaA.QUITA_DE_COLA();
		System.out.println("----" + colaA.FRENTE() + " ¿Vacia? " + colaA.VACIA());*/
		
		/*System.out.println("----" + colaA.cola.contenedor.suprOK);
		colaA.QUITA_DE_COLA();
		System.out.println("----" + colaA.cola.contenedor.suprOK);
		colaA.PONE_EN_COLA(new Cliente(2,2,3));
		colaA.PONE_EN_COLA(new Cliente(2,15,1));
		colaA.PONE_EN_COLA(new Cliente(2,7,3));
		colaA.PONE_EN_COLA(new Cliente(5,2,3));
		colaA.PONE_EN_COLA(new Cliente(254,2,4));
		colaA.cola.contenedor.imprimeLista();
		colaA.QUITA_DE_COLA();
		System.out.println("----" + colaA.cola.contenedor.suprOK);
		colaA.cola.contenedor.imprimeLista();*/
		
		
	}

}

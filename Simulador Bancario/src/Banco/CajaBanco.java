package Banco;

import Clases.Pila;

public class CajaBanco extends Dinero{
	Pila p500 = new Pila();
	Pila p100 = new Pila();
	Pila p50 = new Pila();
	Pila p20 = new Pila();
	Pila p10 = new Pila();
	Pila p5 = new Pila();
	Pila p2 = new Pila();
	Pila p1 = new Pila();
	
	
	@Override
	public boolean deposita(int monto) {
		for(;(monto>=Quinientos)&&(p500.METE(Quinientos)!=-1);){
			if(p500.METE(Quinientos)!=-1){
				monto = monto-Quinientos;
			}			
		}
		for(;(monto>=Cien)&&(p100.METE(Cien)!=-1);){
			if(p100.METE(Cien)!=-1){
				monto = monto-Cien;
			}
		}
		for(;(monto>=Cincuenta)&&(p50.METE(Cincuenta)!=-1);){
			if(p50.METE(Cincuenta)!=-1){
				monto = monto-Cincuenta;
			}
		}
		for(;(monto>=Veinte)&&(p20.METE(Veinte)!=-1);){
			if(p20.METE(Veinte)!=-1){
				monto = monto-Veinte;
			}
		}
		for(;(monto>=Diez)&&(p10.METE(Diez)!=-1);){
			if(p10.METE(Diez)!=-1){
				monto = monto-Diez;
			}
		}
		for(;(monto>=Cinco)&&(p5.METE(Cinco)!=-1);){
			if(p5.METE(Cinco)!=-1){
				monto = monto-Cinco;
			}
		}
		for(;(monto>=Dos)&&(p2.METE(Dos)!=-1);){
			if(p2.METE(Dos)!=-1){
				monto = monto-Dos;
			}
		}
		for(;(monto>=Uno)&&(p1.METE(Uno)!=-1);){
			if(p1.METE(Uno)!=-1){
				monto = monto-Uno;
			}
		}
		
		if(monto==0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean retira(int monto) {
		//por ahora esta malo, solo el primer saca da el visto bueno
		for(;(monto>=Quinientos)&&(p500.pila.contenedor.suprOK);){
			p500.SACA();
			if(p500.pila.contenedor.suprOK){
				monto = monto-Quinientos;
			}			
		}
		for(;(monto>=Cien)&&(p100.pila.contenedor.suprOK);){
			p100.SACA();
			if(p100.pila.contenedor.suprOK){
				monto = monto-Cien;
			}
		}
		for(;(monto>=Cincuenta)&&(p50.pila.contenedor.suprOK);){
			p50.SACA();
			if(p50.pila.contenedor.suprOK){
				monto = monto-Cincuenta;
			}
		}
		for(;(monto>=Veinte)&&(p20.pila.contenedor.suprOK);){
			p20.SACA();
			if(p20.pila.contenedor.suprOK){
				monto = monto-Veinte;
			}
		}
		for(;(monto>=Diez)&&(p10.pila.contenedor.suprOK);){
			p10.SACA();
			if(p10.pila.contenedor.suprOK){
				monto = monto-Diez;
			}
		}
		for(;(monto>=Cinco)&&(p5.pila.contenedor.suprOK);){
			p5.SACA();
			if(p5.pila.contenedor.suprOK){
				monto = monto-Cinco;
			}
		}
		for(;(monto>=Dos)&&(p2.pila.contenedor.suprOK);){
			p2.SACA();
			if(p2.pila.contenedor.suprOK){
				monto = monto-Dos;
			}
		}
		for(;(monto>=Uno)&&(p1.pila.contenedor.suprOK);){
			p1.SACA();
			if(p1.pila.contenedor.suprOK){
				monto = monto-Uno;
			}
		}
		
		if(monto==0){
			return true;
		}else{
			return false;
		}
	}

}

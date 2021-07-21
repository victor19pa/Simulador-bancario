package Banco;

import java.util.Random;

import Clases.Cola;

public class Procesos {
	public Cola personas = new Cola();
	
	public int tiempo = 0;
	public int gente_en_Cola = 0;
	public int clientes_atendidos = 0;
	public boolean firstTime = true;
	public Random random = new Random();
	private boolean terminar = false;
	public int n=10;
	public int n1=0;
	public int n2=0;
	
	int c500 = 0;
	int c100 = 0;
	int c50 = 0;
	int c20 = 0;
	int c10 = 0;
	int c5 = 0;
	int c2 = 0;
	public int c1 = 0;

	public CajaBanco boxBan1k = new CajaBanco();
	public CajaBanco boxBan2k = new CajaBanco();
	public CajaBanco boxBan3k = new CajaBanco();
	public CajaBanco boxBan4k = new CajaBanco();
	
	public boolean ocupado1 = false;
	public boolean ocupado2 = false;
	public boolean ocupado3 = false;
	public boolean ocupado4 = false;
	
	public int to1 = 0;
	public int to2 = 0;
	public int to3 = 0;
	public int to4 = 0;
	
	public String soul1;
	public String soul2;
	public String soul3;
	public String soul4;
	
	public int tipoTran1;
	public int tipoTran2;
	public int tipoTran3;
	public int tipoTran4;
	
	public boolean deposito1 = true;
	public boolean deposito2 = true;
	public boolean deposito3 = true;
	public boolean deposito4 = true;
	
	public boolean retira1 = true;
	public boolean retira2 = true;
	public boolean retira3 = true;
	public boolean retira4 = true;
	
	public int montoDep1 = 0;
	public int montoDep2 = 0;
	public int montoDep3 = 0;
	public int montoDep4 = 0;
	
	public int montoRet1 = 0;
	public int montoRet2 = 0;
	public int montoRet3 = 0;
	public int montoRet4 = 0;
	
	public int temp1 = 0;
	public int temp2 = 0;
	public int temp3 = 0;
	public int temp4 = 0;
	
	public boolean isTerminar() {
		return terminar;
	}
	public void setTerminar(boolean terminar) {
		this.terminar = terminar;
	}
	
	public void transaccion(){
		if(ocupado1){
			if(to1>=30){
				ocupado1=false;
				to1=0;
			}
		}
		if(ocupado2){
			if(to2>=40){
				ocupado2=false;
				to2=0;
			}
		}
		if(ocupado3){
			if(to3>=35){
				ocupado3=false;
				to3=0;
			}
		}
		if(ocupado4){
			if(to4>=30){
				ocupado4=false;
				to4=0;
			}
		}
		/*to1++;
		to2++;
		to3++;
		to4++;*/
		if(!ocupado1){
			ocupado1 = true;
			//hasta que se metan aca en la animacion entran a la caja
			soul1 = (String)personas.FRENTE();
			personas.QUITA_DE_COLA();
			gente_en_Cola = gente_en_Cola-1;
			// puede ser llave de dibujo, y utlizar otros codigos para posicion
			tipoTran1 = random.nextInt(2);
			System.out.println("Tipo de tran1 "+tipoTran1);
			temp1 = (random.nextInt(49951)+50);
			if(tipoTran1==0){
				deposito1=boxBan1k.deposita(temp1);
				if(deposito1){
					montoDep1 = (montoDep1 + temp1);
					clientes_atendidos++;
					if(!retira1){
						retira1=true;
					}
				}
			}else if(retira1){
				retira1 = (boxBan1k.retira(temp1));
				if(retira1){
					montoRet1 = (montoRet1 + temp1);
					clientes_atendidos++;
					if(!deposito1){
						deposito1 = true;
					}
				}
			}
		}
		if(!ocupado2){
			ocupado2 = true;
			//hasta que se metan aca en la animacion entran a la caja
			soul2 = (String)personas.FRENTE();
			personas.QUITA_DE_COLA();
			gente_en_Cola = gente_en_Cola-1;
			// puede ser llave de dibujo, y utlizar otros codigos para posicion
			tipoTran2 = random.nextInt(2);
			temp2 = (random.nextInt(49951)+50);
			if(tipoTran2==0){
				deposito2=boxBan2k.deposita(temp2);
				if(deposito2){
					montoDep2 = (montoDep2 + temp2);
					clientes_atendidos++;
					if(!retira2){
						retira2=true;
					}
				}
			}else if(retira2){
				retira2 = (boxBan2k.retira(temp2));
				if(retira2){
					montoRet2 = (montoRet2 + temp2);
					clientes_atendidos++;
					if(!deposito2){
						deposito2 = true;
					}
				}
			}
		}
		if(!ocupado3){
			ocupado3 = true;
			//hasta que se metan aca en la animacion entran a la caja
			soul3 = (String)personas.FRENTE();
			personas.QUITA_DE_COLA();
			gente_en_Cola = gente_en_Cola-1;
			// puede ser llave de dibujo, y utlizar otros codigos para posicion
			tipoTran3 = random.nextInt(2);
			temp3 = (random.nextInt(49951)+50);
			if(tipoTran3==0){
				deposito3=boxBan3k.deposita(temp3);
				if(deposito3){
					montoDep3 = (montoDep3 + temp3);
					clientes_atendidos++;
					if(!retira3){
						retira3=true;
					}
				}
			}else if(retira3){
				retira3 = (boxBan3k.retira(temp3));
				if(retira3){
					montoRet3 = (montoRet3 + temp3);
					clientes_atendidos++;
					if(!deposito3){
						deposito3 = true;
					}
				}
			}
		}
		if(!ocupado4){
			ocupado4 = true;
			//hasta que se metan aca en la animacion entran a la caja
			soul4 = (String)personas.FRENTE();
			personas.QUITA_DE_COLA();
			gente_en_Cola = gente_en_Cola-1;
			// puede ser llave de dibujo, y utlizar otros codigos para posicion
			tipoTran4 = random.nextInt(2);
			System.out.println("Tipo de tran4 "+tipoTran4);
			temp4 = (random.nextInt(49951)+50);
			if(tipoTran4==0){
				deposito4=boxBan4k.deposita(temp4);
				if(deposito4){
					montoDep4 = (montoDep4 + temp4);
					clientes_atendidos++;
					if(!retira4){
						retira4=true;
					}
				}
			}else if(retira4){
				retira4 = (boxBan4k.retira(temp4));
				if(retira4){
					montoRet4 = (montoRet4 + temp4);
					clientes_atendidos++;
					if(!deposito4){
						deposito4 = true;
					}
				}
			}
		}
	}
	int nt = 0;
	public void iniciarCaja() {
		for(;c500<500;c500++){
			boxBan1k.p500.METE(Dinero.Quinientos);
			boxBan2k.p500.METE(Dinero.Quinientos);
			boxBan3k.p500.METE(Dinero.Quinientos);
			boxBan4k.p500.METE(Dinero.Quinientos);
		}
		for(;c100<=500;c100++){
			boxBan1k.p100.METE(Dinero.Cien);
			boxBan2k.p100.METE(Dinero.Cien);
			boxBan3k.p100.METE(Dinero.Cien);
			boxBan4k.p100.METE(Dinero.Cien);
		}
		for(;c50<500;c50++){
			boxBan1k.p50.METE(Dinero.Cincuenta);
			boxBan2k.p50.METE(Dinero.Cincuenta);
			boxBan3k.p50.METE(Dinero.Cincuenta);
			boxBan4k.p50.METE(Dinero.Cincuenta);
		}
		for(;c20<500;c20++){
			boxBan1k.p20.METE(Dinero.Veinte);
			boxBan2k.p20.METE(Dinero.Veinte);
			boxBan3k.p20.METE(Dinero.Veinte);
			boxBan4k.p20.METE(Dinero.Veinte);
		}
		for(;c10<500;c10++){
			boxBan1k.p10.METE(Dinero.Diez);
			boxBan2k.p10.METE(Dinero.Diez);
			boxBan3k.p10.METE(Dinero.Diez);
			boxBan4k.p10.METE(Dinero.Diez);
		}
		for(;c5<500;c5++){
			boxBan1k.p5.METE(Dinero.Cinco);
			boxBan2k.p5.METE(Dinero.Cinco);
			boxBan3k.p5.METE(Dinero.Cinco);
			boxBan4k.p5.METE(Dinero.Cinco);
		}
		for(;c2<500;c2++){
			boxBan1k.p2.METE(Dinero.Dos);
			boxBan2k.p2.METE(Dinero.Dos);
			boxBan3k.p2.METE(Dinero.Dos);
			boxBan4k.p2.METE(Dinero.Dos);
		}
		for(;c1<500;c1++){
			boxBan1k.p1.METE(Dinero.Uno);
			boxBan2k.p1.METE(Dinero.Uno);
			boxBan3k.p1.METE(Dinero.Uno);
			boxBan4k.p1.METE(Dinero.Uno);
			nt=nt+1;
			//System.out.println(c1);
		}
		//boxBan4k.p1.pila.contenedor.imprimeLista();
		//System.out.println(" "+c2);
		System.out.println("e "+nt);
	}
}

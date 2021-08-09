package Principal;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


import Banco.Images;
import Banco.Procesos;
import Clases.Movimiento;

public class BancoS extends Canvas implements KeyListener{
	private JFrame ventana;
	private BufferStrategy dobleBuffer;
	private Graphics2D g2D;
	
	private boolean activo  = false;
	private boolean inicio  = false;

	public static final int ANCHO_VENTANA = 1100;
	public static final int ALTO_VENTANA = 872;
	
	int lastFpsTime; 
	int fps; 
	
	private HashMap<String,BufferedImage> imagenes = new HashMap<String,BufferedImage>();
	private HashMap<String,BufferedImage> movCliente = new HashMap<String,BufferedImage>();
	//private HashMap<Integer,BufferedImage> clientes = new HashMap<Integer,BufferedImage>();
	
	private Images fondo;
	private Images posfondo;
	private Images caja1;
	private Images caja2;
	private Images caja3;
	private Images caja4;
	
	public Movimiento cl1;
	public Movimiento cl2;
	public Movimiento cl3;
	public Movimiento cl4;
	public Movimiento cl5;
	public Movimiento cl6;
	public Movimiento cl7;
	public Movimiento cl8;
	public Movimiento cl9;
	public Movimiento cl10;
	public Movimiento cl11;
	public Movimiento cl12;
	public Movimiento cl13;
	public Movimiento cl14;
	
	Font fuente = new Font("Monospaced", Font.BOLD, 30);
	Font fuente1 = new Font("Calibri", Font.BOLD, 12);
	Font fuente2 = new Font("Times New Roman", Font.BOLD, 25);
	
	private Movimiento mov = new Movimiento(0,0,"");
	
	//private Banco bank = new Banco();
	private Procesos proc = new Procesos();
	
	public BancoS(){
		cargarImagenes();
		inicializarObjetosJuego();
		
		ventana = new JFrame(); 
		ventana.setIconImage(Toolkit.getDefaultToolkit().getImage(Clases.Principal.class.getResource("/recursos/Icono.png")));
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventana.setSize(ANCHO_VENTANA, ALTO_VENTANA); 
		ventana.setLocationRelativeTo(null); 
		ventana.setTitle("Banco"); 
		ventana.getContentPane().add(this); 
		ventana.setVisible(true); 
		
		createBufferStrategy(2); 
		dobleBuffer = getBufferStrategy();
		activo = true; 	
		this.requestFocus(); 
		this.addKeyListener(this);
		
		cicloPrincipal(); 
	}
	
	public void inicializarObjetosJuego(){
		fondo = new Images(0,0,"fondo");
		posfondo = new Images(0,0,"posfondo");
		caja1 = new Images(0,0,"caja1");
		caja2 = new Images(0,0,"caja2");
		caja3 = new Images(0,0,"caja3");
		caja4 = new Images(0,0,"caja4");
		
		cl1 = new Movimiento(0,0,"");
		cl2 = new Movimiento(0,0,"");
		cl3 = new Movimiento(0,0,"");
		cl4 = new Movimiento(0,0,"");
		cl5 = new Movimiento(0,0,"");
		cl6 = new Movimiento(0,0,"");
		cl7 = new Movimiento(0,0,"");
		cl8 = new Movimiento(0,0,"");
		cl9 = new Movimiento(0,0,"");
		cl10 = new Movimiento(0,0,"");
		cl11 = new Movimiento(0,0,"");
		cl12 = new Movimiento(0,0,"");
		cl13 = new Movimiento(0,0,"");
		cl14 = new Movimiento(0,0,"");
	}
	
	//Cargar Imagenes
	public void cargarImagenes(){
		try {
			imagenes.put("fondo", ImageIO.read(getClass().getResource("/recursos/fondo.png")));
			imagenes.put("posfondo", ImageIO.read(getClass().getResource("/recursos/escritorios.png")));
			imagenes.put("caja1", ImageIO.read(getClass().getResource("/recursos/caja_1.png")));
			imagenes.put("caja2", ImageIO.read(getClass().getResource("/recursos/caja_2.png")));
			imagenes.put("caja3", ImageIO.read(getClass().getResource("/recursos/caja_3.png")));
			imagenes.put("caja4", ImageIO.read(getClass().getResource("/recursos/caja_4.png")));
			
			movCliente.put("1st", ImageIO.read(getClass().getResource("/recursos/capa_07 2.png")));
			movCliente.put("2nd", ImageIO.read(getClass().getResource("/recursos/capa_08 2.png")));
			movCliente.put("3th", ImageIO.read(getClass().getResource("/recursos/capa_09 2.png")));
			movCliente.put("4th", ImageIO.read(getClass().getResource("/recursos/capa_10 2.png")));
			movCliente.put("5th", ImageIO.read(getClass().getResource("/recursos/fila5.png")));
			movCliente.put("6th", ImageIO.read(getClass().getResource("/recursos/fila6.png")));
			movCliente.put("pll", ImageIO.read(getClass().getResource("/recursos/capa_17 2.png"))); //fila caja 1
			movCliente.put("ca1", ImageIO.read(getClass().getResource("/recursos/capa_14 2.png"))); //fila caja 1
			movCliente.put("ca2", ImageIO.read(getClass().getResource("/recursos/capa_11 2.png"))); //fila caja 2
			movCliente.put("plr", ImageIO.read(getClass().getResource("/recursos/capa_15 2.png"))); //fila caja 2
			movCliente.put("prl", ImageIO.read(getClass().getResource("/recursos/capa_18 2.png"))); //fila caja 3 bajo
			movCliente.put("ca4", ImageIO.read(getClass().getResource("/recursos/capa_13 2.png"))); //fila caja 3 alto
			movCliente.put("prr", ImageIO.read(getClass().getResource("/recursos/capa_16.png")));
			movCliente.put("ca3", ImageIO.read(getClass().getResource("/recursos/capa_12.png")));
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private void pintar(){
        g2D = (Graphics2D)dobleBuffer.getDrawGraphics();       
        
        //inicio = true;
        fondo.pintar(g2D, imagenes.get(fondo.getLlaveImagen()), this);
        if(mov.cuenta()>75){
        	if(mov.cuenta()>300){
        		caja1.pintar(g2D, imagenes.get(caja1.getLlaveImagen()), this);
        	}
        	if(mov.cuenta()>500){
        		caja2.pintar(g2D, imagenes.get(caja2.getLlaveImagen()), this);
        	}
        	if(mov.cuenta()>700){
        		caja3.pintar(g2D, imagenes.get(caja3.getLlaveImagen()), this);
        	}
        	if(mov.cuenta()>900){
        		caja4.pintar(g2D, imagenes.get(caja4.getLlaveImagen()), this);
        		inicio = true;
        	}
        	posfondo.pintar(g2D, imagenes.get(posfondo.getLlaveImagen()), this);
        }
        
        if(!mov.isCerrado()){
        	g2D.setColor(Color.BLACK);
    		g2D.setFont(fuente);
    		g2D.drawString(("Pulse X para salir"), 20, 50);
        	/*cl1.pintar(g2D, clientes.get(cl1.getLlave()), this);
        	if(mov.cuenta2()>75){
        		cl2.pintar(g2D, clientes.get(cl2.getLlave()), this);
        	}
        	if(mov.cuenta2()>150){
        		cl3.pintar(g2D, clientes.get(cl3.getLlave()), this);
        	}
        	if(mov.cuenta2()>225){
        		cl4.pintar(g2D, clientes.get(cl4.getLlave()), this);
        	}
        	if(mov.cuenta2()>300){
        		cl5.pintar(g2D, clientes.get(cl5.getLlave()), this);
        	}
        	if(mov.cuenta2()>375){
        		cl6.pintar(g2D, clientes.get(cl6.getLlave()), this);
        	}*/
        	//bank.nuevoCliente();
        	//((Cliente)bank.clientes.FRENTE()).pintar(g2D,clientes.get(((Cliente)bank.clientes.FRENTE()).getLlave()),this);
        }
        
        if((!proc.isTerminar())&&(!mov.isCerrado())){
        	proc.tiempo++;
        	if(proc.tiempo>=50){
        		proc.tiempo=0;
        		proc.personas.PONE_EN_COLA("Cliente "+ (proc.gente_en_Cola+1));
        		proc.gente_en_Cola++;
        		if(proc.firstTime){
            		proc.iniciarCaja();
            	}
        		proc.firstTime = false;
        	}
        	if(!proc.firstTime){
        		proc.to1++;
        		proc.to2++;
        		proc.to3++;
        		proc.to4++;
        		if(proc.n>50){
        			proc.n = proc.random.nextInt(50);
        			proc.personas.PONE_EN_COLA("Cliente "+ (proc.gente_en_Cola+1));
            		proc.gente_en_Cola++;
            		if(proc.n>=25){
            			proc.personas.PONE_EN_COLA("Cliente "+ (proc.gente_en_Cola+1));
                		proc.gente_en_Cola++;
            		}
            		if(proc.n>=35){
            			proc.personas.PONE_EN_COLA("Cliente "+ (proc.gente_en_Cola+1));
                		proc.gente_en_Cola++;
            		}
        		}
        		proc.n++;
        		if((proc.c1==500)&&(proc.n1>=30)&&(proc.gente_en_Cola>=4)){
        			//proc.n1 = proc.random.nextInt(50);
        			proc.n1=0;
					//logger.log("Soy yo "+proc.c1);
        			System.out.println(" It's me"+proc.c1);
        			proc.transaccion();
        		}
        		proc.n1++;
        	}
        	
        	if(proc.gente_en_Cola==1){
        		if(proc.n2>=3){
        			cl1.setX(proc.random.nextInt(10));
        			cl1.setY(proc.random.nextInt(10));
        			proc.n2=0;
        		}        		
        		cl1.pintar(g2D, movCliente.get("1st"), this);
        	}
        	if(proc.gente_en_Cola==2){
        		if(proc.n2>=3){
        			cl1.setX(proc.random.nextInt(10));
        			cl1.setY(proc.random.nextInt(10));
        			cl2.setX(proc.random.nextInt(10));
        			cl2.setY(proc.random.nextInt(10));
        			proc.n2=0;
        		}        		
        		cl1.pintar(g2D, movCliente.get("1st"), this);
        		cl2.pintar(g2D, movCliente.get("2nd"), this);
        	}
        	if(proc.gente_en_Cola==3){
        		if(proc.n2>=3){
        			cl1.setX(proc.random.nextInt(7));
        			cl1.setY(proc.random.nextInt(7));
        			cl2.setX(proc.random.nextInt(7));
        			cl2.setY(proc.random.nextInt(7));
        			cl3.setX(proc.random.nextInt(7));
        			cl3.setY(proc.random.nextInt(7));
        			proc.n2=0;
        		}        		
        		cl1.pintar(g2D, movCliente.get("1st"), this);
        		cl2.pintar(g2D, movCliente.get("2nd"), this);
        		cl3.pintar(g2D, movCliente.get("3th"), this);
        	}
        	if(proc.gente_en_Cola==4){
        		if(proc.n2>=3){
        			cl1.setX(proc.random.nextInt(7));
        			cl1.setY(proc.random.nextInt(7));
        			cl2.setX(proc.random.nextInt(7));
        			cl2.setY(proc.random.nextInt(7));
        			cl3.setX(proc.random.nextInt(7));
        			cl2.setY(proc.random.nextInt(7));
        			cl4.setX(proc.random.nextInt(7));
        			cl4.setY(proc.random.nextInt(7));
        			proc.n2=0;
        		}
        		cl1.pintar(g2D, movCliente.get("1st"), this);
        		cl2.pintar(g2D, movCliente.get("2nd"), this);
        		cl3.pintar(g2D, movCliente.get("3th"), this);
        		cl4.pintar(g2D, movCliente.get("4th"), this);
        	}
        	if(proc.gente_en_Cola==5){
        		if(proc.n2>=3){
        			cl1.setX(proc.random.nextInt(7));
        			cl1.setY(proc.random.nextInt(7));
        			cl2.setX(proc.random.nextInt(7));
        			cl2.setY(proc.random.nextInt(7));
        			cl3.setX(proc.random.nextInt(7));
        			cl2.setY(proc.random.nextInt(7));
        			cl4.setX(proc.random.nextInt(7));
        			cl4.setY(proc.random.nextInt(7));
        			cl5.setX(proc.random.nextInt(7));
        			cl5.setY(proc.random.nextInt(7));
        			proc.n2=0;
        		}
        		cl1.pintar(g2D, movCliente.get("1st"), this);
        		cl2.pintar(g2D, movCliente.get("2nd"), this);
        		cl3.pintar(g2D, movCliente.get("3th"), this);
        		cl4.pintar(g2D, movCliente.get("4th"), this);
        		cl5.pintar(g2D, movCliente.get("5th"), this);
        	}
        	if(proc.gente_en_Cola>=6){
        		if(proc.n2>=3){
        			cl1.setX(proc.random.nextInt(7));
        			cl1.setY(proc.random.nextInt(7));
        			cl2.setX(proc.random.nextInt(7));
        			cl2.setY(proc.random.nextInt(7));
        			cl3.setX(proc.random.nextInt(7));
        			cl2.setY(proc.random.nextInt(7));
        			cl4.setX(proc.random.nextInt(7));
        			cl4.setY(proc.random.nextInt(7));
        			cl5.setX(proc.random.nextInt(7));
        			cl5.setY(proc.random.nextInt(7));
        			cl6.setX(proc.random.nextInt(7));
        			cl6.setY(proc.random.nextInt(7));
        			proc.n2=0;
        		}
        		cl1.pintar(g2D, movCliente.get("1st"), this);
        		cl2.pintar(g2D, movCliente.get("2nd"), this);
        		cl3.pintar(g2D, movCliente.get("3th"), this);
        		cl4.pintar(g2D, movCliente.get("4th"), this);
        		cl5.pintar(g2D, movCliente.get("5th"), this);
        		cl6.pintar(g2D, movCliente.get("6th"), this);
        	}
        	proc.n2++;
        	
        	if(proc.ocupado1){
        		if(proc.to1<=17){
        			cl7.pintar(g2D, movCliente.get("pll"), this);
        		}else{
        			cl7.pintar(g2D, movCliente.get("ca1"), this);
        		}
        	}
        	if(proc.ocupado2){
        		if(proc.to2<=20){
        			cl8.pintar(g2D, movCliente.get("plr"), this);
        		}else{
        			cl8.pintar(g2D, movCliente.get("ca2"), this);
        		}
        	}
        	if(proc.ocupado3){
        		if(proc.to3<=15){
        			cl9.pintar(g2D, movCliente.get("prr"), this);
        		}else{
        			cl9.pintar(g2D, movCliente.get("ca3"), this);
        		}
        	}
        	if(proc.ocupado4){
        		if(proc.to4<=15){
        			cl10.pintar(g2D, movCliente.get("prl"), this);
        		}else{
        			cl10.pintar(g2D, movCliente.get("ca4"), this);
        		}
        	}
        }
        //de prueba
        /*if(proc.ocupado1){
			if(proc.to1>=60){
				proc.ocupado1=false;
				proc.to1=0;
			}
		}
		if(proc.ocupado2){
			if(proc.to2>=80){
				proc.ocupado2=false;
				proc.to2=0;
			}
		}
		if(proc.ocupado3){
			if(proc.to3>=65){
				proc.ocupado3=false;
				proc.to3=0;
			}
		}
		if(proc.ocupado4){
			if(proc.to4>=60){
				proc.ocupado4=false;
				proc.to4=0;
			}
		}*/
		
        if(proc.isTerminar()){
        	g2D.setFont(fuente2);
        	g2D.setColor(Color.BLACK);
            g2D.fillRect(20, 230, 300, 500);
            g2D.setColor(Color.GREEN);
            g2D.drawRect(20, 230, 300, 500);
            g2D.setColor(Color.white);
            g2D.drawString("Clientes Atendidos: " + proc.clientes_atendidos, 30, 275);
            g2D.drawString("Clientes en cola: " + proc.gente_en_Cola, 30, 300);
        	g2D.drawString(("--------------------------"), 30, 325);
        	g2D.drawString("Caja 1:", 30, 350);
        	g2D.drawString("Retiros: " + proc.montoRet1, 35, 375);
        	g2D.drawString("Depositos: " + proc.montoDep1, 35, 400);
        	g2D.drawString("Caja 2:", 30, 425);
        	g2D.drawString("Retiros: " + proc.montoRet2, 35, 450);
        	g2D.drawString("Depositos: " + proc.montoDep2, 35, 475);
        	g2D.drawString("Caja 3:", 30, 500);
        	g2D.drawString("Retiros: " + proc.montoRet3, 35, 525);
        	g2D.drawString("Depositos: " + proc.montoDep3, 35, 550);
        	g2D.drawString("Caja 4:", 30, 575);
        	g2D.drawString("Retiros: " + proc.montoRet4, 35, 600);
        	g2D.drawString("Depositos: " + proc.montoDep4, 35, 625);
        	g2D.drawString(("--------------------------"), 30, 650);
            g2D.drawString(("Retiro Total: " + (proc.montoRet1+proc.montoRet2+proc.montoRet3+proc.montoRet4)), 30, 675);
            g2D.drawString(("Deposito Total: " + (proc.montoDep1+proc.montoDep2+proc.montoDep3+proc.montoDep4)), 30, 700); 
        }
        //Pulse Barra Espaciadora
        g2D.setFont(fuente);
        if(mov.isCerrado()&&inicio){
        	g2D.setColor(Color.BLACK);
            g2D.fillRect(40, 490, 900, 240);
            g2D.setColor(Color.GREEN);
            g2D.drawRect(40,490,900,240);
            g2D.setColor(Color.WHITE);
            g2D.drawString((""+mov.cerrado()), 50, 545);
        	g2D.drawString(("Presione Barra Espaceadora"), 50, 620);
        	g2D.drawString(("Para Abrir"), 50, 695);
        }else{
        	if(!mov.isCerrado()){
        		g2D.setFont(fuente1);
            	g2D.setColor(Color.WHITE);
                g2D.fillRect(860, 15, 170, 190);
                g2D.setColor(Color.ORANGE);
                g2D.drawRect(860, 15, 170, 190);
                g2D.setColor(Color.BLACK);
                g2D.drawString("Clientes Atendidos: " + proc.clientes_atendidos, 865, 30);
                g2D.drawString("Clientes en cola: " + proc.gente_en_Cola, 865, 40);
            	g2D.drawString(("--------------------------"), 865, 50);
            	g2D.drawString("Caja 1:", 865, 60);
            	g2D.drawString("Retiros: " + proc.montoRet1, 870, 70);
            	g2D.drawString("Depositos: " + proc.montoDep1, 870, 80);
            	g2D.drawString("Caja 2:", 865, 90);
            	g2D.drawString("Retiros: " + proc.montoRet2, 870, 100);
            	g2D.drawString("Depositos: " + proc.montoDep2, 870, 110);
            	g2D.drawString("Caja 3:", 865, 120);
            	g2D.drawString("Retiros: " + proc.montoRet3, 870, 130);
            	g2D.drawString("Depositos: " + proc.montoDep3, 870, 140);
            	g2D.drawString("Caja 4:", 865, 150);
            	g2D.drawString("Retiros: " + proc.montoRet4, 870, 160);
            	g2D.drawString("Depositos: " + proc.montoDep4, 870, 170);
            	g2D.drawString(("--------------------------"), 865, 180);
                g2D.drawString(("Retiro Total: " + (proc.montoRet1+proc.montoRet2+proc.montoRet3+proc.montoRet4)), 865, 190);
                g2D.drawString(("Deposito Total: " + (proc.montoDep1+proc.montoDep2+proc.montoDep3+proc.montoDep4)), 865, 200);                
        	}
        }
        
        dobleBuffer.show(); //Mostrar lo que se ha dibujado
	}
	
	public void actualizar(){
		//Agregue aqui el codigo necesario para actualizar los componentes de juego y construir la logica del juego
		//mov.cuenta();
	}

	public void cicloPrincipal(){
       //variables para el calculo del tiempo para la pausa, este codigo es opcional, si lo desea puede definir un valor para la pausa en duro.
	   long lastLoopTime = System.nanoTime(); 
       final int TARGET_FPS = 60;
       final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
       
       while (activo){
    	   //Calculo del tiempo optimo y uniforme para la pausa.
    	   long now = System.nanoTime();
    	   long updateLength = now - lastLoopTime;
    	   lastLoopTime = now;
    	   //double delta = updateLength / ((double)OPTIMAL_TIME);
    	   lastFpsTime += updateLength;
    	   fps++;
    	   if (lastFpsTime >= 1000000000){
    		  //System.out.println("(FPS: "+fps+")");
    		   lastFpsTime = 0;
    		   fps = 0;
    	   }
    	   //Fin del calculo del tiempo optimo y uniforme para la pausa.
    	   
    	   //Metodos para pintar el lienzo y actualizar los componentes de juego
    	   pintar();    	   
    	   actualizar();
    	   
    	   //Aplicar la pausa.
    	   try{Thread.sleep((lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 );} //Puede sustituir el valor de la pausa por un valor fijo
    	   catch(Exception e){
			   System.out.println("Funcionando");
		   };
       }
    }
		
	//Metodo que se ejecuta cuando el usuario presiona una tecla
	public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
        	case KeyEvent.VK_SPACE:{
        		if(inicio){
        			mov.setCerrado(false);
        		}
        	}break;

        	case KeyEvent.VK_X:{
        		if((inicio)&&(!mov.isCerrado())){
        			proc.setTerminar(true);
        		}
        	}break;
        }
    }

	//Metodo que se ejecuta cuando el usuario suelta una tecla
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
	        case KeyEvent.VK_SPACE:{
	        }break;
	        case KeyEvent.VK_X:{
	        }break;
        }
    }    
    //Sin uso, pero a fuerzas se debe redefinir
  	public void keyTyped(KeyEvent e) {}
	
    public static void main(String[] args){
		new BancoS();
	}
}
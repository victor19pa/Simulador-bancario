package Clases;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import Principal.BancoS;

public class Movimiento {
	private int x;
	private int y;
	private String llaveImagen;
	
	private int cont1 = 1;
	private int cont2 = 1;
	
	private boolean cerrado = true;
	
	public Movimiento( int x, int y, String llaveImagen) {
		this.x = x;
		this.y = y;

		this.llaveImagen = llaveImagen;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	public boolean isCerrado() {
		return cerrado;
	}

	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}
	

	public int getCont1() {
		return cont1;
	}

	public void setCont1(int cont1) {
		this.cont1 = cont1;
	}

	public void pintar(Graphics2D g2D, 
			BufferedImage imagen, 
			ImageObserver canvas){
		g2D.drawImage(imagen, 
        		x, 
        		y, 
        		canvas);
	}
	
	public int cuenta(){
		if (cont1<=10000){
			return cont1++;
		}else{
			return 10000;
		}		
	}
	
	public int cuenta2(){
		if (cont2<=10000){
			return cont2++;
		}else{
			return 10000;
		}
	}
	
	
	public String cerrado(){
		if(cerrado==true){
			return "Banco Cerrado ";	
		}else{
			return "Banco Abierto";
		}
	}
}


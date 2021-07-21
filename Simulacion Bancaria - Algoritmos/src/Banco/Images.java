package Banco;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import Principal.BancoS;

public class Images {
	int x;
	int y;
	String llaveImagen;
	
	public Images(int x, int y, String llaveImagen) {
		super();
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


	public String getLlaveImagen() {
		return llaveImagen;
	}


	public void setLlaveImagen(String llaveImagen) {
		this.llaveImagen = llaveImagen;
	}


	public void pintar(Graphics2D g2D,
			BufferedImage imagen,
			ImageObserver canvas){
		g2D.drawImage(imagen, 
        		x, 
        		y, 
        		canvas);
	}
	
	public void mover(){
		
	}

}

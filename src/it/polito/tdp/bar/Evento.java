package it.polito.tdp.bar;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class Evento {
	
	public enum TipoEvento{
		ARRIVO_GRUPPO_CLIENTI ,
		USCITA , 
		SEDUTI , 
	}
	
	private LocalTime time ;
	private TipoEvento tipo ;
	private int numPersone ;
	private Duration permanenza ;
	private double tolleranza ;
	
	public int getNumPersone() {
		return numPersone;
	}

	public void setNumPersone(int numPersone) {
		this.numPersone = numPersone;
	}

	public TipoEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Duration getPermanenza() {
		return permanenza;
	}

	public void setPermanenza(Duration permanenza) {
		this.permanenza = permanenza;
	}

	public double getTolleranza() {
		return tolleranza;
	}

	public void setTolleranza(double tolleranza) {
		this.tolleranza = tolleranza;
	}

	private Random x = new Random() ;
	
	public Evento(LocalTime time, TipoEvento tipo ) {
		
		
		
		this.time = time ;
		this.tipo = tipo;
		int j = 1;
		int n = 10-j;
		int k = x.nextInt(n)+j;
		this.numPersone = k ;
				
		this.permanenza = Duration.ofMinutes(60 + x.nextInt(60+1));
		this.tolleranza = 0.0 + 0.9*x.nextDouble();
		
	}
	

}

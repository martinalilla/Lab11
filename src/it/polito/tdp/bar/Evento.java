package it.polito.tdp.bar;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class Evento {
	
	public enum TipoEvento{
		ARRIVO_GRUPPO_CLIENTI ,
		USCITA , 
	}
	
	private LocalTime time ;
	private TipoEvento tipo ;
	private int numPersone ;
	private Duration permanenza ;
	private double tolleranza ;
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

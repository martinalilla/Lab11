package it.polito.tdp.bar;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Random;

import it.polito.tdp.bar.Evento.TipoEvento;

public class Simulatore {
	//coda degli eventi 
	private PriorityQueue<Evento> queue = new PriorityQueue<>();

	
	//Modello del mondo
	private HashMap<Integer, Integer > numTavoli = new HashMap <Integer, Integer>();
	
	//Parametri di simulazione
	
	//statistiche da calcolare
	private int numTotClienti ;
	private int numClientiIns ;
	private int numClientiSod ;
	
	
	
	public void init() {
		numTavoli.clear();
		numTavoli.put(10, 2);
		numTavoli.put(8, 4);
		numTavoli.put(6, 4);
		numTavoli.put(4, 5);
		
		riempiCoda(2000);
		
	}
	
	public void run() {
		
	}
	
	
	public void riempiCoda(int numArrivi) {
		LocalTime ora = LocalTime.now();
		 Random x = new Random() ;
		for(int i=0; i<numArrivi; i++) {
			
			Evento ev = new Evento(ora, TipoEvento.ARRIVO_GRUPPO_CLIENTI) ;
			int j = 1;
			int n = 10-j;
			int k = x.nextInt(n)+j;
			ora.plusMinutes(k) ;
			queue.add(ev) ;
		}
	}

}

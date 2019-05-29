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
	//private HashMap<Integer, Integer > numTavoli = new HashMap <Integer, Integer>();
	private int tavolo10;
	private int tavolo8;
	private int tavolo6;
	private int tavolo4;
	
	//Parametri di simulazione
	
	//statistiche da calcolare
	private int numTotClienti ;
	private int numClientiIns ;
	private int numClientiSod ;
	
	
	
	public void init() {
		/*numTavoli.clear();
		numTavoli.put(10, 2);
		numTavoli.put(8, 4);
		numTavoli.put(6, 4);
		numTavoli.put(4, 5);*/
		
		riempiCoda(2000);
		tavolo10=2;
		tavolo8=4;
		tavolo6=4;
		tavolo4=5;
		
		numTotClienti=0;
		numClientiIns=0;
		numClientiSod=0;
		
	}
	
	public void run() {
		while(!queue.isEmpty()) {
			Evento ev = queue.poll();
			System.out.println(ev);
			
			
			switch (ev.getTipo()) {
			case ARRIVO_GRUPPO_CLIENTI :
				Random x = new Random();
				double confronto = 0.0 + 0.9*x.nextDouble();
				
				if(ev.getNumPersone()<=tavolo4  && tavolo4>0  ) {
					if(ev.getNumPersone()>=2) {
						tavolo4--;
						queue.add(new Evento(ev.getTime().plusMinutes(ev.getPermanenza().toMinutes()), TipoEvento.SEDUTI));
					}else if(ev.getNumPersone()<2) {
						if(confronto>ev.getTolleranza()) {
							numClientiSod+=ev.getNumPersone();
						}
						else if(confronto<=ev.getTolleranza()) {
							
							queue.add(new Evento(ev.getTime(), TipoEvento.USCITA));
						}
					}
					
					
				}else
                 if(ev.getNumPersone()<=tavolo6 && tavolo6>0) {
                	 if(ev.getNumPersone()>=3) {
 						tavolo6--;
 						queue.add(new Evento(ev.getTime().plusMinutes(ev.getPermanenza().toMinutes()), TipoEvento.SEDUTI));
 					}else if(ev.getNumPersone()<3) {
 						if(confronto>ev.getTolleranza()) {
 							numClientiSod+=ev.getNumPersone();
 						}
 						else if(confronto<=ev.getTolleranza()) {
 							
 							queue.add(new Evento(ev.getTime(), TipoEvento.USCITA));
 						}
 					}
                	 
					
				}
                 else if(ev.getNumPersone()<=tavolo8 && tavolo8>0) {
                	 if(ev.getNumPersone()>=4) {
  						tavolo8--;
  						queue.add(new Evento(ev.getTime().plusMinutes(ev.getPermanenza().toMinutes()), TipoEvento.SEDUTI));
  					}else if(ev.getNumPersone()<4) {
  						if(confronto>ev.getTolleranza()) {
  							numClientiSod+=ev.getNumPersone();
  						}
  						else if(confronto<=ev.getTolleranza()) {
  							
  							queue.add(new Evento(ev.getTime(), TipoEvento.USCITA));
  						}
  					}
               
 					
 				} else if(ev.getNumPersone()<=tavolo10 && tavolo4>0) {
 					 if(ev.getNumPersone()>=5) {
   						tavolo10--;
   						queue.add(new Evento(ev.getTime().plusMinutes(ev.getPermanenza().toMinutes()), TipoEvento.SEDUTI));
   					}else if(ev.getNumPersone()<5) {
   						if(confronto>ev.getTolleranza()) {
   							numClientiSod+=ev.getNumPersone();
   						}
   						else if(confronto<=ev.getTolleranza()) {
   							
   							queue.add(new Evento(ev.getTime(), TipoEvento.USCITA));
   						}
   					}
					
				}

				
				break;
			
			
			case USCITA : 
				numClientiIns+=ev.getNumPersone();
				break ;
				
			case SEDUTI :
				
				break ;
			
		}
	}
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

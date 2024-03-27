package controller;

import java.util.concurrent.Semaphore;

public class ThreadFood extends Thread{
	
	private int threadFood;
	private Semaphore semaforo;
	private int id;

	public ThreadFood (int threadFood, Semaphore semaforo, int id) {
		
		this.threadFood = threadFood;
		this.semaforo = semaforo;
		this.id = id;
		
	}
	
	@Override
	public void run() {
		
		byte prato;
		
		switch (id % 2) {
		
			case 0:
				
				prato = 1;
				
				System.out.println(id);
				
				cozimento(prato);
				break;
				
			default:
				
				prato = 0;
				
				System.out.println(id);
				
				cozimento(prato);
				break;
		
		}
		
	}
	
	public void cozimento(byte prato) {
		
		int tempo;
		float tempoTotal;
		int percentual;
		
		switch (prato) {
		
			case 1:
				
				tempo = (int)(Math.random() * 601) + 600;
				tempoTotal = tempo / 1000;
				percentual = 0;
				
				try {
					
					sleep (tempo);
					
					for (float i = 0.1f; i <= (tempoTotal + 0.1); i += 0.1) {
						
						percentual = (int)(i * 100);
						System.out.println("ID: " + id + " - Prato: Lasanha a Bolonhesa - " +
								percentual + "% Pronto.");
						
					}
					break;
				
				} catch (InterruptedException e) {
					
					e.printStackTrace();
					break;
				
				}
								
			case 0:
				
				tempo = (int)(Math.random() * 301) + 500;
				tempoTotal = tempo / 1000;
				percentual = 0;
				
				try {
					
					sleep (tempo);
					
					for (float i = 0.1f; i <= (tempoTotal + 0.1); i += 0.1) {
						
						percentual = (int)(i * 100);
						System.out.println("ID: " + id + " - Prato: Sopa de Cebola - " +
								percentual + "% Pronto.");
						
					}
					break;
				
				} catch (InterruptedException e) {
					
					e.printStackTrace();
					break;
				
				}	
				
		}
		
	}
	
}
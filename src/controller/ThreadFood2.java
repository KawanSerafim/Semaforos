package controller;

import java.util.concurrent.Semaphore;
import controller.ThreadFood;

public class ThreadFood2 extends Thread{
	
	ThreadFood threadFood = new ThreadFood();
	
	private static byte c = 0;
	
	private int tempo;
	private byte id;
	private String prato;
	private Semaphore semaforo;
	
	public ThreadFood2 (int tempo, byte id, String prato, Semaphore semaforo) {
		
		this.tempo = tempo;
		this.id = id;
		this.prato = prato;
		this.semaforo = semaforo;
		
	}
	
	@Override
	public void run() {
		
		c++;
		if (c == 1) {
			
			System.out.println("\n\n[ FASE DE COZIMENTO E ENTREGA ]\n");
			
		}
		
		int ptempo = tempo / 100;
		int ptempo2 = 0;
		double porcentagem = 0;
		
		while (porcentagem < 100) {
			
			try {
				
				ptempo2 += ptempo;
				porcentagem = ((ptempo2 * 100) / tempo) * 10;
				System.out.println("\nID: " + id + " - Prato: " + prato + " - Está " + 
						(porcentagem) + "% pronto.");
				sleep(100);
			
			} catch (InterruptedException e) {

				e.printStackTrace();
			
			}
			
		}
		
		threadFood.entrega(prato, id, semaforo);
		
	}
	
}
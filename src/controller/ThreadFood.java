package controller;

import java.util.concurrent.Semaphore;
import controller.ThreadFood2;

public class ThreadFood extends Thread{
	
	private int threadFood;
	private Semaphore semaforo;
	private byte id;

	public ThreadFood() {}
	
	public ThreadFood (int threadFood, Semaphore semaforo, byte id) {
		
		this.threadFood = threadFood;
		this.semaforo = semaforo;
		this.id = id;
		
	}

	@Override
	public void run() {
		
	    byte prato = (byte)(id % 2);
		
		switch (prato) {
		
			case 1:
				
				cozimento(prato, id);
				break;
				
			case 0:
		
				cozimento(prato, id);
				break;
				
		}
		
	}
	
	public void cozimento (byte prato, byte id) {
		
		int mili_Tempo = 0;
		byte seg_Tempo = 0;
		String nomePrato = "";
		
		switch (prato) {
		
			case 1:
				
				nomePrato = "Sopa de Cebola";
				mili_Tempo = (int)(Math.random() * 301) + 500;
				seg_Tempo = (byte)(mili_Tempo / 1000);
				
				
				try {
					
					Thread threadFood2 = new ThreadFood2(mili_Tempo, id, nomePrato);
					threadFood2.start();
					
					System.out.println("ID: " + id + " - Prato: Sopa de Cebola - Iniciou" + 
							" o seu preparo.");
					
					sleep(mili_Tempo);
				
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				
				}
				
				break;
				
			case 0:
				
				nomePrato = "Lasanha a Bolonhesa";
				mili_Tempo = (int)(Math.random() * 601) + 600;
				seg_Tempo = (byte)(mili_Tempo / 1000);
				
				
				try {
					
					System.out.println("ID: " + id + " - Prato: Lasanha a Bolonhesa - Iniciou" +
							" o seu preparo.");
					
					Thread threadFood2 = new ThreadFood2(mili_Tempo, id, nomePrato);
					threadFood2.start();
					sleep(mili_Tempo);
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				
				}
				
				break;
				
		}
		
	}
	
	public void entrega (String prato, byte id) {
		
		System.out.println("\nID: " + id + " - O prato: " + prato + " - Está pronto " + 
				"para entrega");
		
		try {
			
			semaforo.acquire();
			sleep(500);
			System.out.println("\nID: " + id + "- O prato: " + prato + " - Foi entrege.");
		
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		
		} finally {
			
			semaforo.release();
			
		}
		
	}
	
}
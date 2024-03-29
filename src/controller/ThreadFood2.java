package controller;

import controller.ThreadFood;

public class ThreadFood2 extends Thread{
	
	ThreadFood threadFood = new ThreadFood();

	private int tempo;
	private byte id;
	private String prato;
	
	public ThreadFood2 (int tempo, byte id, String prato) {
		
		this.tempo = tempo;
		this.id = id;
		this.prato = prato;
		
	}
	
	@Override
	public void run() {
		
		int ptempo = tempo / 100;
		int ptempo2 = 0;
		double porcentagem = 0;
		
		while (porcentagem < 100) {
			
			try {
				
				ptempo2 += ptempo;
				porcentagem = ((ptempo2 * 100) / tempo) * 10;
				System.out.println("\nID: " + id + " - Prato: " + prato + " - Está " + (porcentagem) + "% pronto.");
				sleep(100);
			
			} catch (InterruptedException e) {

				e.printStackTrace();
			
			}
			
		}
		
		threadFood.entrega(prato, id);
		
	}
	
}
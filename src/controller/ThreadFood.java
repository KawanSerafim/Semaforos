package controller;

import java.util.concurrent.Semaphore;

public class ThreadFood extends Thread{
	
	private int threadFood;
	private Semaphore semaforo;

	public ThreadFood (int threadFood, Semaphore semaforo) {
		
		this.threadFood = threadFood;
		this.semaforo = semaforo;
		
	}
	
	@Override
	public void run() {

		
	
	}
	
}

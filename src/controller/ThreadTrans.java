package controller;

import java.util.concurrent.Semaphore;

public class ThreadTrans extends Thread{

	private int threadTrans;
	private Semaphore semaforo;
	
	public ThreadTrans (int threadTrans, Semaphore semaforo) {
		
		this.threadTrans = threadTrans;
		this.semaforo = semaforo;
		
	}
	
	@Override
	public void run() {
	
		threadTrans++;
		
		if ((threadTrans % 3) == 1) {
			
			int tipo = 1;
			
			calculo(tipo);
			
			try {
				
				semaforo.acquire();
				bancoDados(tipo);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			} finally {
			
				semaforo.release();
			
				calculo(tipo);
			
			}
			
			try {
				
				semaforo.acquire();
				bancoDados(tipo);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			semaforo.release();
			
		}
		else if ((threadTrans % 3) == 2) {
			
			int tipo = 2;
			
			calculo(tipo);

			try {
				
				semaforo.acquire();
				bancoDados(tipo);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			} finally {
				semaforo.release();
			
				calculo(tipo);
			
			}	
				
			try {
				
				semaforo.acquire();
				bancoDados(tipo);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			} finally {
				semaforo.release();
			
				calculo(tipo);
			
			}

			try {
				
				semaforo.acquire();
				bancoDados(tipo);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			semaforo.release();
			
		} 
		else if ((threadTrans % 3) == 0) {
			
			int tipo = 3;
			
			calculo(tipo);

			try {
				
				semaforo.acquire();
				bancoDados(tipo);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			} finally {
				semaforo.release();
			
				calculo(tipo);
			
			}

			try {
				
				semaforo.acquire();
				bancoDados(tipo);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			} finally {
				semaforo.release();
			
				calculo(tipo);
			
			}

			try {
				
				semaforo.acquire();
				bancoDados(tipo);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			semaforo.release();
			
		}
		
	}
	
	public void calculo(int tipo) {
		
		if (tipo == 1) {
			
			int tempo = (int)(Math.random() * 801) + 200;
			
			try {
				
				sleep(tempo);
				
				System.out.println("ID: " + threadTrans + " - Realizou um cálculo em " +
						tempo + "ms.");
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
		}
		else if (tipo == 2) {
			
			int tempo = (int)(Math.random() * 1001) + 500;
			
			try {
				
				sleep(tempo);
				
				System.out.println("ID: " + threadTrans + " - Realizou um cálculo em " +
						tempo + "ms.");
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
		} else {
			
			int tempo = (int)(Math.random() * 1000) + 1000;
			
			try {
				
				sleep(tempo);
				
				System.out.println("ID: " + threadTrans + " - Realizou um cálculo em " +
						tempo + "ms.");
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	public void bancoDados(int tipo) {
		
		if (tipo == 1) {
			
			int tempo = 1000;
			
			try {
				
				sleep(tempo);
				
				System.out.println("ID: " + threadTrans + " - Realizou uma transação de BD em " +
						tempo + "ms.");
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
		}
		else if (tipo == 2) {
			
			int tempo = 1500;
			
			try {
				
				sleep(tempo);
				
				System.out.println("ID: " + threadTrans + " - Realizou uma transação de BD em " +
						tempo + "ms.");
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
		} else {
			
			int tempo = 1500;
			
			try {
				
				sleep(tempo);
				
				System.out.println("ID: " + threadTrans + " - Realizou uma transação de BD em " +
						tempo + "ms.");
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
}

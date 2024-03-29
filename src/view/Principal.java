package view;

import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;
import controller.*;

public class Principal {

	public static void main (String [] args) {
		
		int opc = 0;
		
		while (opc != 9) {
			
			opc = Integer.parseInt(JOptionPane.showInputDialog("MENU\n\n" + 
			
					"1 - Imprimir transições de cálculo e banco de dados de 21 threads.\n" +
					"2 - Simular um jogo de entrega de comidas.\n" +
					"9 - Sair."));
			
			switch (opc) {
			
				case 1:
					
					Semaphore semaforo = new Semaphore(1);
					
					for (int transThread = 0; transThread < 21; transThread++) {
						
						Thread threadTrans = new ThreadTrans(transThread, semaforo);
						threadTrans.start();
						
					}
					
					break;
					
				case 2:
					
					byte id = 0;
					
					Semaphore semaforo2 = new Semaphore(1);
					
					for (int foodThread = 0; foodThread < 5; foodThread++) {
						
						id++;
						Thread threadFood = new ThreadFood(foodThread, semaforo2, id);
						threadFood.start();
						
					}
					
					break;
					
				case 9:
					
					JOptionPane.showMessageDialog(null, "Saindo...");
					break;
					
				default:
					
					JOptionPane.showMessageDialog(null, "Essa opção não existe. Digite novamente.");
					
			
			}
			 
		}
		
	}
	
}

package view;

import java.util.concurrent.Semaphore;

import controller.RunController;

public class Main {

	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int i = 0; i < 4; i++) {
			Thread tpessoa = new RunController(i, semaforo);
			tpessoa.start();
		}
	}

}

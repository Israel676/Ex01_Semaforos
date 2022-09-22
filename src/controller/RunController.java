package controller;

import java.util.concurrent.Semaphore;

public class RunController extends Thread {
	
	private int idPessoa;
	private static int chegada;
	private Semaphore semaforo;
	
	public RunController(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		PessoaAndando();
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void PessoaAndando() {
		int distanciaTotal = 200;
		int distanciaPercorrida = 0;
		int deslocamento = (int)((Math.random() * 7) + 4);
		int tempo = 1000;
		while(distanciaPercorrida < distanciaTotal) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#"+idPessoa+" andou "+ distanciaPercorrida+"m ");			
		}
		chegada++;
		System.out.println("#"+ idPessoa + " foi o "+ chegada + "º a chegar");
		System.out.println("#"+ idPessoa + " atravessou a porta");
	}
}

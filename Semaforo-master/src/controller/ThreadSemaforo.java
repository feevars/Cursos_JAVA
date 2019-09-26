/**
 * Classe ThreadSemaforo que herda da classe Thread. Aqui se encontra as Threads da aplica��o.
 * @author Augusto Luiz Silva
 * @date: 10/04/18
 */
package controller;

import java.awt.Rectangle;
import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;


public class ThreadSemaforo extends Thread{
	private JLabel carro, semaforoVermelho, semaforoVerde;
	private JLabel fundoInicio;
	private JButton btnInicio;
	private int op;
	private static int aux;
	
	private Semaphore semaforo;
	
	/**
	 * Construtor
	 * @param carro recebe o JLabel correspondente ao carro em quest�o
	 * @param semaforoVermelho recebe o JLabel correspondente ao sem�foro vermelho em quest�o
	 * @param semaforoVerde recebe o JLabel correspondente ao sem�foro verde em quest�o
	 * @param semaforo recebe a vari�vel semaforo do tipo Semaphore
	 * @param fundoInicio recebe o JLabel do fundo de in�cio
	 * @param btnInicio recebe o JButton que quando clicado inicia a aplica��o
	 * @param op recebe um valor inteiro que ajudar� no desenvolvimento da l�gica
	 */
	
	public ThreadSemaforo(JLabel carro, JLabel semaforoVermelho, JLabel semaforoVerde,
			Semaphore semaforo, JLabel fundoInicio, JButton btnInicio, int op) {
		
		this.carro = carro;
		this.semaforoVermelho = semaforoVermelho;
		this.semaforoVerde = semaforoVerde;
		this.semaforo = semaforo;
		this.fundoInicio = fundoInicio;
		this.btnInicio = btnInicio;
		this.op = op;
		
	}
	
	/**
	 * M�todo run da classe ThreadSemaforo que chama o m�todo executa sem passagem de par�metros
	 */
	
	public void run() {
		executa();
		if(aux == 4) {
		fundoInicio.setVisible(true);
		btnInicio.setVisible(true);
		aux = 0;
		}
	}
	
	/**
	 * M�todo executa() que possui dentro de um try catch a utiliza��o de semaforos a fim de definir um sincronismo nas Threads
	 */
	
	public void executa() {
		try {

			semaforo.acquire();
			acionaCarro();
			
		}  catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			semaforo.release();
		}
		aux ++;
	}
	
	/**
	 * M�todo acionaCarro() que � respons�vel por definir a movimenta��o do carro em quest�o
	 */
	
	public void acionaCarro() {
		Rectangle posicao;
		posicao = carro.getBounds();
		int aux = 0;
		Random random = new Random();
		
		switch(op){
			case 1:
				semaforoVermelho.setVisible(false);
				semaforoVerde.setVisible(true);
				while(aux<2) {
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						// TODO: handle exception
					}
					if(aux == 1) {
						posicao.y = (posicao.y)+(random.nextInt(2));
						if(posicao.y >= 46) {
							aux = 2;
						}
					}
					posicao.y = (posicao.y)+(random.nextInt(5));
					carro.setBounds(posicao);
					if(posicao.y >= 800) {
						posicao.y = -100;
						aux = 1;
					}
					
				}
				
				semaforoVermelho.setVisible(true);
				semaforoVerde.setVisible(false);
				
				break;
			case 2:
				semaforoVermelho.setVisible(false);
				semaforoVerde.setVisible(true);
				
				while(aux<2) {
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						// TODO: handle exception
					}
					if(aux == 1) {
						posicao.x = (posicao.x)-(random.nextInt(2));
						if(posicao.x <= 560) {
							aux = 2;
						}
					}
					posicao.x = (posicao.x)-(random.nextInt(5));
					carro.setBounds(posicao);
					if(posicao.x <= -100) {
						posicao.x = 800;
						aux = 1;
					}
					
				}
				
				semaforoVermelho.setVisible(true);
				semaforoVerde.setVisible(false);
				
				break;
			case 3:
				semaforoVermelho.setVisible(false);
				semaforoVerde.setVisible(true);
				
				while(aux<2) {
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						// TODO: handle exception
					}
					if(aux == 1) {
						posicao.y = (posicao.y)-(random.nextInt(2));
						if(posicao.y <= 549) {
							aux = 2;
						}
					}
					posicao.y = (posicao.y)-(random.nextInt(5));
					carro.setBounds(posicao);
					if(posicao.y <= -100) {
						posicao.y = 800;
						aux = 1;
					}
					
				}
				
				semaforoVermelho.setVisible(true);
				semaforoVerde.setVisible(false);
				
				break;
			case 4:
				semaforoVermelho.setVisible(false);
				semaforoVerde.setVisible(true);
				
				while(aux<2) {
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						// TODO: handle exception
					}
					if(aux == 1) {
						posicao.x = (posicao.x)+(random.nextInt(2));
						if(posicao.x >= 48) {
							aux = 2;
						}
					}
					posicao.x = (posicao.x)+(random.nextInt(5));
					carro.setBounds(posicao);
					if(posicao.x >= 800) {
						posicao.x = -100;
						aux = 1;
					}
					
				}
				
				semaforoVermelho.setVisible(true);
				semaforoVerde.setVisible(false);
				
				break;
		}
	}
}


package br.com.controleGastos.controleGastos;

import javax.jms.JMSException;
import javax.naming.NamingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.controleGastos.controleGastos.jms.consumer.Consumer;

@SpringBootApplication
public class ControleGastosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleGastosApplication.class, args);
		
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				Consumer consumer = new Consumer();
				try {
					consumer.testeJMS();
				} catch (NamingException | JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}

		};
		new Thread(runnable).start();
	}

}

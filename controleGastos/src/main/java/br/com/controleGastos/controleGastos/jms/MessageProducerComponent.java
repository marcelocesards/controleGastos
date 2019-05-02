package br.com.controleGastos.controleGastos.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.controleGastos.controleGastos.model.Item;

@Component
public class MessageProducerComponent {
	@Autowired
	public JmsTemplate jmsTemplate;

	public Item send(Item item) {
		jmsTemplate.convertAndSend("launches.queue", new Gson().toJson(item));
		return item;
	}
}
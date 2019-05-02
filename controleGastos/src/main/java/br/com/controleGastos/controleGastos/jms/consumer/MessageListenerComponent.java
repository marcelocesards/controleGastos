package br.com.controleGastos.controleGastos.jms.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.controleGastos.controleGastos.model.Item;
import br.com.controleGastos.controleGastos.service.ItemService;

@Component
public class MessageListenerComponent {
	@Autowired
	private ItemService service;

    @JmsListener(destination = "launches.queue")
    public void onReceiverQueue(String str) {
    	Item item = new Gson().fromJson(str, Item.class);
        service.save(item);
    }
}
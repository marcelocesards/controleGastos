package br.com.controleGastos.controleGastos.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;

import br.com.controleGastos.controleGastos.controllers.ItemJsonController;
import br.com.controleGastos.controleGastos.jms.MessageProducerComponent;
import br.com.controleGastos.controleGastos.model.Item;
import br.com.controleGastos.controleGastos.model.Type;
import br.com.controleGastos.controleGastos.model.User;
import br.com.controleGastos.controleGastos.service.ItemService;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemJsonController.class)
public class ItemJsonControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
    private ItemService service;
	
	@MockBean
	private MessageProducerComponent producer;
		 
	@Test
	public void getItems() throws Exception {
		Item item = new Item(null, "objeto", 1.11, Type.ENTRADA, new User(null, "fulaninho"));
		given(producer.send(item))
		.willReturn(item);
		 mockMvc.perform(post("/item")
				 .contentType(MediaType.APPLICATION_JSON)
	                .content(new Gson().toJson(item)))
	                .andExpect(status().isCreated())
	                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	                .andExpect(jsonPath("$.name", org.hamcrest.Matchers.is(item.getName())));		
	}
}

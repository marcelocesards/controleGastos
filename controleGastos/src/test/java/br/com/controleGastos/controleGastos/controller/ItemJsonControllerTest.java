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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;

import br.com.controleGastos.controleGastos.controllers.ItemJsonController;
import br.com.controleGastos.controleGastos.factory.ItemFactory;
import br.com.controleGastos.controleGastos.jms.MessageProducerComponent;
import br.com.controleGastos.controleGastos.model.Item;
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
		Item item = ItemFactory.getFakeItem();
		System.out.println(toJson(item));
		given(producer.send(item)).willReturn(item);
		mockMvc.perform(post("/item").contentType(MediaType.APPLICATION_JSON).content(toJson(item)))
				.andExpect(status().isCreated())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name", org.hamcrest.Matchers.is(item.getName())));
	}

	private String toJson(Item item) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("  \"id\": null,");
		sb.append("  \"name\": \"objeto\",");
		sb.append("  \"value\": 1.11,");
		sb.append("  \"type\": \"ENTRADA\",");
		sb.append("  \"status\": \"PENDENTE\",");
		sb.append("  \"purchaseDate\": \"2019-05-19T14:02:58.216Z\",");
		sb.append("  \"paymentDate\": \"2019-05-19T14:02:58.216Z\",");
		sb.append("  \"numberOfPortions\": 1,");
		sb.append("  \"paymentMethod\": {");
		sb.append("    \"id\": null,");
		sb.append("    \"name\": \"BancoGenerico\",");
		sb.append("    \"closingDay\": 1,");
		sb.append("    \"paymentDay\": 1");
		sb.append("  },");
		sb.append("  \"user\": {");
		sb.append("    \"id\": null,");
		sb.append("    \"name\": \"fulaninho\"");
		sb.append("  }");
		sb.append("}");
		return sb.toString();
	}
}

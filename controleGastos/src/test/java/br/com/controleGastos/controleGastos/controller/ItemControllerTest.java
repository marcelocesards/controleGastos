package br.com.controleGastos.controleGastos.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.controleGastos.controleGastos.controllers.ItemController;
import br.com.controleGastos.controleGastos.factory.ItemFactory;
import br.com.controleGastos.controleGastos.model.Item;
import br.com.controleGastos.controleGastos.service.ItemService;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemService service;

	@Test
	public void getItems() throws Exception {
		given(service.getAll()).willReturn(new Iterable<Item>() {
			@Override
			public Iterator<Item> iterator() {
				return new Iterator<Item>() {
					@Override
					public boolean hasNext() {
						return false;
					}

					@Override
					public Item next() {
						return ItemFactory.getFakeItem();
					}
				};
			}

		});
		mockMvc.perform(get("/item").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
	}
}

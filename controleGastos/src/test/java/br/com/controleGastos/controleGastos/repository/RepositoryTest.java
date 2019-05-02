package br.com.controleGastos.controleGastos.repository;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.controleGastos.controleGastos.model.Item;
import br.com.controleGastos.controleGastos.model.Type;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTest {
	@Autowired
	private ItemRepository repository;
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void createShouldPersistData() {
		Item item = new Item("objeto", 1.11, new Type(null, "expense"));
		this.repository.save(item);
		Assertions.assertThat(item.getId()).isNotNull();
		Assertions.assertThat(item.getName()).isEqualTo("objeto");
		Assertions.assertThat(item.getValue()).isEqualTo(1.11);
		Assertions.assertThat(item.getType().getType()).isEqualTo("expense");
	}
	
	@Test
	public void findAllShouldRetriveData() {
		Item item = new Item("objeto", 1.11, new Type(null, "expense"));
		this.repository.save(item);
		Iterable<Item> items = this.repository.findAll();
		Assertions.assertThat(items.iterator().hasNext()).isTrue();
	}
}

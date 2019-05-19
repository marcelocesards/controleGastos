package br.com.controleGastos.controleGastos.factory;

import java.time.OffsetDateTime;

import br.com.controleGastos.controleGastos.model.Item;
import br.com.controleGastos.controleGastos.model.PaymentMethod;
import br.com.controleGastos.controleGastos.model.PaymentStatus;
import br.com.controleGastos.controleGastos.model.Type;
import br.com.controleGastos.controleGastos.model.User;

public class ItemFactory {
	public static Item getFakeItem() {
		return new Item(null, "objeto", 1.11, Type.ENTRADA, PaymentStatus.PENDENTE, OffsetDateTime.now(),
				OffsetDateTime.now(), 1, new PaymentMethod(null, "BancoGenerico", 1, 1),
				new User(null, "fulaninho"));
	}
}

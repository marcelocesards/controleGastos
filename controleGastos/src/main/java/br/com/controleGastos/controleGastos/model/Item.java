package br.com.controleGastos.controleGastos.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Double value;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private User user;

	public Item() {
	}

	public Item(Long id, String name, Double value, Type type, User user) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.type = type;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", value=" + value + ", type=" + type + ", user=" + user + "]";
	}
}

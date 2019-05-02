package br.com.controleGastos.controleGastos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Type {
	@Id
	@GeneratedValue
    private Long id;
	private String type;

	public Type() {
	}
	
	public Type(Long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Type [id=" + id + ", type=" + type + "]";
	}
		
}

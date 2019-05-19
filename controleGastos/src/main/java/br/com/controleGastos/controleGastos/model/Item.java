package br.com.controleGastos.controleGastos.model;

import java.time.OffsetDateTime;

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

	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	private OffsetDateTime purchaseDate;
	private OffsetDateTime paymentDate;
	private Integer numberOfPortions;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private PaymentMethod paymentMethod;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private User user;

	public Item() {
	}

	public Item(Long id, String name, Double value, Type type, PaymentStatus status, OffsetDateTime purchaseDate,
			OffsetDateTime paymentDate, Integer numberOfPortions,
			br.com.controleGastos.controleGastos.model.PaymentMethod paymentMethod, User user) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.type = type;
		this.status = status;
		this.purchaseDate = purchaseDate;
		this.paymentDate = paymentDate;
		this.numberOfPortions = numberOfPortions;
		this.paymentMethod = paymentMethod;
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

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public OffsetDateTime getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(OffsetDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public OffsetDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(OffsetDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Integer getNumberOfPortions() {
		return numberOfPortions;
	}

	public void setNumberOfPortions(Integer numberOfPortions) {
		this.numberOfPortions = numberOfPortions;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
}

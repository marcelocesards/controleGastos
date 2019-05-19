package br.com.controleGastos.controleGastos.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Budget
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-17T21:21:55.968Z")
@Entity
public class Budget {
	@JsonProperty("id")
	@Id
	@GeneratedValue
	private Long id = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("initialDate")
	private OffsetDateTime initialDate = null;

	@JsonProperty("finalDate")
	private OffsetDateTime finalDate = null;

	@JsonProperty("items")
	@Valid
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Item> items = null;

	@JsonProperty("debitValue")
	private Double debitValue = null;

	@JsonProperty("procideValue")
	private Double procideValue = null;

	public Budget id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "")

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Budget name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Budget initialDate(OffsetDateTime initialDate) {
		this.initialDate = initialDate;
		return this;
	}

	/**
	 * Get initialDate
	 * 
	 * @return initialDate
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public OffsetDateTime getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(OffsetDateTime initialDate) {
		this.initialDate = initialDate;
	}

	public Budget finalDate(OffsetDateTime finalDate) {
		this.finalDate = finalDate;
		return this;
	}

	/**
	 * Get finalDate
	 * 
	 * @return finalDate
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public OffsetDateTime getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(OffsetDateTime finalDate) {
		this.finalDate = finalDate;
	}

	public Budget items(List<Item> items) {
		this.items = items;
		return this;
	}

	public Budget addItemsItem(Item itemsItem) {
		if (this.items == null) {
			this.items = new ArrayList<Item>();
		}
		this.items.add(itemsItem);
		return this;
	}

	/**
	 * Get items
	 * 
	 * @return items
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Budget debitValue(Double debitValue) {
		this.debitValue = debitValue;
		return this;
	}

	/**
	 * Get debitValue
	 * 
	 * @return debitValue
	 **/
	@ApiModelProperty(value = "")

	public Double getDebitValue() {
		return debitValue;
	}

	public void setDebitValue(Double debitValue) {
		this.debitValue = debitValue;
	}

	public Budget procideValue(Double procideValue) {
		this.procideValue = procideValue;
		return this;
	}

	/**
	 * Get procideValue
	 * 
	 * @return procideValue
	 **/
	@ApiModelProperty(value = "")

	public Double getProcideValue() {
		return procideValue;
	}

	public void setProcideValue(Double procideValue) {
		this.procideValue = procideValue;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Budget budget = (Budget) o;
		return Objects.equals(this.id, budget.id) && Objects.equals(this.name, budget.name)
				&& Objects.equals(this.initialDate, budget.initialDate)
				&& Objects.equals(this.finalDate, budget.finalDate) && Objects.equals(this.items, budget.items)
				&& Objects.equals(this.debitValue, budget.debitValue)
				&& Objects.equals(this.procideValue, budget.procideValue);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, initialDate, finalDate, items, debitValue, procideValue);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Budget {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    initialDate: ").append(toIndentedString(initialDate)).append("\n");
		sb.append("    finalDate: ").append(toIndentedString(finalDate)).append("\n");
		sb.append("    items: ").append(toIndentedString(items)).append("\n");
		sb.append("    debitValue: ").append(toIndentedString(debitValue)).append("\n");
		sb.append("    procideValue: ").append(toIndentedString(procideValue)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}

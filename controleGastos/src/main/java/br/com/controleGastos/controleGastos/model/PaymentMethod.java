package br.com.controleGastos.controleGastos.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * PaymentMethod
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-17T21:21:55.968Z")
@Entity
public class PaymentMethod {
	@JsonProperty("id")
	@Id
	@GeneratedValue
	private Long id = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("closingDay")
	private Integer closingDay = null;

	@JsonProperty("paymentDay")
	private Integer paymentDay = null;

	public PaymentMethod id(Long id) {
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

	public PaymentMethod name(String name) {
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

	public PaymentMethod closingDay(Integer closingDay) {
		this.closingDay = closingDay;
		return this;
	}

	/**
	 * Get closingDay
	 * 
	 * @return closingDay
	 **/
	@ApiModelProperty(value = "")

	public Integer getClosingDay() {
		return closingDay;
	}

	public void setClosingDay(Integer closingDay) {
		this.closingDay = closingDay;
	}

	public PaymentMethod paymentDay(Integer paymentDay) {
		this.paymentDay = paymentDay;
		return this;
	}

	/**
	 * Get paymentDay
	 * 
	 * @return paymentDay
	 **/
	@ApiModelProperty(value = "")

	public Integer getPaymentDay() {
		return paymentDay;
	}

	public void setPaymentDay(Integer paymentDay) {
		this.paymentDay = paymentDay;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PaymentMethod paymentMethod = (PaymentMethod) o;
		return Objects.equals(this.id, paymentMethod.id) && Objects.equals(this.name, paymentMethod.name)
				&& Objects.equals(this.closingDay, paymentMethod.closingDay)
				&& Objects.equals(this.paymentDay, paymentMethod.paymentDay);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, closingDay, paymentDay);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PaymentMethod {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    closingDay: ").append(toIndentedString(closingDay)).append("\n");
		sb.append("    paymentDay: ").append(toIndentedString(paymentDay)).append("\n");
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

	public PaymentMethod(Long id, String name, Integer closingDay, Integer paymentDay) {
		super();
		this.id = id;
		this.name = name;
		this.closingDay = closingDay;
		this.paymentDay = paymentDay;
	}
	
	
}

package lt.kvk.i14.karolis_krolis.pw06.backend.entitys;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "fee")
@Table
public class FeeEntity {

	@Id
	@GeneratedValue
	private int id;
	
	private String firstName;
	private String lastName;
	private @Valid LocalDate arivalDate;
	private @Valid LocalDate departureDate;
	private @Valid BigDecimal fee;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public @Valid LocalDate getArivalDate() {
		return arivalDate;
	}
	public void setArivalDate(@Valid LocalDate localDate) {
		this.arivalDate = localDate;
	}
	public @Valid LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(@Valid LocalDate localDate) {
		this.departureDate = localDate;
	}
	public @Valid BigDecimal getFee() {
		return fee;
	}
	public void setFee(@Valid BigDecimal bigDecimal) {
		this.fee = bigDecimal;
	}
	
	
}

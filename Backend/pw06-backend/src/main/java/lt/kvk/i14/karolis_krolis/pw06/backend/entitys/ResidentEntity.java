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
@Entity(name = "resident")
@Table
public class ResidentEntity {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String firstName;
	private String lastName;
	private @Valid LocalDate arivalDate;
	private @Valid BigDecimal stayDurration;
	private String roomType;
	
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
	public @Valid BigDecimal getStayDurration() {
		return stayDurration;
	}
	public void setStayDurration(@Valid BigDecimal bigDecimal) {
		this.stayDurration = bigDecimal;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	
	
}

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
@Entity(name = "priceList")
@Table
public class PriceListEntity {

	@Id
	@GeneratedValue
	private int id;
	
	private String roomType;
	private @Valid BigDecimal roomPriceWorkDays;
	private @Valid BigDecimal roomPriceHolidays;
	private @Valid LocalDate datePriceISValidFrom;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public @Valid BigDecimal getRoomPriceWorkDays() {
		return roomPriceWorkDays;
	}
	public void setRoomPriceWorkDays(@Valid BigDecimal bigDecimal) {
		this.roomPriceWorkDays = bigDecimal;
	}
	public @Valid BigDecimal getRoomPriceHolidays() {
		return roomPriceHolidays;
	}
	public void setRoomPriceHolidays(@Valid BigDecimal bigDecimal) {
		this.roomPriceHolidays = bigDecimal;
	}
	public @Valid LocalDate getDatePriceISValidFrom() {
		return datePriceISValidFrom;
	}
	public void setDatePriceISValidFrom(@Valid LocalDate localDate) {
		this.datePriceISValidFrom = localDate;
	}
	
	
}

package lt.kvk.i14.karolis_krolis.pw06.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lt.kvk.i14.karolis_krolis.pw06.backend.entitys.PriceListEntity;
import lt.kvk.i14.karolis_krolis.pw06.backend.repository.PriceListRepository;
import lt.kvk.i14.karolis_krolis.pw06.model.PriceList;

@Service
public class PriceListService {

	@Autowired
	private PriceListRepository priceListRepository;
	
	
	public ResponseEntity<Void> save(final PriceList src, Long priceListId) {
		final PriceListEntity priceList = new PriceListEntity();
		priceList.setRoomType(src.getRoomType());
		priceList.setRoomPriceWorkDays(src.getRoomPriceWorkDays());
		priceList.setRoomPriceHolidays(src.getRoomPriceHolidays());
		priceList.setDatePriceISValidFrom(src.getDatePriceIsValidFrom());
		priceListRepository.save(priceList);
		return ResponseEntity.ok().build();
	}
	
	public ResponseEntity<Void> update (PriceList src) {
		final PriceListEntity priceList = priceListRepository.findById(src.getId().intValue()).orElse(null);
		priceList.setId(src.getId().intValue());
		priceList.setRoomType(src.getRoomType());
		priceList.setRoomPriceWorkDays(src.getRoomPriceWorkDays());
		priceList.setRoomPriceHolidays(src.getRoomPriceHolidays());
		priceList.setDatePriceISValidFrom(src.getDatePriceIsValidFrom());
		priceListRepository.save(priceList);
		return ResponseEntity.ok().build();
	}
	
	public static PriceList toPriceList (PriceListEntity src) {
		PriceList priceList = new PriceList();
		priceList.setId((long) src.getId());
		priceList.setRoomType(src.getRoomType());
		priceList.setRoomPriceWorkDays(src.getRoomPriceWorkDays());
		priceList.setRoomPriceHolidays(src.getRoomPriceHolidays());
		priceList.setDatePriceIsValidFrom(src.getDatePriceISValidFrom());
		return priceList;
	}
	
	public static List<PriceList> toPriceListArray (List<PriceListEntity> src) {
		List<PriceList> priceList = new ArrayList<PriceList>();
		for (int i = 0; i < src.size(); i++) {
			priceList.add(toPriceList(src.get(i)));
		}
		return priceList;
	}
	
}

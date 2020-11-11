package lt.kvk.i14.karolis_krolis.pw06.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lt.kvk.i14.karolis_krolis.pw06.backend.entitys.FeeEntity;
import lt.kvk.i14.karolis_krolis.pw06.backend.repository.FeeRepository;
import lt.kvk.i14.karolis_krolis.pw06.model.Fee;

@Service
public class FeeService {

	@Autowired
	private FeeRepository feeRepository;
	
	public ResponseEntity<Void> save(final Fee src, Long feeId) {
		final FeeEntity fee = new FeeEntity();
		fee.setFirstName(src.getFirstName());
		fee.setLastName(src.getLastName());
		fee.setArivalDate(src.getArivalDate());
		fee.setDepartureDate(src.getDepartureDate());
		fee.setFee(src.getFee());
		feeRepository.save(fee);
		return ResponseEntity.ok().build();
	}
	
	public ResponseEntity<Void> update (Fee src) {
		FeeEntity fee = feeRepository.findById(src.getId().intValue()).orElse(null);
		fee.setId(src.getId().intValue());
		fee.setFirstName(src.getFirstName());
		fee.setLastName(src.getLastName());
		fee.setArivalDate(src.getArivalDate());
		fee.setDepartureDate(src.getDepartureDate());
		fee.setFee(src.getFee());
		feeRepository.save(fee);
		return ResponseEntity.ok().build();
	}
	
	public static Fee toFee (FeeEntity src) {
		final Fee fee = new Fee();
		fee.setId((long) src.getId());
		fee.setFirstName(src.getFirstName());
		fee.setLastName(src.getLastName());
		fee.setArivalDate(src.getArivalDate());
		fee.setDepartureDate(src.getDepartureDate());
		fee.setFee(src.getFee());
		return fee;
	}
	
	public static List<Fee> toFeeList (List<FeeEntity> src) {
		List<Fee> feeList = new ArrayList<Fee>();
		for (int i = 0; i < src.size(); i++) {
			feeList.add(toFee(src.get(i)));
		}
		return feeList;
	}
}

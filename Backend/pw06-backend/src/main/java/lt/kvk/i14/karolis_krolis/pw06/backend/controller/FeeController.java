package lt.kvk.i14.karolis_krolis.pw06.backend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lt.kvk.i14.karolis_krolis.pw06.api.FeeApi;
import lt.kvk.i14.karolis_krolis.pw06.backend.entitys.FeeEntity;
import lt.kvk.i14.karolis_krolis.pw06.backend.repository.FeeRepository;
import lt.kvk.i14.karolis_krolis.pw06.backend.service.FeeService;
import lt.kvk.i14.karolis_krolis.pw06.model.Fee;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class FeeController implements FeeApi{

	@Autowired
	private FeeRepository feeRepository;
	
	@Autowired
	private FeeService feeService;

	@Override
	public ResponseEntity<Void> addFee(@Valid Fee fee) {
		
		return feeService.save(fee, null);
	}

	@Override
	public ResponseEntity<Void> delFee(Long feeId) {
		
		feeRepository.deleteById(feeId.intValue());
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<Fee> getFee(Long feeId) {

		Optional<FeeEntity> optional = feeRepository.findById(feeId.intValue());
		if(optional.isPresent()) {
			return  ResponseEntity.ok(feeService.toFee(optional.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<List<Fee>> getFees() {

		final List<Fee> feeList = feeService.toFeeList(feeRepository.findAll());
		return ResponseEntity.ok(feeList);
	}

	@Override
	public ResponseEntity<Void> updateFee(@Valid Fee fee) {
		// TODO Auto-generated method stub
		return feeService.update(fee);
	}

	@Override
	public ResponseEntity<Void> uploadFeeCsv(@Valid MultipartFile csvfeeFile) {
		// TODO Auto-generated method stub
		return FeeApi.super.uploadFeeCsv(csvfeeFile);
	}
	
	
}

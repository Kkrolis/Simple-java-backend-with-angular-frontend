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


import lt.kvk.i14.karolis_krolis.pw06.api.PriceListApi;
import lt.kvk.i14.karolis_krolis.pw06.backend.entitys.PriceListEntity;
import lt.kvk.i14.karolis_krolis.pw06.backend.repository.PriceListRepository;
import lt.kvk.i14.karolis_krolis.pw06.backend.service.PriceListService;
import lt.kvk.i14.karolis_krolis.pw06.model.PriceList;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PriceListController implements PriceListApi {

	@Autowired
	private PriceListRepository priceListRepository;
	
	@Autowired
	private PriceListService priceListService;


	@Override
	public ResponseEntity<Void> addPrice(@Valid PriceList price) {

		return priceListService.save(price, null);
	}

	@Override
	public ResponseEntity<Void> delPrice(Long priceId) {

		priceListRepository.deleteById(priceId.intValue());
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<PriceList> getPrice(Long priceId) {

		Optional<PriceListEntity> optional = priceListRepository.findById(priceId.intValue());
		if (optional.isPresent()) {
			return ResponseEntity.ok(priceListService.toPriceList(optional.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<List<PriceList>> getPriceList() {

		final List<PriceList> priceList = priceListService.toPriceListArray(priceListRepository.findAll());
		return ResponseEntity.ok(priceList);
	}

	@Override
	public ResponseEntity<Void> updatePriceList(@Valid PriceList priceList) {

		return priceListService.update(priceList);
	}

	@Override
	public ResponseEntity<Void> uploadPriceListCsv(@Valid MultipartFile csvPriceListFile) {
		// TODO Auto-generated method stub
		return PriceListApi.super.uploadPriceListCsv(csvPriceListFile);
	}
	
}

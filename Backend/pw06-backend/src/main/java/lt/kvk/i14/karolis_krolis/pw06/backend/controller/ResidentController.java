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


import lt.kvk.i14.karolis_krolis.pw06.api.ResidentsApi;
import lt.kvk.i14.karolis_krolis.pw06.backend.entitys.ResidentEntity;
import lt.kvk.i14.karolis_krolis.pw06.backend.repository.ResidentRepository;
import lt.kvk.i14.karolis_krolis.pw06.backend.service.ResidentService;
import lt.kvk.i14.karolis_krolis.pw06.model.Resident;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ResidentController implements ResidentsApi{

	@Autowired
	private ResidentRepository residentRepository;
	
	@Autowired
	private ResidentService residentService;

	@Override
	public ResponseEntity<Void> addResident(lt.kvk.i14.karolis_krolis.pw06.model.@Valid Resident resident) {
		
		return residentService.save(resident, null);
	}

	@Override
	public ResponseEntity<Void> delResident(Long residentId) {
		
		residentRepository.deleteById(residentId.intValue());
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<lt.kvk.i14.karolis_krolis.pw06.model.Resident> getResident(Long residentId) {
		
		Optional<ResidentEntity> optional = residentRepository.findById(residentId.intValue());
		if (optional.isPresent()) {
			return ResponseEntity.ok(residentService.toResident(optional.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<List<lt.kvk.i14.karolis_krolis.pw06.model.Resident>> getResidents() {
		
		final List<Resident> residentList = residentService.toResidentList(residentRepository.findAll());
		return ResponseEntity.ok(residentList);
		
	}

	@Override
	public ResponseEntity<Void> updateResident(lt.kvk.i14.karolis_krolis.pw06.model.@Valid Resident resident) {
		
		return residentService.update(resident);
	}

	@Override
	public ResponseEntity<Void> uploadResidentsCsv(@Valid MultipartFile csvResidentsFile) {
		// TODO Auto-generated method stub
		// not implemented yet
		return ResidentsApi.super.uploadResidentsCsv(csvResidentsFile);
	}

}

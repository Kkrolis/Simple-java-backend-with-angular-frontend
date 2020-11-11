package lt.kvk.i14.karolis_krolis.pw06.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lt.kvk.i14.karolis_krolis.pw06.backend.entitys.ResidentEntity;
import lt.kvk.i14.karolis_krolis.pw06.backend.repository.ResidentRepository;
import lt.kvk.i14.karolis_krolis.pw06.model.Resident;

@Service
public class ResidentService {

	@Autowired
	private ResidentRepository residentRepository;
	
	public ResponseEntity<Void> save(final Resident src, Long priceId){
		final ResidentEntity resident = new ResidentEntity();
		resident.setFirstName(src.getFirstName());
		resident.setLastName(src.getLastName());
		resident.setArivalDate(src.getArivalDate());
		resident.setStayDurration(src.getStayDurration());
		resident.setRoomType(src.getRoomType());
		residentRepository.save(resident);
		return ResponseEntity.ok().build();
	}
	
	public ResponseEntity<Void> update (Resident src) {
		ResidentEntity resident = residentRepository.findById(src.getId().intValue()).orElse(null);;
		resident.setId(src.getId().intValue());
		resident.setFirstName(src.getFirstName());
		resident.setLastName(src.getLastName());
		resident.setArivalDate(src.getArivalDate());
		resident.setStayDurration(src.getStayDurration());
		resident.setRoomType(src.getRoomType());
		residentRepository.save(resident);
		return ResponseEntity.ok().build();
	}
	
	public static Resident toResident (ResidentEntity src) {
		final Resident resident = new Resident();
		resident.setId((long) src.getId());
		resident.setFirstName(src.getFirstName());
		resident.setLastName(src.getLastName());
		resident.setArivalDate(src.getArivalDate());
		resident.setStayDurration(src.getStayDurration());
		resident.setRoomType(src.getRoomType());
		return resident;
	}
	
	public static List<Resident> toResidentList (List<ResidentEntity> src) {
		List<Resident> residentList = new ArrayList<Resident>();
		for (int i = 0; i < src.size(); i++) {
			residentList.add(toResident(src.get(i)));
		}
		return residentList;
	}
		
} 

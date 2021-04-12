package fr.diginamic.klitair.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.diginamic.klitair.entity.Town;
import fr.diginamic.klitair.repository.TownRepository;

/**
 * 
 * @author StephanieMC
 *
 */

@Service
public class TownService {

	@Autowired
	TownRepository townRepository;

	public List<Town> findByPostCode(String postCode) {
		return null;
		// return townRepository.findByPostCode(postCode);
	}

}

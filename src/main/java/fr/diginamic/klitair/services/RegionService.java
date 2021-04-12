package fr.diginamic.klitair.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.api.geo.region.RegionApiRequest;
import fr.diginamic.klitair.api.geo.region.RegionDataApi;
import fr.diginamic.klitair.entity.Region;
import fr.diginamic.klitair.repository.RegionRepository;

@Service
public class RegionService {
	
	@Autowired
	RegionApiRequest regionApiRequest;
	
	@Autowired
	RegionRepository regionRepository;
	
	public void insertRegion() {
		try {
			for (RegionDataApi regionData : regionApiRequest.getRegionData()) {
				if (regionRepository.findByCode(regionData.getCode()) == null) {
					Region region = new Region();
					region.setCode(regionData.getCode());
					region.setName(regionData.getName());
					regionRepository.save(region);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

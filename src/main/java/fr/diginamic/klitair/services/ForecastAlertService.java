/**
 * 
 */
package fr.diginamic.klitair.services;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.dto.ForecastAlertDto;
import fr.diginamic.klitair.entity.ForecastAlert;
import fr.diginamic.klitair.entity.ReceivedAlert;
import fr.diginamic.klitair.entity.Town;
import fr.diginamic.klitair.entity.User;
import fr.diginamic.klitair.exceptions.BadRequestException;
import fr.diginamic.klitair.repository.ForecastAlertRepository;

/**
 * @author StephanieMC
 *
 */
@Service
public class ForecastAlertService {

	@Autowired
	private ForecastAlertRepository forecastAlertRepository;

	@Autowired
	private ModelMapper modelMapper;

	public Page<ForecastAlertDto> findAllNotAlreadySend(int index, int limit) {
		Page<ForecastAlert> forecastAlerts = forecastAlertRepository.findByUserNull(PageRequest.of(index, limit));
		return new PageImpl<ForecastAlertDto>(
				forecastAlerts.stream().map(forecastAlert -> modelMapper.map(forecastAlert, ForecastAlertDto.class))
						.collect(Collectors.toList()),
				forecastAlerts.getPageable(), forecastAlerts.getTotalElements());
	}

	public void sendAsAlerte(Long id) {
		// TODO finish feature
		ForecastAlert forecastAlert = forecastAlertRepository.findById(id).orElseThrow(() -> new BadRequestException());
		Town town = forecastAlert.getTown();
		for (User user : town.getUsers()) {
			ReceivedAlert receivedAlert = new ReceivedAlert();
		}
		
	}

	public void sendAllAsAlert() {
		// TODO Auto-generated method stub

	}

	public void saveForecastAlertInDatabase() {
		ForecastAlert forecastAlert = new ForecastAlert();
	}

}

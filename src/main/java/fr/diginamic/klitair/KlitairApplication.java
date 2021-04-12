package fr.diginamic.klitair;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.diginamic.klitair.api.airquality.AirQualityApiRequest;
import fr.diginamic.klitair.api.airquality.AirQualityData;
import fr.diginamic.klitair.api.geo.departement.DepartmentApiRequest;
import fr.diginamic.klitair.api.geo.region.RegionApiRequest;
import fr.diginamic.klitair.api.geo.town.TownApiRequest;
import fr.diginamic.klitair.api.meteo.WeatherApiRequest;

@SpringBootApplication
public class KlitairApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KlitairApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("\nTown API\n");
		TownApiRequest townApi = new TownApiRequest();
		townApi.getTownData();

		System.out.println("\nDepartement API\n");
		DepartmentApiRequest departmentApi = new DepartmentApiRequest();
		departmentApi.getDepartmentData();

		System.out.println("\nRegion API\n");
		RegionApiRequest regionApi = new RegionApiRequest();
		regionApi.getRegionData();

		System.out.println("\nData API Air\n");
		AirQualityApiRequest testApiAir = new AirQualityApiRequest();
		List<AirQualityData> airTest = testApiAir.getAirQualityDataDay();
		airTest.forEach(el -> System.out.println(el));

		System.out.println("\nMeteo API\n");
		WeatherApiRequest weathersData = new WeatherApiRequest();
		weathersData.getWeatherData();

		System.out.println("Terminé");

	}

}

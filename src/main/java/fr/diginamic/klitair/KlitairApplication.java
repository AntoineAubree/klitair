package fr.diginamic.klitair;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.diginamic.klitair.api.airquality.AirQualityApiRequest;
import fr.diginamic.klitair.api.airquality.AirQualityData;
import fr.diginamic.klitair.api.geo.departement.DepartmentApi;
import fr.diginamic.klitair.api.geo.region.RegionApi;
import fr.diginamic.klitair.api.geo.town.TownApi;
import fr.diginamic.klitair.api.meteo.TestMeteoApi;

@SpringBootApplication
public class KlitairApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KlitairApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("\nTown API\n");
		TownApi townApi = new TownApi();
		townApi.getTownApi();

		System.out.println("\nDepartement API\n");
		DepartmentApi departmentApi = new DepartmentApi();
		departmentApi.getDepartmentApi();

		System.out.println("\nRegion API\n");
		RegionApi regionApi = new RegionApi();
		regionApi.getRegionApi();

		System.out.println("\nData API Air\n");
		AirQualityApiRequest testApiAir = new AirQualityApiRequest();
		List<AirQualityData> airTest = testApiAir.getAirQualityDataDay();
		airTest.forEach(el -> System.out.println(el));

		System.out.println("\nMeteo API\n");
		TestMeteoApi testMeteoApi = new TestMeteoApi();
		testMeteoApi.getTestMeteoApi();

		System.out.println("Terminé");

	}

}

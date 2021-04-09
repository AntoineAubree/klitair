package fr.diginamic.klitair;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.diginamic.klitair.airplapi.TestAirPlApi;
import fr.diginamic.klitair.entity.AirQuality;
import fr.diginamic.klitair.geoapi.DepartmentApi;
import fr.diginamic.klitair.geoapi.RegionApi;
import fr.diginamic.klitair.geoapi.TownApi;

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
		TestAirPlApi testApiAir = new TestAirPlApi();
		List<AirQuality> airTest = testApiAir.getTestAirPlApi();
		airTest.forEach(el -> System.out.println(el));

		System.out.println("Terminé");

	}

}

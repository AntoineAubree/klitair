package fr.diginamic.klitair;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.diginamic.klitair.api.DepartmentApi;
import fr.diginamic.klitair.api.RegionApi;
import fr.diginamic.klitair.api.TownApi;

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

		System.out.println("\nDepartement API\n");
		RegionApi regionApi = new RegionApi();
		regionApi.getRegionApi();

	}

}

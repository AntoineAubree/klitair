package fr.diginamic.klitair;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.diginamic.klitair.api.meteo.WeatherApiRequest;
import fr.diginamic.klitair.api.meteo.day.WeatherDataDay;
import fr.diginamic.klitair.api.meteo.periods.WeatherDataPeriods;

@SpringBootApplication
public class KlitairApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KlitairApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		System.out.println("\nTown API\n");
//		TownApiRequest townApi = new TownApiRequest();
//		List<TownDataApi> townData = townApi.getTownData();
//		townData.forEach(el -> System.out.println(el));
//
//		System.out.println("\nDepartement API\n");
//		DepartmentApiRequest departmentApi = new DepartmentApiRequest();
//		List<DepartmentDataApi> departementData = departmentApi.getDepartmentData();
//		departementData.forEach(el -> System.out.println(el));
//
//		System.out.println("\nRegion API\n");
//		RegionApiRequest regionApi = new RegionApiRequest();
//		List<RegionDataApi> regionData = regionApi.getRegionData();
//		regionData.forEach(el -> System.out.println(el));

//		System.out.println("\nData API Air\n");
//		AirQualityApiRequest testApiAir = new AirQualityApiRequest();
//		System.out.println("Indicator");
//		List<AirQualityData> airTestIndicator = testApiAir.getAirQualityDataIndicator("44109");
//		airTestIndicator.forEach(el -> System.out.println(el));
//		System.out.println("History");
//		List<AirQualityData> airTestHistory = testApiAir.getAirQualityDataHistory("44109");
//		airTestHistory.forEach(el -> System.out.println(el));
//		System.out.println("Alert");
//		List<AirQualityData> airTestAlert = testApiAir.getAirQualityDataAlert("44109");
//		airTestAlert.forEach(el -> System.out.println(el));

		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-M-d")));

		System.out.println("\nMeteo API\n");
		WeatherApiRequest weathersApi = new WeatherApiRequest();
		List<List<WeatherDataPeriods>> weatherData = weathersApi.getWeatherDataPeriods("35001");
		List<WeatherDataDay> weatherData2 = weathersApi.getWeatherDataDay("35001");

		weatherData.get(0).forEach(el -> System.out.println(el));
		weatherData2.forEach(el -> System.out.println(el));

		System.out.println("Terminé");

	}

}

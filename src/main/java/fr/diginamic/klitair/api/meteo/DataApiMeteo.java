/**
 * 
 */
package fr.diginamic.klitair.api.meteo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author anton
 *
 */
public class DataApiMeteo {

	@JsonProperty("forecast")
	private List<List<WeatherData>> weather = new ArrayList<>();

	/**
	 * @return the weather
	 */
	public List<List<WeatherData>> getWeather() {
		return weather;
	}

	/**
	 * @param weather the weather to set
	 */
	public void setWeather(List<List<WeatherData>> weather) {
		this.weather = weather;
	}

}

/**
 * 
 */
package fr.diginamic.klitair.api.meteo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.diginamic.klitair.entity.Weather;

/**
 * @author anton
 *
 */
public class DataApiMeteo {

	@JsonProperty("forecast")
	private List<List<Weather>> weather = new ArrayList<>();

	/**
	 * @return the weather
	 */
	public List<List<Weather>> getWeather() {
		return weather;
	}

	/**
	 * @param weather the weather to set
	 */
	public void setWeather(List<List<Weather>> weather) {
		this.weather = weather;
	}

}

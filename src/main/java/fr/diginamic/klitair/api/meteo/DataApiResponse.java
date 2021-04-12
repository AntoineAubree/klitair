/**
 * 
 */
package fr.diginamic.klitair.api.meteo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Reprensentation of key "forecast" from JSON reponse
 * 
 * @author anton
 *
 */
public class DataApiResponse {

	/** weathers */
	@JsonProperty("forecast")
	private List<List<WeatherData>> weathers = new ArrayList<>();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DataApiMeteo [weathers=");
		builder.append(weathers);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the weathers
	 */
	public List<List<WeatherData>> getWeathers() {
		return weathers;
	}

	/**
	 * @param weathers the weathers to set
	 */
	public void setWeathers(List<List<WeatherData>> weathers) {
		this.weathers = weathers;
	}

}

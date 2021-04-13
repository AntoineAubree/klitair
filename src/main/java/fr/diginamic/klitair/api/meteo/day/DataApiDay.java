/**
 * 
 */
package fr.diginamic.klitair.api.meteo.day;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Reprensentation of key "forecast" from JSON reponse for 1 day
 * 
 * @author anton
 *
 */
public class DataApiDay {

	/** weathers */
	@JsonProperty("forecast")
	private List<WeatherDataDay> weathers = new ArrayList<>();

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
	public List<WeatherDataDay> getWeathers() {
		return weathers;
	}

	/**
	 * @param weathers the weathers to set
	 */
	public void setWeathers(List<WeatherDataDay> weathers) {
		this.weathers = weathers;
	}

}

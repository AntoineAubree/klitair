/**
 * 
 */
package fr.diginamic.klitair.api.meteo.periods;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Reprensentation of key "forecast" from JSON reponse for several day
 * 
 * @author anton
 *
 */
public class DataApiPeriods {

	/** weathers */
	@JsonProperty("forecast")
	private List<List<WeatherDataPeriods>> weathers = new ArrayList<>();

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
	public List<List<WeatherDataPeriods>> getWeathers() {
		return weathers;
	}

	/**
	 * @param weathers the weathers to set
	 */
	public void setWeathers(List<List<WeatherDataPeriods>> weathers) {
		this.weathers = weathers;
	}

}

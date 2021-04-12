package fr.diginamic.klitair.api.airquality;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataApiAir {

	@JsonProperty("results")
	private List<ResultApi> resultApi = new ArrayList<>();

	/**
	 * @return the resultApi
	 */
	public List<ResultApi> getResultApi() {
		return resultApi;
	}

	/**
	 * @param resultApi the resultApi to set
	 */
	public void setResultApi(List<ResultApi> resultApi) {
		this.resultApi = resultApi;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DataApiAir [resultApi=");
		builder.append(resultApi);
		builder.append("]");
		return builder.toString();
	}

}

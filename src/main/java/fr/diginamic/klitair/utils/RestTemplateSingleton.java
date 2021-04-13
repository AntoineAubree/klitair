package fr.diginamic.klitair.utils;

import org.springframework.web.client.RestTemplate;

public class RestTemplateSingleton {

	private static RestTemplate restTemplate;

	private RestTemplateSingleton() {

	}

	public static RestTemplate getRestTemplate() {
		if (restTemplate == null) {
			restTemplate = new RestTemplate();
		}
		return restTemplate;
	}
}

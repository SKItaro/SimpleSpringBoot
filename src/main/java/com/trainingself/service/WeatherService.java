package com.trainingself.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {


	private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

	private static final String BASE_URL_4_GET_WEATHER = "http://weather.livedoor.com/forecast/webservice/json/v1";


	public Map<String, Object> getWeatherInfo(String param) throws URISyntaxException {
		StringBuilder apiParam = new StringBuilder().append(BASE_URL_4_GET_WEATHER).append("?city=").append(param);
		URI uri = new URI(apiParam.toString());
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map> responseEntity = restTemplate.exchange(RequestEntity.get(uri).build(), Map.class);
		Map<String, Object> responseMap = responseEntity.getBody();

		//logger.info(responseMap.toString());

		return responseMap;
	}
}

package com.trainingself.controller.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trainingself.domain.model.University;
import com.trainingself.service.UniversitiesService;
import com.trainingself.service.WeatherService;

@RestController
@RequestMapping("/rest")
public class CommonRestController {

	@Autowired
	UniversitiesService uService;

	@Autowired
	WeatherService wService;


	@RequestMapping(value = "/universities", method = RequestMethod.GET)
	public List<String> getUniversities(@RequestParam String category) throws Exception {
		List<University> serviceResult = uService.getUniversities(category);
		List<String> returnLst = new ArrayList<>();
		for (University dto : serviceResult) {
			returnLst.add(dto.getUniversity());
		}
		return returnLst;
	}


	//city-code help => http://weather.livedoor.com/forecast/rss/primary_area.xml (東京:130010)
	@RequestMapping(value = "/weatherInfo", method = RequestMethod.GET)
	public Map<String, Object> getWeatherInfo(@RequestParam String city) throws Exception {
		return wService.getWeatherInfo(city);

	}

}

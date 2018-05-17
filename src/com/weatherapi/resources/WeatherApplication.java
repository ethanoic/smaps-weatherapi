package com.weatherapi.resources;
import org.glassfish.jersey.server.ResourceConfig;

public class WeatherApplication extends ResourceConfig {
	public WeatherApplication() {
		packages("com.weatherapi.resources");
		register(MyJacksonFeature.class);
	}
}

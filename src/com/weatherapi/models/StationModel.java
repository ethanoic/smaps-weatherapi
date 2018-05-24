package com.weatherapi.models;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
// import javax.xml.bind.annotation.* // alternative to import all from annotation

@XmlRootElement(name = "station")
public class StationModel {
	
	@JsonProperty("name")
	@XmlElement(name = "name")
	public String Name;

	@JsonProperty("address")
	@XmlElement(name = "address")
	public String Address;

	@JsonProperty("capacity")
	@XmlElement(name = "capacity")
	public int Capacity;
	
	public StationModel() {
		
	}
	
	public StationModel(String name, String address, int capacity) {
		this.Name = name;
		this.Address = address;
		this.Capacity = capacity;
	}
}

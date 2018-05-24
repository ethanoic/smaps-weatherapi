package com.weatherapi.data;

import java.util.ArrayList;
import java.util.List;
import com.weatherapi.models.*;

/*
 * Controls getting/setting data in database
 */
public class StationRespository {
	
	private List<StationModel> sampleStations = new ArrayList<StationModel>();
	
	public StationRespository() {
		// mock data instanced
		sampleStations.add(new StationModel("Redhill", "Redhill", 1000));
		sampleStations.add(new StationModel("Queenstown", "Queenstown", 1000));
		sampleStations.add(new StationModel("Tampines", "Tampines", 1000));
		sampleStations.add(new StationModel("Bedok", "Bedok", 1000));
		sampleStations.add(new StationModel("Tanah Merah", "Tanah Merah", 1000));
		sampleStations.add(new StationModel("Dover", "Dover", 1000));
		sampleStations.add(new StationModel("Buona Vista", "Buona Vista", 1000));
		sampleStations.add(new StationModel("Commonwealth", "Commonwealth", 1000));
		sampleStations.add(new StationModel("Clementi", "Clementi", 1000));
		sampleStations.add(new StationModel("Jurong East", "Jurong East", 1000));
		sampleStations.add(new StationModel("City Hall", "City Hall", 1000));
		sampleStations.add(new StationModel("Raffles Place", "Raffles Place", 1000));
		sampleStations.add(new StationModel("Tiong Bahru", "Tiong Bahru", 1000));
		sampleStations.add(new StationModel("Outram", "Outram", 1000));
	}
	
	/*
	 * pageSize is between 10 to 30
	 * pageNumber begins from 1
	 */
	public List<StationModel> GetStations(int pageSize, int pageNumber) {
		
		List<StationModel> result = new ArrayList<StationModel>();
		
		// get total record count
		int total = sampleStations.size();
		// get total number of pages
		int numberOfPages = (int)Math.ceil(total / pageSize);
		// get row number to start fetching data for this page
		int startFrom = (pageNumber-1)* pageSize;
		// query list to get result
		
		/*
		for(int i = 0; i<total && result.size() < pageSize; i++) {
			if (i >= startFrom && result.size() < pageSize) {
				result.add(sampleStations.get(i));
			}
		}
		*/
		
		for(int i = startFrom; i < total && result.size() < pageSize; i++) {
			result.add(sampleStations.get(i));
		}
		
		return result;
	}
	
	public int GetTotalPages(int pageSize) {
		// get total record count
		int total = sampleStations.size();
		// get total number of pages
		int numberOfPages = (int)Math.ceil(total / (double)pageSize);
		
		return numberOfPages;
	}
}

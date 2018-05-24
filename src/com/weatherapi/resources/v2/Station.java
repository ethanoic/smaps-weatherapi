package com.weatherapi.resources.v2;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import com.weatherapi.data.StationRespository;
import com.weatherapi.models.StationModel;
import com.weatherapi.models.StationsPaged;

/*
 * Station is a resource that will handle adding, updating, deleting and getting 
 * details about weather stations
 */
@Path("v2/stations")
public class Station {
	
	private StationRespository repo = new StationRespository();

	/*
	 * GET /stations?pagesize=5&pagenumber=1
	 * return a StationsPaged object
	 */
	@GET 
	@Produces({"application/json; qs=0.9", "application/xml; qs=0.5"})
	public Response GetAllStations(@QueryParam("pagesize") int pageSize, @QueryParam("pagenumber") int pageNumber) {
		
		StationsPaged result = new StationsPaged();
		
		// get from database/list
		result.Data = repo.GetStations(pageSize, pageNumber);
		
		// check if there is a next
		result.Next = "";
		// there is no next page if i am at the last page
		int totalPages = repo.GetTotalPages(pageSize);
		if (pageNumber < totalPages) {
			int nextPageNumber = pageNumber + 1;
			result.Next = "/WeatherAPI/api/v2/stations?pagesize=" + pageSize + "&pagenumber=" + nextPageNumber;
		}
		
		// check if there is a prev
		result.Prev = "";
		if (pageNumber > 1) {
			int prevPageNumber = pageNumber - 1;
			result.Prev = "/WeatherAPI/api/v2/stations?pagesize=" + pageSize + "&pagenumber=" + prevPageNumber;
		}
		
		return Response.ok().entity(new GenericEntity<StationsPaged>(result){}).build();
		
	}
}
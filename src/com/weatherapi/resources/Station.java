package com.weatherapi.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import com.weatherapi.data.StationRespository;
import com.weatherapi.models.StationModel;

/*
 * Station is a resource that will handle adding, updating, deleting and getting 
 * details about weather stations
 */
@Path("stations")
public class Station {
	
	private StationRespository repo = new StationRespository();
	
	/*
	 * GET /stations?pagesize=5&pagenumber=1
	 */
	@GET 
	@Produces({"application/json; qs=0.9", "application/xml; qs=0.5"})
	public Response GetAllStations(@QueryParam("pagesize") int pageSize, @QueryParam("pagenumber") int pageNumber) {
		
		
		List<StationModel> result = repo.GetStations(pageSize, pageNumber);
		
		//GenericEntity<List<StationModel>> result = new GenericEntity<List<StationModel>>(stations) {};
		
		return Response.ok().entity(new GenericEntity<List<StationModel>>(result){}).build();
		/*
		List stations = new ArrayList();
		stations.add("REDHILL");
		stations.add("TAMPINES");
		return Response.ok().entity(new GenericEntity<List>(stations) {}).build();
		*/
	}
	
	/*
	@POST
	@Consumes("text/plain")
	public Response AddStation(String stationName) {
		return Response.ok("Added Station " + stationName).build();
	}
	*/
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response AddStation(StationModel newStation) {
		return Response.ok().entity(new GenericEntity<StationModel>(newStation) {}).build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes("text/plain")
	public Response UpdateStation(String stationName, @PathParam("id") int id) {
		return Response.ok("Edited Station " + stationName + " width id:" + id).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response DeleteStation(@PathParam("id") int id) {
		return Response.ok("Deleted Station id:" + id).build();
	}
	
	@GET
	@Path("/values/{value}")
	@Produces("text/plain")
	public Response GetValues(@PathParam("value") String value) {
		return Response.ok("Get Values " + value).build();
	}
	
}

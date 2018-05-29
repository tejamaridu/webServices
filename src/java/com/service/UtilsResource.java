
package com.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Maridu
 */
@Path("utils")
public class UtilsResource {

    @GET
    @Path("/sampleString")
    public String sampleString() {
        return "Teja";
    }
    
    @GET
    @Path("sampleJson")
    public Response sampleJson() {
        try {
            return Response.ok().entity("{ \"id\":\"A1\",  \"name\":\"Teja\", \"age\":27, \"sal\":27000, \"city\":\"Hyderabad\" }").header("Access-Control-Allow-Origin", "*").build();
        } catch (Exception e) {
            return Response.serverError().entity("ERROR").build();
        }
    }

    @GET
    @Path("sampleListJson")
    public Response sampleListJson() {
        try {
            return Response.ok().entity("[{\"id\":\"100\",\"name\":\"Teja\",\"dob\":678931200000,\"age\":27,\"sal\":30000,\"city\":\"Hyderabad\"},"
                    + "{\"id\":\"2000\",\"name\":\"Phani\",\"dob\":601953550000,\"age\":29,\"sal\":40000,\"city\":\"USA\"},"
                    + "{\"id\":\"3000\",\"name\":\"Sunny\",\"dob\":758164750000,\"age\":23,\"sal\":10000,\"city\":\"Chennei\"},"
                    + "{\"id\":\"4000\",\"name\":\"Sai\",\"dob\":858164750000,\"age\":20,\"sal\":10000,\"city\":\"Chennei\"}]")
                    .header("Access-Control-Allow-Origin", "*")
                    .build();
        } catch (Exception e) {
            return Response.serverError().entity("ERROR").build();
        }
    }
    
    @GET
    @Path("empById")
    public Response empById(@QueryParam("empId") int empId) {
        try {
            String empData = "";
            if(empId < 1000){
                empData = "{ \"id\":\"100\",  \"name\":\"Teja\", \"age\":27, \"sal\":30000, \"dob\":678931200000, \"city\":\"Hyderabad\" }";
            }else{
                empData = "{ \"id\":\"2000\",  \"name\":\"Phani\", \"age\":29, \"sal\":40000, \"dob\":601953550000, \"city\":\"USA\" }";
            }
            return Response.ok().entity(empData).header("Access-Control-Allow-Origin", "*").build();
        } catch (Exception e) {
            return Response.serverError().entity("ERROR").build();
        }
    }

    @GET
    @Path("getSum")
    public Response getSum(@QueryParam("a") int a, @QueryParam("b") int b) {
        try {
            return Response.ok().entity(a + b + "").header("Access-Control-Allow-Origin", "*").build();
        } catch (Exception e) {
            return Response.serverError().entity("ERROR").build();
        }
    }
}

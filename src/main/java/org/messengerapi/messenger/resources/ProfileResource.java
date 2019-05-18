package org.messengerapi.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.messengerapi.messenger.model.Message;
import org.messengerapi.messenger.model.Profile;
import org.messengerapi.messenger.service.MessageService;
import org.messengerapi.messenger.service.ProfileService;
@Path("/profiles")
public class ProfileResource {


    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	ProfileService ps=new ProfileService();
	
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getProfiles() {
    	List<Profile> list=ps.getAllProfiles();
        return list;
    }
    
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Profile addProfile(Profile prof) {
    	return ps.addProfile(prof);
    }
	
	@PUT
	@Path("/{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Profile updateProfile(@PathParam("profileName")String pName, Profile prof) {
		return ps.updateProfile(prof);
    }
    

	@DELETE
	@Path("/{profileName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Profile deleteProfile(@PathParam("profileName")String pName) {
		return ps.removeProfile(pName);
    }
    
    @GET
    @Path("/{profileName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Profile getProfile(@PathParam("profileName")String pName) {
    //	int i=Integer.parseInt(id);
    	return ps.getProfile(pName);
    }


}

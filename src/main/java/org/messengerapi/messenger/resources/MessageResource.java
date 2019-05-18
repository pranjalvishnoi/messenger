package org.messengerapi.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.messengerapi.messenger.model.*;
import org.messengerapi.messenger.resources.beancontext.MessageFilterBean;
import org.messengerapi.messenger.service.*;

@Path("/messages")
@Produces(value= {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class MessageResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	MessageService ms=new MessageService();
	
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		if(filterBean.getYear()>0)
		{
			List<Message> list=ms.getYearMessage(filterBean.getYear());
			return list;
		}
		
		if(filterBean.getStart()>=0 && filterBean.getSize()>0)
		{
			System.out.println("inside start end");
			List<Message> list=ms.getMessagePaginated(filterBean.getStart(), filterBean.getSize());
			System.out.println("inside start end back");
			
			return list;
		}
    	List<Message> list=ms.getAllMessages();
        return list;
    									}
    
    @GET
    @Produces(MediaType.TEXT_XML)
    public List<Message> getXmlMessages(@BeanParam MessageFilterBean filterBean) {
    	System.out.println("xml method called");
		if(filterBean.getYear()>0)
		{
			List<Message> list=ms.getYearMessage(filterBean.getYear());
			return list;
		}
		
		if(filterBean.getStart()>=0 && filterBean.getSize()>0)
		{
			System.out.println("inside start end");
			List<Message> list=ms.getMessagePaginated(filterBean.getStart(), filterBean.getSize());
			System.out.println("inside start end back");
			
			return list;
		}
    	List<Message> list=ms.getAllMessages();
        return list;
    									}
    
	/*@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMessage(Message msg) throws URISyntaxException {
    	//return ms.addMessage(msg);
		Message m=ms.addMessage(msg);
		return Response.created(new URI("/messager/weapi/messages/"+msg.getId()))
						.entity(m)
						.build();						
	}
	*/
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    public Response addMessage(Message msg, @Context UriInfo uriInfo) {
    	//return ms.addMessage(msg);
		Message m=ms.addMessage(msg);
	//	String id=String.valueOf(m.getId());
		URI uri=uriInfo.getAbsolutePathBuilder().path(String.valueOf(m.getId())).build();
		System.out.println("done");
		return Response.created(uri)
						.entity(m)
						.build();	
		
	}
	
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messageId")int id, Message msg) {
    	msg.setId(id);
		return ms.updateMessage(msg);
    }
    

	@DELETE
	@Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message deleteMessage(@PathParam("messageId")int id) {
		return ms.removeMessage(id);
    }
    
    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId")int id,@Context UriInfo uriInfo) {
    //	int i=Integer.parseInt(id);
    	Message msg= ms.getMessage(id);
    	String selfLink = ms.getUriForSelf(uriInfo, msg);
    	String profileLink = ms.getUriForProfile(uriInfo, msg);
    	String commnetsLink = ms.getUriForComment(uriInfo, msg); 
    	
    	msg.addLink(selfLink, "self");
    	msg.addLink(profileLink, "profile");
    	msg.addLink(commnetsLink, "comments");
    	return msg;
    }


    @Path("/{messageId}/comments")
    public CommentResource getCommentResource() {
    	return new CommentResource();
    }


    
}

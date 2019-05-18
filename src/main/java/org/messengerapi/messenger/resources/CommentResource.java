package org.messengerapi.messenger.resources;

import java.net.URI;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.messengerapi.messenger.model.Comment;
import org.messengerapi.messenger.model.Message;
import org.messengerapi.messenger.resources.beancontext.MessageFilterBean;
import org.messengerapi.messenger.service.CommentService;
import org.messengerapi.messenger.service.MessageService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {


    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	CommentService cs=new CommentService();
	
	
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getAllComments(@PathParam("messageId") int messageId) {
		List<Comment> comment=cs.getAllComments(messageId);
        return comment;
    }
    

	@GET
	@Path("/{commentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comment getComments(@PathParam("commentId") int commentId, @PathParam("messageId") int messageId) {
		Comment comment=cs.getComment(messageId,commentId);
        return comment;
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
    public Response addComment(Comment comment,@PathParam("commentId") int commentId, @PathParam("messageId") int messageId, @Context UriInfo uriInfo) {
    	//return ms.addMessage(msg);
		Comment c=cs.addComment(messageId,comment);
	//	String id=String.valueOf(m.getId());
		URI uri=uriInfo.getAbsolutePathBuilder().path(String.valueOf(c.getId())).build();
		return Response.created(uri)
						.entity(c)
						.build();	
		
	}
	
	
	@PUT
	@Path("/{commentId}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment updateComment(@PathParam("messageId")int id, @PathParam("commentId") int commentId,Comment comment) {
    	comment.setId(commentId);
		return cs.updateComment(id, comment);
    }
    

	@DELETE
	@Path("/{commentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comment deleteComment(@PathParam("messageId")int id,  @PathParam("commentId") int commentId) {
		return cs.removeComment(id,commentId);
    }
    



}

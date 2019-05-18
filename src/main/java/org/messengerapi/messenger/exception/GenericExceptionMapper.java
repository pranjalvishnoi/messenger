package org.messengerapi.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.messengerapi.messenger.model.ErrorMessage;
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		// TODO Auto-generated method stub
		ErrorMessage eMsg=new ErrorMessage(500,exception.getMessage(),"http://google.com");
		System.out.println("chekpoint");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
					   .entity(eMsg).build();
	}

}

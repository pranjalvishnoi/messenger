package org.messengerapi.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.messengerapi.messenger.model.ErrorMessage;
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		// TODO Auto-generated method stub
		ErrorMessage eMsg=new ErrorMessage(404,exception.getMessage(),"http://google.com");
		System.out.println("chekpoint");
		return Response.status(Status.NOT_FOUND)
					   .entity(eMsg).build();
	}

}

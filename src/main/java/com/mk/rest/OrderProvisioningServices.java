package com.mk.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mk.pojo.CloudProvisioningFlow;
import com.mk.pojo.OrderApprovalSubFlow;
import com.mk.pojo.OrderCollectionSubFlow;
import com.mk.pojo.OrderCompletionSubFlow;
import com.mk.pojo.OrderProvisioningSubFlow;
import com.mk.pojo.OrderValidationSubFlow;
import com.mk.pojo.Task;
import com.mk.pojo.user;
import com.mk.transaction.TransactionBo;
import com.mk.transaction.impl.App;

@Component
@Path("/provisioning")
public class OrderProvisioningServices {

	@Autowired
	TransactionBo transactionBo;
	
	@Context
	UriInfo req;
	
	@GET
	@Path("/get/{username}/{password}")
	@Produces(MediaType.APPLICATION_XML)
	public Response get(@PathParam("username") String username,@PathParam("password") String password) {

		user result = transactionBo.get(username,password);
		Response res=Response.status(200).entity(result).build();
		user obj=(user)res.getEntity();
		obj.setPassword(password);
		return Response.status(200).contentLocation(URI.create("http://localhost:8080/rest/test")).entity(obj).build();

	}

	@GET
	@Path("/flow/{orderid}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response get(@PathParam("orderid") String orderid) {
		return Response.status(200).contentLocation(URI.create("http://localhost:8080/rest/test")).entity(App.fetchProvisioningFlow(orderid)).build();
	}
	
	@POST
	@Path("/insert")
	public Response insert(user user) {

		
		String result = transactionBo.insert();
		System.out.println("\nentity working @#@$ "+user.getUserName());
		System.out.println(user.getPassword());
		return Response.status(200).entity(result).build();

	}

	@PUT
	@Path("/update")
	public Response update() {

		String result = transactionBo.update();

		return Response.status(200).entity(result).build();

	}

	@DELETE
	@Path("/delete")
	public Response delete() {

		String result = transactionBo.delete();

		return Response.status(200).entity(result).build();

	}

}
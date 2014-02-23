package com.mk.rest;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

public class CustomFilter implements ContainerRequestFilter{

	@Override
	public ContainerRequest filter(ContainerRequest request) {
		// TODO Auto-generated method stub
		System.out.println("hgfhgf");
		return request;
	}

}

package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.jupiter.api.Test;

import com.store.service.FruitType;

class TestTheService {

	private static final String BASE_PATH = "http://localhost:8080/FruitShop/api/shop/";

	@Test
	void assertThatAppleIsReturnedFromService() {
		String endpoint = BASE_PATH + "save?test=123";
		final ResteasyClient client = new ResteasyClientBuilder().build();
		final ResteasyWebTarget target = client.target(endpoint);
		Response response = target.request().get(Response.class);

		assertEquals(response.readEntity(String.class), FruitType.APPLE.toString());
	}

	@Test
	void assertPostEndPointParameterNeeded422() {
		String endpoint = BASE_PATH + "post";
		Form form = new Form();
		form.param("test", null);
		Entity<Form> entity = Entity.form(form);
		final ResteasyClient client = new ResteasyClientBuilder().build();
		final ResteasyWebTarget target = client.target(endpoint);
		Response response = target.request(MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(entity);

		assertEquals(response.getStatus(), Status.BAD_REQUEST.getStatusCode());
	}

	@Test
	void assertPostWasSuccessfullyCreated() {
		System.out.println(123);
		String endpoint = BASE_PATH + "post";
		Form form = new Form();
		form.param("test", "asd");
		Entity<Form> entity = Entity.form(form);
		final ResteasyClient client = new ResteasyClientBuilder().build();
		final ResteasyWebTarget target = client.target(endpoint);
		Response response = target.request(MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(entity);

		assertEquals(response.getStatus(), Status.CREATED.getStatusCode());
		assertEquals(response.readEntity(String.class), FruitType.APPLE.toString());
	}
}
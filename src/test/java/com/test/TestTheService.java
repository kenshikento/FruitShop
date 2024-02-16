package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.jupiter.api.Test;

class TestTheService {

	private static final String FULL_PATH = "http://localhost:8080/MavenWebApp/api/user-management/apples?test=123";
	
	@Test
	void addition() {
		
        final ResteasyClient client = new ResteasyClientBuilder().build();
        final ResteasyWebTarget target = client.target(FULL_PATH);
        String response = target.request().get(String.class);
        
        assertEquals(response, "123");
	}
}
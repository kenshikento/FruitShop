package com.store;

import jakarta.validation.Valid;
import org.jboss.resteasy.annotations.Form;

import com.store.form.FormRequest;
import com.store.service.FruitFactory;
import com.store.service.FruitService;
import com.store.service.FruitType;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "movies")
@Path("/movies")
public class ShopService {
	
	private final FruitService apple; 
	private final FruitService strawberry;
	
	public ShopService() {
		this.apple = (new FruitFactory()).getInstanceType(FruitType.APPLES);
		this.strawberry = (new FruitFactory()).getInstanceType(FruitType.STRAWBERRY);
	}
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Path("/save/resource")
	public void postServiceInfos(
			@Form FormRequest request
	) {
	  FruitService fruitServer = (new FruitFactory()).getInstanceType(FruitType.STRAWBERRY);
	  
	  System.out.println("-----"  + fruitServer.getEndPoint());
	}
  
  @GET
  @Path("/apples")
  public String getServiceTestInfo(
		  @Valid @QueryParam("test") String test
		  ) {
	  System.out.println("-----"  + this.strawberry);
	  
	  System.out.println("-----"  + this.apple);
	  return this.apple.getEndPoint();
  }
  
  @GET
  @Path("/test")
  public String test() {
	  System.out.println("-----"  + this.strawberry);
	  
	  System.out.println("-----"  + this.apple);
	  return this.apple.getEndPoint();
  }
}

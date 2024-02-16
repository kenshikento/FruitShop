package com.test;

import jakarta.validation.Valid;
import org.jboss.resteasy.annotations.Form;
import com.test.form.FormRequest;
import com.test.service.FruitFactory;
import com.test.service.FruitService;
import com.test.service.FruitType;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "user-management")
@Path("/user-management")
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
}
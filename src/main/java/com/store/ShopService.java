package com.store;

import org.jboss.resteasy.annotations.Form;

import com.store.form.FormRequest;
import com.store.service.FruitFactory;
import com.store.service.FruitService;
import com.store.service.FruitType;

import io.smallrye.config.SmallRyeConfig;
import io.smallrye.config.SmallRyeConfigBuilder;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "shop")
@Path("/shop")
public class ShopService {

	private final FruitService apple;
	private final FruitService strawberry;

	public ShopService() {
		this.apple = (new FruitFactory()).getInstanceType(FruitType.APPLE);
		this.strawberry = (new FruitFactory()).getInstanceType(FruitType.STRAWBERRY);
	}

	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Path("/post")
	public Response postServiceInfos(@Valid @Form FormRequest request) {
		return Response.status(Response.Status.CREATED).entity(this.apple.getEndPoint()).build();
	}

	@GET
	@Path("/save")
	public String getServiceTestInfo(@Valid @QueryParam("test") String test) {
		SmallRyeConfig config = new SmallRyeConfigBuilder().addDefaultInterceptors().addDefaultSources().build();
		String message = config.getValue("website.type", String.class);
		FruitFactory factory = new FruitFactory();

		String result = factory.getInstanceType(FruitType.valueOf(message)).getEndPoint();
		return result;

	}
}

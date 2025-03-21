package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class userEndPoints 
//created for the perform CRUD Optioration
{
	public static Response CreateUserd(User payload)
{
		
		System.out.println("Making POST request to: " + Routes.post);

	Response res=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
	
	.when()
		.post(Routes.post);
	
	return res ;
}
	public static Response redUser(String username)
	{
		Response res=given()
				.pathParam("username", username)
		
		.when()
			.get(Routes.get);
		
		return res ;
	}
	public static Response updateUser(String username, User payload)
	{
		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", username)
			.body(payload)

		.when()
			.put(Routes.update);
		
		return res ;
	}
	
	public static Response deletUser(String username)
	{
		Response res=given()
				.pathParam("username", username)
		
		.when()
			.delete(Routes.delet);
		
		return res ;
}
}

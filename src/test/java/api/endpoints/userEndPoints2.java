package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class userEndPoints2 
//created for the perform CRUD Optioration
{
	//CRATED FOR THE geting the UL=RL"S from the property file
	
	
		static ResourceBundle getUrl()
		{
			ResourceBundle routes = ResourceBundle.getBundle("Route");//LOAD THE THE PROPERTY FILE & read the data form the property file 
			return routes;
		
	}
	public static Response CreateUserd(User payload)
{
		//New
		String Post=getUrl().getString("post");
		
		Response res=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
	
	.when()
	
		//.post(Routes.Base_url);
		.post(Post);
		
	
	return res ;
}
	public static Response redUser(String username)
	{
		String get=getUrl().getString("get");
		
		Response res=given()
				.param("username", username)
		
		.when()
			//.get(Routes.get);
		.get(get);
		
		return res ;
	}
	public static Response updateUser(String username, User payload)
	{
		//New
				String update=getUrl().getString("update");
				
		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", username)
			.body(payload)

		.when()
			//.put(Routes.update);
		
		.put(update);
		
		return res ;
	}
	
	public static Response deletUser(String username)
	{
		String delete=getUrl().getString("update");
		Response res=given()
				.param("username", username)
		
		.when()
			//.delete(Routes.delet);
		.delete(delete);
		return res ;
}
}

package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userEndPoints;
import api.payload.User;
import api.utilitie.DataProvider;
import io.restassured.response.Response;

public class DDTest 
{
	@Test(priority=1, dataProvider="data", dataProviderClass=DataProvider.class)	
	public void testPostUser(String userid,String UserName, String FristName, String LastName, String Email,String PassWord, String phone) 
	{
		User userpyload =new User();
		
		userpyload.setId(Integer.parseInt(userid));
		userpyload.setUsername(UserName);
		userpyload.setLastName(LastName);
		userpyload.setFirstName(FristName);
		userpyload.setEmail(Email);
		userpyload.setPassword(PassWord);
		userpyload.setPhone(phone);
		
		Response response = userEndPoints.CreateUserd(userpyload);
		
		Assert.assertEquals(response.getStatusCode(), 200);


	}
	
	@Test(priority=2, dataProvider="UserName", dataProviderClass=DataProvider.class)	
	public void testdeletuser(String username)
	{
		Response response =userEndPoints.deletUser(username);
		Assert.assertEquals(response.getStatusCode(), 200);	
	}
}

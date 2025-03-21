package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Routes;
import api.endpoints.userEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest 

{
	Faker faker;
	User userpyload;
public  Logger logger;
@BeforeClass
public void createDATA()
{
	faker =new Faker();
	userpyload =new User();
	
	userpyload.setId(faker.idNumber().hashCode());
	userpyload.setUsername(faker.name().username());
	userpyload.setLastName(faker.name().lastName());
	userpyload.setFirstName(faker.name().firstName());
	userpyload.setEmail(faker.internet().safeEmailAddress());
	userpyload.setPassword(faker.internet().password(5,10));
	userpyload.setPhone(faker.phoneNumber().cellPhone());
	
	
	logger =LogManager.getLogger(this.getClass());
}
	@Test(priority=1)
	void TestPostUser()
	{
		System.out.println("Making POST request to: " + Routes.post);

		logger.info("------------------crating user--------------");
		Response response = userEndPoints.CreateUserd(userpyload);
		//new
		//Response response = userEndPoints2.CreateUserd(userpyload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Username: " + userpyload.getUsername());
	}
	@Test(priority=2 , dependsOnMethods = "TestPostUser")
	public void testGetUserByName()
	{	
		System.out.println("Username: " + userpyload.getUsername());
		
		logger.info("------------------geting user--------------");
		Response redUser = userEndPoints.redUser(this.userpyload.getUsername());
		redUser.then().log().all();
		Assert.assertEquals(redUser.getStatusCode(), 200);
		logger.info("------------------ user created--------------");
	}
	@Test(priority=3)
	void updateuser() 
	{
		
		//update data
		logger.info("------------------updating  user--------------");
		userpyload.setLastName(faker.name().lastName());
		userpyload.setFirstName(faker.name().firstName());
		userpyload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = userEndPoints.updateUser(this.userpyload.getUsername(),userpyload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("------------------  user is updated --------------");
		//checking data after updation
		Response responseAfterupadate = userEndPoints.redUser(this.userpyload.getUsername());
		responseAfterupadate.then().log().all();
		Assert.assertEquals(responseAfterupadate.getStatusCode(), 200);
		
	}
	
	@Test(priority=4)
	void deletuserByName() 
	{
		
		logger.info("------------------  deleting user--------------");
		Response response = userEndPoints.deletUser(this.userpyload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("------------------  user is deleted --------------");
	}
	
}


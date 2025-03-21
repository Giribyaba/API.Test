

package api.endpoints;

//Swgger url
// post :https://petstore.swagger.io/v2/user/
//get:https://petstore.swagger.io/v2/user/{username}
//get:https://petstore.swagger.io/v2/user/{username}
//delete:https://petstore.swagger.io/v2/user/{username}


public class Routes {
	
	
    public static String Base_url="https://petstore.swagger.io/v2";

//user model
 public static String   post="https://petstore.swagger.io/v2/user";
 public static String   get="https://petstore.swagger.io/v2/user/{username}";
 public static String   update=Base_url+ "/user/{username}";
 public static String   delet=Base_url+ "/user/{username}";
 

}

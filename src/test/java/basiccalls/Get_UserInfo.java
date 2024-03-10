package basiccalls;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Get_UserInfo
{
	@Test
	public void getCreatedUser()
	{
RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response resp = given()
		
		.pathParam("username", "thirdusername")
		
		.when()
		
		.get("user/{username}")
		
		.then()
		
		.extract()
		
		.response();
		
		String response = resp.asPrettyString();
		
		System.out.println(response);

		

	}
}

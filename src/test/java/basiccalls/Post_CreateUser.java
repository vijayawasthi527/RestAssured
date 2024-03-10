package basiccalls;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Post_CreateUser
{

	@Test
	public void Post_Createuser()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		Response resp = given()
		
		.body("{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"username\": \"thirdusername\",\r\n"
				+ "  \"firstName\": \"Raven\",\r\n"
				+ "  \"lastName\": \"Johnson\",\r\n"
				+ "  \"email\": \"raven@gmail.com\",\r\n"
				+ "  \"password\": \"Test@1234\",\r\n"
				+ "  \"phone\": \"9877546210\",\r\n"
				+ "  \"userStatus\": 0\r\n"
				+ "}")
		
		.header("Content-Type", "application/json")
		
		.when()
		
		.post("/user")
		
		.then()
		
		.extract()
		
		.response();
			
		String response = resp.asPrettyString();
		
		System.out.println(response);


	}
}

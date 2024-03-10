package basiccalls;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_listofUsersWithQueryParam 
{

	@Test
	public void getlistofusers()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		Response resp = given()
						
						.queryParam("page","2")
		
						.when()
		
						.get("api/users")
		
						.then()
		
						.extract()
		
						.response();
		
		String responce=resp.asPrettyString();
		
		System.out.println(responce);
	}
}

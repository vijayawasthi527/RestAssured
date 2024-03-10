package practice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Practice2 
{
	
	@Test
	public void myMethod()
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

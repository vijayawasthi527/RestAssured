package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Practice1
{

	@Test
	public void myTest()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		Response res = given()
		
		.when()
		
		.get("api/users?page=2")
		
		.then()
		
		.extract()
		
		.response();
		
		String response=res.asPrettyString();
		
		System.out.println(response);
	}
}

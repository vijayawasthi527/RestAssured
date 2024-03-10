package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Pojo_implement
{

	@Test
	public void Post_Createuser()
	{
		Pojo1 mainobject=new Pojo1();
		mainobject.setName("Vijay");
		mainobject.setJob("Tester");
		RestAssured.baseURI="https://reqres.in/api";
		
		Response resp = given()
		
		.body(mainobject)
		
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

package basiccalls;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class Get_List_Of_Users {
	
	@Test
	public void Get_Listofusers()
	{
			RestAssured.baseURI="https://reqres.in/";
			
			Response resp = given()
			
							.when()
			
							.get("api/users?page=1")
			
							.then()
			
							.extract()
			
							.response();
			
			String responce=resp.asPrettyString();
			
			System.out.println(responce);
	}

}

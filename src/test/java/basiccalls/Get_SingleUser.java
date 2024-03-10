package basiccalls;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Get_SingleUser 
{
	
	@Test
	public void getsingleuserdetails()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		Response resp = given()
		
		.when()
		
		.get("/api/users/2")
		
		.then()
		
		.extract()
		
		.response();
		
	String responce = resp.asPrettyString();
	
	System.out.println(responce);
	}

}

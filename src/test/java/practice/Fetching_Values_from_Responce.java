package practice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Fetching_Values_from_Responce 
{
	@Test
	public void mytest()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		Response res = given()
		
		.when()
		
		.get("api/users?page=2")
		
		.then()
		
		.extract()
		
		.response();
		
		String response = res.asPrettyString();
		
		System.out.println(response);
		
		int code = res.getStatusCode();
		
		System.out.println(code);
		
		Headers listallheaders = res.getHeaders();
		
		List<Header> headerslist = listallheaders.asList();
		System.out.println(headerslist);
		
		String myheader = res.getHeader("Content-Type");
		System.out.println(myheader);
		
	}
}

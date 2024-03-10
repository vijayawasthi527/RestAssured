package fetching_data_from_responce;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class Fetching_Values_From_Responce 
{
	@Test
	public void fetchdata()
	{
RestAssured.baseURI = "https://reqres.in/";
		
		Response resp = given()
				
				.when()
		
				.get("api/users?page=2")
		
				.then()
		
				.extract()
		
				.response();

		String response = resp.asPrettyString();

		System.out.println(response);

		int statusCode = resp.statusCode();

		System.out.println(statusCode);

		Assert.assertEquals(statusCode,200,"Test case passed");


		long timerequired = resp.getTime();

		System.out.println(timerequired);

		Headers headersvalue = resp.getHeaders();

		List<Header> listofheaders = headersvalue.asList();

		System.out.println(listofheaders);

		String valueOfHeader = resp.getHeader("Content-Type");

		System.out.println(valueOfHeader);





		
		
	}
}

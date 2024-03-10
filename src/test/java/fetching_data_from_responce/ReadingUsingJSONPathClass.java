package fetching_data_from_responce;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReadingUsingJSONPathClass 
{
	
	@Test
	public void getListOfUsers()
	{
		RestAssured.baseURI = "https://reqres.in";
		
Response resp = given()
		
				.when()
		
				.get("api/users/2")
		
				.then()
		
				.extract()
		
				.response();

String response = resp.asPrettyString();

System.out.println(response);


JsonPath jp = new JsonPath(response);

String emailValue = jp.getString("data.email");

System.out.println(emailValue);
		
		
	}

}


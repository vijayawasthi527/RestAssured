package fetching_data_from_responce;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class FetchDataFromResponseWithSimpleJson 
{
	@Test
	public void createUser() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		
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
		
		JsonPath jp = resp.jsonPath();
		
		String typeValue = jp.getString("type");
		
		System.out.println(typeValue);//unknown
		
		int codeValue = jp.getInt("code");
		
		System.out.println(codeValue);//200
	
}}

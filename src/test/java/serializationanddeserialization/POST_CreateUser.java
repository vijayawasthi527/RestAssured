package serializationanddeserialization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.RequestBody;
import pojo.ResponseBody;

public class POST_CreateUser {
	
	
	@Test
	public void createUser() {
		
		
		RequestBody mainObject = new RequestBody();
		
		mainObject.setId(0);
		mainObject.setUsername("serialuser");
		mainObject.setFirstName("testuser");
		mainObject.setLastName("testlastname");
		mainObject.setEmail("abc@test.com");
		mainObject.setPassword("Test@1234");
		mainObject.setPhone("9988776655");
		mainObject.setUserStatus(0);
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		
	ResponseBody responseObject = given()
		
		.body(mainObject)
		
		.header("Content-Type", "application/json")
		
		.log().all()
		
		.when()
		
		.post("/user")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response().as(ResponseBody.class);
		
	int codeValue = responseObject.getCode();
	
	System.out.println(codeValue);
	
String value	= responseObject.getMessage();

System.out.println(value);
		
			
		
	}
	

}
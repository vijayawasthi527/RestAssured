package specbuilder;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CreateUser {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void initRequestAndResponseSpecBuilder()
	{
		//defining request properties
		
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		
		requestSpecBuilder.setBaseUri("https://petstore.swagger.io/v2");
		
		requestSpecBuilder.addHeader("Content-Type", "application/json");
		
		requestSpecBuilder.log(LogDetail.ALL);
		
		requestSpecification = requestSpecBuilder.build();
		
//		Defining response properties
		
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
		
		responseSpecBuilder.expectStatusCode(200);
		
		responseSpecBuilder.expectContentType(ContentType.JSON);
		
		responseSpecBuilder.log(LogDetail.ALL);
		
		responseSpecification = responseSpecBuilder.build();
		
	}

	@Test
	public void createUser() 
	{
		
		given()
		
		.spec(requestSpecification)
		
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
	
		
		.when()
		
		.post("/user")
		
		.then()
		
		.spec(responseSpecification);
		
		
	

}
}
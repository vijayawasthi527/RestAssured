package practice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.cucumber.java.it.Data;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FetchDatafromresponsewithsimplejson 
{
@Test
public void mymethod()
{
	RestAssured.baseURI="https://reqres.in";
	
	Response res = given()
	
	.when()
	
	.get("api/users?page=2")
	
	.then()
	
	.extract()
	
	.response();
	
	String response=res.asPrettyString();
	
	System.out.println(response);
	
	JsonPath jp = res.jsonPath();
	
	int perpageval = jp.getInt("per_page");
	System.out.println(perpageval);
	
	String url = jp.getString("support.url");
	System.out.println(url);
	
	int idvalue = jp.getInt("data[3].id");
	System.out.println(idvalue);
	
	String emailid = jp.getString("data[3].email");
	System.out.println(emailid);
	
	int totalNumberofelementsinArray = jp.getInt("data.size()");
	System.out.println(totalNumberofelementsinArray);
	
	for(int i=0;i<totalNumberofelementsinArray;i++)
	{
		String email=jp.getString("data["+i+"].email");
		System.out.println(email);
	}
	
	for(int i=0;i<totalNumberofelementsinArray;i++)
	{
		String firstname=jp.getString("data["+i+"].first_name");
		System.out.println(firstname);
	}
	
	
}
}

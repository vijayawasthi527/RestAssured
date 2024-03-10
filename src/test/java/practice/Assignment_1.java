package practice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Assignment_1 
{
	@Test
	
	public void firstAssignment()
	{
		RestAssured.baseURI="www.abc.com";
		
		Response res = given()
		
		.when()
		
		.get("/user/course")
		
		.then()
		
		.extract()
		
		.response();
		
		String response=res.asPrettyString();
		
		System.out.println(response);
		
		JsonPath jp = res.jsonPath();
		//=============total number of course================
		int totalcourses=jp.getInt("courses.getsize()");
		System.out.println(totalcourses);
		
		//=============course amount=================
		int coursefees=jp.getInt("purchaseAmount");
		System.out.println(coursefees);
		
		//===============firstCourse Title=============
		String firstcoursetitle = jp.getString("courses[0].title");
		System.out.println(firstcoursetitle);
		
		//===============Print All course title with their respective price=========
		
		for(int i=0;i<totalcourses;i++)
		{
			String listoftitle=jp.getString("courses["+i+"].title");
			System.out.print(listoftitle);
			
			for(int j=i;j<totalcourses;j++)
			{
				int price=jp.getInt("courses["+i+"].price");
				System.out.println("----->"+price);
			}
		}
		//========================print number of copies sold by RPA course===========
		
		int rpacopies=jp.getInt("courses[2].copies");
		System.out.println(rpacopies);

		//====================
		
		
		
		
		
		
	}

}

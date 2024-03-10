package fetching_data_from_responce;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReadingResponseBodyFromComplexJson
{
	@Test
	public void getUserList()
	{
		RestAssured.baseURI = "https://reqres.in";
		
		Response resp = given()
				
						.when()
				
						.get("api/users?page=2")
				
						.then()
				
						.extract()
				
						.response();

		String response = resp.asPrettyString();

		System.out.println(response);
		
		JsonPath jp = resp.jsonPath();
				
		int perpageValue = jp.getInt("per_page");
		
		System.out.println(perpageValue);
		
		String urlValue = jp.getString("support.url");
		
		System.out.println(urlValue);//https://reqres.in/#support-heading
		
		String firstname = jp.getString("data[2].first_name");
		
		System.out.println(firstname);
		
		int idValue = jp.getInt("data[1].id");
		
		System.out.println(idValue);
		
		Assert.assertEquals(firstname, "Tobias");
		
		
//		Handling the dynamic elements of array in json
		
		int totalNumberOfElementsInArray = jp.getInt("data.size()");
		
		System.out.println(totalNumberOfElementsInArray);
		
		
		for(int i=0; i<totalNumberOfElementsInArray; i++)
		{
			String firstNameValue = jp.getString("data["+i+"].email");
			
			System.out.println(firstNameValue);
		}
		
	}

}


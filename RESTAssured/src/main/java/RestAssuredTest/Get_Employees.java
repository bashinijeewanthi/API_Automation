package RestAssuredTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Get_Employees {
	@Test
	public void GetAllEmployees()
	{   
		
		RestAssured.baseURI = "http://localhost:3000/employees/";

		
		RequestSpecification httpRequest = RestAssured.given();

		
		Response response = httpRequest.request(Method.GET, "/");
        
		int statusCode = response.getStatusCode();
			
		String responseBody = response.getBody().asString();
		
		assertEquals(statusCode, 200);
		Assert.assertEquals(responseBody.toLowerCase().contains("kushan") , true , "Response body contains Employee");
	

	}
 

}

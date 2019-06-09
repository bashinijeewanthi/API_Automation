package RestAssuredTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Delete_Employee {
	@Test
	public void CreateEmployee()
	{   
		
		RestAssured.baseURI = "http://localhost:3000/employees/5";
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		httpRequest.header("Content-Type", "application/json");
		
		Response response = httpRequest.delete("/");
	 
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println(response.body().asString());
		
	}

}

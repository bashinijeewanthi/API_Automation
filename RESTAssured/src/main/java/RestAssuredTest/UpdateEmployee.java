package RestAssuredTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class UpdateEmployee {
	@Test
	public void UpdateEmployees()
	{   
		
		RestAssured.baseURI = "http://localhost:3000/employees/6";
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		httpRequest.header("Content-Type", "application/json");
		requestParams.put("fist_name", "Bashini"); // Cast
		requestParams.put("last_name", "Jeewanthi");
		requestParams.put("email", "test123@test.com");
	
	
		httpRequest.body(requestParams.toJSONString());
		Response response = httpRequest.put("/");
	 
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}

}

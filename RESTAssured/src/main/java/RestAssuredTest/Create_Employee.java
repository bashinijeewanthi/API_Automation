package RestAssuredTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Create_Employee {
	@Test
	public void CreateEmployee()
	{   
		
		RestAssured.baseURI = "http://localhost:3000/employees/";
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		httpRequest.header("Content-Type", "application/json");
		requestParams.put("first_name", "Bashini"); // Cast
		requestParams.put("last_name", "Gamage");
		requestParams.put("email", "bashini@test.lk");
		httpRequest.body(requestParams.toJSONString());
		Response response = httpRequest.post();
	 
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		System.out.println(response.body().asString());
		
	}

}

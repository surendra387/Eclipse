package demo;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.HashMap;


public class TokenCreate {
	@Test
	public void loginUser() {
		HashMap requestBody=new HashMap();
		requestBody.put("id", UserLogin.Id);
		requestBody.put("username",Encryption.encodedUsername);
		requestBody.put("password", Encryption.encodedPassword);
		System.out.println(Encryption.encodedUsername);
		System.out.println(Encryption.encodedPassword);
		System.out.println(UserLogin.Id);
		Response res = given().body(requestBody).when().post("http://localhost:9002/rrb/api/retail-token-system/v1/auth/login");
		String Body=res.getBody().asString();
		System.out.println(Body);

	}

}

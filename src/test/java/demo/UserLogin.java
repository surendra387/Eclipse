package demo;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UserLogin {
	
public static String Id;
public static String enc_N;
public static String enc_K;

	@Test
	public void getSessionTest() {
		Response res = given().when().post("http://localhost:9002/rrb/api/retail-token-system/v1/auth/sessions");
		String Body=res.getBody().asString();
		System.out.println(Body);
		
		JsonPath jp=new JsonPath(Body);
		String formatedJson=jp.prettify();
		System.out.println(formatedJson);
		
		Id = res.jsonPath().getString("data.id");
		enc_N = res.jsonPath().getString("data.enc_n");
		enc_K = res.jsonPath().getString("data.enc_k");

		System.out.println("id :" +Id);
		System.out.println("enc_n :" +enc_N);
		System.out.println(enc_K);
	}

//	@Test
	public void loginUser() {
		HashMap body=new HashMap();
		body.put("id", Id);
		body.put("username",Encryption.encodedUsername);
		body.put("password", Encryption.encodedPassword);
given()
.body(body)
.when()
.post("http://localhost:9002/rrb/api/retail-token-system/v1/auth/login");
//.then();
	}
}

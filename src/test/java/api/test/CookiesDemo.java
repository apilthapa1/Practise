package api.test;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.Map;

public class CookiesDemo {
	
	@Test(priority = 1)
	public void testCookies() {
		given()
		.when()
			.get("https://www.google.com")
		.then()
			.log().all();
	}
	
	@Test
	public void getCookiesInfo() {
		Response response = given()
							.when()
								.get("https://www.google.com");
		Map<String, String> cookiesValues = response.getCookies();
		System.out.println("Now");
		System.out.println(cookiesValues.keySet());
		System.out.println(cookiesValues.values());
		cookiesValues.forEach((key, value)-> System.out.println(key +" : " + value));
	}
	
}

package api.test;

import static io.restassured.RestAssured.given;
import org.testng.annotations.*;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class HeadersDemo {
	
	@Test(priority = 1)
	public void testHeaders() {
		given()
		.when()
			.get("httos://www.google.com")
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1");
	}
	
	@Test(priority = 2)
	public void getHeaders() {
		Response response = given()
							.when()
								.get("https://www.google.com");
		String headerValue = response.getHeader("Content-Type");
		Headers headerValues = response.getHeaders();
		System.out.println("Now");
		for (Header header : headerValues) {
			System.out.println(header.getName() + " : " + header.getValue());
		}
	}

}

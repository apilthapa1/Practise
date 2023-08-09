package api.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PathAndQueryParameters {
	
	private String url = "https://reqres.in/api/{mypath}";
	
	@Test
	public void testQueryAndPathParam() {
		given()
			.pathParam("mypath", "users")//path parameters
			.queryParam("page", 2)
			.queryParam("id", 5)
		.when()
			.get(url )
		.then()
			.log()
			.all();
	}

	
}

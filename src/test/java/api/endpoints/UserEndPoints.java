package api.endpoints;

import static io.restassured.RestAssured.given;

import api.base.Base;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	public static Response createUser(User payload) {
		String post_url = Base.getUrl("post_url");
		
		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(payload)
							.when()
								.post(post_url);
		return response;
	}
	
	public static Response readUser(String userName) {
		String get_url = Base.getUrl("get_url");
		Response response = given()
								.pathParam("username", userName)
							.when()
								.get(get_url);
		return response;
	}
	
	public static Response updateUser(String userName, User payload) {
		String update_url = Base.getUrl("update_url");
		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.pathParam("username", userName)
								.body(payload)
							.when()
								.put(update_url);
		return response;
	}
	
	public static Response deleteUser(String userName) {
		String delete_url = Base.getUrl("delete_url");
		Response response = given()
								.pathParam("username", userName)
							.when()
								.delete(delete_url);
		return response;
	}
}

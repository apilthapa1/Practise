package api.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import api.base.Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UsingExternalJsonFile {
	Response response;
	@Test
	public void createUser() throws FileNotFoundException {
		File file = new File("./body.json");
		FileReader fr = new FileReader(file);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		response = given()
				.contentType(ContentType.JSON)
				.body(data.toString())
			.when()
				.post(Base.getUrl("createUrl"));
			response.then()
				.statusCode(201)
				.body("name", equalTo("Scott"))
				.body("courses[0]", equalTo("C"))
				.header("Content-Type", "application/json; charset=utf-8")
				.log().all();
		}
		
		@Test(priority=2)
		public void testDeleteUser() {
			JSONObject jsonObj = new JSONObject(response.body().asString());
			Map<String, String> map = getHashMapValue(jsonObj);
			given()
				.pathParam("id", map.get("id"))
			.when()
				.delete(Base.getUrl("deleteUrl"));
		}
		
		private Map<String, String> getHashMapValue(JSONObject jObject) {
			HashMap<String, String> map = new HashMap<String, String>();
			Iterator<String> keys = jObject.keys();
			while(keys.hasNext()) {
				String key = (String)keys.next();
	            String value = jObject.get(key).toString(); 
	            map.put(key, value);
			}
			return map;
		}
}

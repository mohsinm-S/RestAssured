package RestAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SimpleProgram {
	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in/api";
		
	String response=given().header("x-api-key","reqres-free-v1").body(Payload.payment( "Mohsin")).
		when().put("/users/2").
		then().log().all().assertThat().statusCode(200)
		//.body("name", equalTo("mohsin"))
		.extract().response().asString();
	System.out.println(response);
	
	JsonPath js =new JsonPath(response);
	
	String s=js.getString("updatedAt");
	System.out.println(s);
		
	}

	
}

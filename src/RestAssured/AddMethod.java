package RestAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class AddMethod {

	public static void main(String[] args) throws IOException {
		RestAssured.baseURI="https://reqres.in/api";
		
		String response=given().header("x-api-key","reqres-free-v1").body(new String(Files.readAllBytes(Path.of("C:\\Users\\Mohsin\\eclipse-workspace\\Restassured\\Payloadfile\\Payload.json")))).
			when().put("/users/2").
			then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);
		
		JsonPath js =new JsonPath(response);
		
		String s=js.getString("updatedAt");
		System.out.println(s);
			
		}

	}



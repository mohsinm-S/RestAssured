package RestAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class OAoth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
RestAssured.baseURI="https://rahulshettyacademy.com";
		String generatetoken =
				given().formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")

                .formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")

                .formParams("grant_type", "client_credentials")

                .formParams("scope", "trust").when().post("/oauthapi/oauth2/resourceOwner/token").asString();
		
		JsonPath js=new JsonPath(generatetoken);
		String Accesstokem =js.get("access_token");
		
		System.out.println(Accesstokem);
		
		
		String getdetails =given().queryParam("access_token", Accesstokem).when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();
			
		System.out.println(getdetails);
		
	}

}

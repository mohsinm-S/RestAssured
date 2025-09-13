package RestAssured;

public class Payload {
	public static String payment(String name) {
		
		String requestBody = "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \"QA Lead\"\n" +
                "}";
		
		return requestBody;
	}

}

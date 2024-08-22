package anand.a2z;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIgnorePropertiesMain {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // Create a new User object
        DemoUser user = new DemoUser("anand patel", "anand.patel@gmail.com", "password123", "1234-4545-6789", "BGTPP098S");

        // Serialize the User object to JSON
        String jsonString = mapper.writeValueAsString(user);
        System.out.println("Serialized JSON: " + jsonString);

        // Deserialize the JSON back to a User object
        String jsonInput = "{\"name\":\"anand patel\",\"email\":\"anand.patel@gmail.com\",\"password\":\"password123\",\"aadhaar\":\"1234-4545-6789\",\"pan\":\"BGTPP098S\"}";
        DemoUser deserializedUser = mapper.readValue(jsonInput, DemoUser.class);
		System.out.println("Deserialized User: " + deserializedUser.toString());
    }
}

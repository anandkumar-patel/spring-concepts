package anand.a2z;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;

public class JsonManagedBackReferenceMain {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // Create a new User and Address objects
        DemoPerson person = new DemoPerson("anand patel", "anand.patel@gmail.com", null);
        DemoAddress address1 = new DemoAddress("33 hulimavu", "bangalore", person);
        DemoAddress address2 = new DemoAddress("22 ghatampur", "jaunpur", person);

        person.setAddresses(Arrays.asList(address1, address2));

        // Serialize the DemoPerson object to JSON
        String jsonString = mapper.writeValueAsString(person);
        System.out.println("Serialized JSON: " + jsonString);

        // Deserialize the JSON back to a DemoPerson object
//        String jsonInput = "{\"name\":\"anand patel\",\"email\":\"anand.patel@gmail.com\",\"addresses\":[{\"street\":\"33 hulimavu\",\"city\":\"bangalore\"},{\"street\":\"22 ghatampur\",\"city\":\"jaunpur\"}]}";
//        DemoPerson deserializedUser = mapper.readValue(jsonInput, DemoPerson.class);
//        System.out.println("Deserialized User: " + deserializedUser.toString());
    }
}

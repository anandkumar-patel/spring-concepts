package anand.a2z;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

public class DemoPerson {
    private String name;
    private String email;

    @JsonManagedReference
    private List<DemoAddress> addresses;

    public DemoPerson() {}

    public DemoPerson(String name, String email, List<DemoAddress> addresses) {
        this.name = name;
        this.email = email;
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<DemoAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<DemoAddress> addresses) {
        this.addresses = addresses;
    }
}

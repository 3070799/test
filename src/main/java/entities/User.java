package entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private transient int id;

    private String gender;

    private Name name;

    private Location location;

    private String email;

    private Login login;

    private Dob dob;

    private Registered registered;

    private String phone;

    private String cell;
    @SerializedName("id")
    private ID ID;

    private Picture picture;

    private String nat;

    public ID getID() {
        return ID;
    }

    public void setID(ID ID) {
        this.ID = ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "\n" + name.getTitle() + "." + name.getFirst() + "\n" +
                "|  gender: " + gender + "\n" +
                "|  name: " + name + "\n" +
                "|  location: " + location.toString() + "\n" +
                "|  email: " + email + "\n" +
                "|  login: " + login.toString() + "\n" +
                "|  dob: " + dob.toString() + "\n" +
                "|  registered: " + registered.toString() + "\n" +
                "|  phone: " + phone + "\n" +
                "|  cell: "  + cell + "\n" +
                "|  id: " + ID.toString() + "\n" +
                "|  picture: " + picture.toString() + "\n" +
                "|  nat: " + nat + "\n" +
                "--------------------------------------------------------------------------------";
    }
}

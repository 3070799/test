package entities;

import com.google.gson.annotations.Expose;
import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Login {

    private transient int id;

    private String uuid;

    private String username;

    private String password;

    private String salt;

    private String md5;

    private String sha1;

    private String sha256;

    public String toString() {
        return "\n" +
                "|  |  uuid: " + uuid + '\n' +
                "|  |  username: " + username + '\n' +
                "|  |  password: " + password + '\n' +
                "|  |  salt: " + salt + '\n' +
                "|  |  md5: " + md5 + '\n' +
                "|  |  sha1: " + sha1 + '\n' +
                "|  |  sha256: " + sha256;
    }
}

package entities;

import com.google.gson.annotations.Expose;
import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Picture {

    private transient int id;

    private String large;

    private String medium;

    private String thumbnail;

    public String toString() {
        return "\n" +
                "|  |  large: " + large + "\n" +
                "|  |  medium: " + medium + "\n" +
                "|  |  thumbnail: " + thumbnail;
    }
}

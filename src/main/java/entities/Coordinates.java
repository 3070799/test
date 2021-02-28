package entities;

import com.google.gson.annotations.Expose;
import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Coordinates {

    private transient int id;

    private double latitude;

    private double longitude;

    public String toString() {
        return "\n" +
                "|  |  |  latitude: " + latitude + "\n"+
                "|  |  |  longitude: " + longitude;
    }
}

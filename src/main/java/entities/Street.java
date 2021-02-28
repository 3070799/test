package entities;

import com.google.gson.annotations.Expose;
import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Street {

    private transient int id;

    private String name;

    private int number;

    public String toString() {
        return  "\n" +
                "|  |  |  name: " + name + '\n' +
                "|  |  |  number: " + number;
    }
}

package entities;

import com.google.gson.annotations.Expose;
import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Timezone {

    private transient int id;

    private String offset;

    private String description;

    public String toString() {
        return "\n" +
                "|  |  |  offset: " + offset + '\n' +
                "|  |  |  description: " + description;
    }
}

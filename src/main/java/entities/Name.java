package entities;

import com.google.gson.annotations.Expose;
import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Name {

    private transient int id;

    private String title;

    private String first;

    private String last;

    public String toString() {
        return  "\n" +
                "|  |  title: " + title + "\n" +
                "|  |  first: " + first + "\n" +
                "|  |  last: " + last;
    }

}

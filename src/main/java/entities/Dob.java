package entities;

import com.google.gson.annotations.Expose;
import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Dob {

    private transient int id;

    private String date;

    private int age;

    public String toString() {
        return "\n" +
                "|  |  date: " + date + '\n' +
                "|  |  age: " + age;
    }
}

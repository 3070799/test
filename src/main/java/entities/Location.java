package entities;

import com.google.gson.annotations.Expose;
import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Location {

        private transient int id;

        private Street street;

        private String city;

        private String state;

        private String postcode;

        private Coordinates coordinates;

        private Timezone timezone;

        public String toString() {
                return  "\n" +
                        "|  |  street: " + street.toString() + '\n' +
                        "|  |  city: " + city + '\n' +
                        "|  |  state: " + state + '\n' +
                        "|  |  postcode: " + postcode + '\n' +
                        "|  |  coordinates: " + coordinates.toString() + '\n' +
                        "|  |  timezone: " + timezone.toString();
        }
}

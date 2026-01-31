package trelud.student_credentials.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Address(String line){
        String[] tokens = line.split("\n");
        String[] secondLine = tokens[1].split(",");

        this.street = tokens[0];
        this.city = secondLine[0];
        if(secondLine.length > 1){
            this.county = secondLine[1].trim();
        }else{
            String[] splitThree = secondLine[0].split(" ");
            this.city = splitThree[0];
            this.county = splitThree[1] + " " + splitThree[2];
        }

    }

    private String street;
    private String city;
    private String county;
}

package official.sellandbuymotobike.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dbo_morbike")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Motorbike implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "license_plates", nullable = true)
    private String licensePlates;

    @Column(name = "odometer", nullable = false)
    private  int odometer;

    public Motorbike(int price, String status, String licensePlates, int odometer) {
        this.price = price;
        this.status = status;
        this.licensePlates = licensePlates;
        this.odometer = odometer;
    }
}

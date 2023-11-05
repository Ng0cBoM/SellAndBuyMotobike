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

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private MotorbikeBrand motorbikeBrand;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private MotorbikeModel motorbikeModel;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private MotorbikeType motorbikeType;

    @ManyToOne
    @JoinColumn(name = "capacity_id")
    private MotorbikeEngineCapacity motorbikeEngineCapacity;

    public Motorbike(int price, String status, String licensePlates, int odometer, MotorbikeBrand motorbikeBrand, MotorbikeModel motorbikeModel, MotorbikeType motorbikeType, MotorbikeEngineCapacity motorbikeEngineCapacity) {
        this.price = price;
        this.status = status;
        this.licensePlates = licensePlates;
        this.odometer = odometer;
        this.motorbikeBrand = motorbikeBrand;
        this.motorbikeModel = motorbikeModel;
        this.motorbikeType = motorbikeType;
        this.motorbikeEngineCapacity = motorbikeEngineCapacity;
    }
}

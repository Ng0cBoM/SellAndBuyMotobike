package official.sellandbuymotobike.entity;
import lombok.*;
import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name = "dbo_motorbikeEngineCapacity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotorbikeEngineCapacity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "capacity", nullable = false)
    private String capacity;
}
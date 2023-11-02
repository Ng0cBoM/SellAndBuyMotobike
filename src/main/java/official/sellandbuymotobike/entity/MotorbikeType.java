package official.sellandbuymotobike.entity;
import lombok.*;
import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name = "dbo_motorbikeType")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotorbikeType implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "name", nullable = false)
    private String name;
}

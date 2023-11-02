package official.sellandbuymotobike.entity;
import lombok.*;
import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name = "dbo_motorbikeBrand")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotorbikeBrand implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "name", nullable = false)
    private String name;
}

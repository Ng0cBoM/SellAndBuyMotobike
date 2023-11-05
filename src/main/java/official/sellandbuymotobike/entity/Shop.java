package official.sellandbuymotobike.entity;
import lombok.*;
import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name = "dbo_shop")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "number_of_followers", nullable = false)
    private int numberOfFollowers;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    public Shop(String name, String address, int numberOfFollowers, User user) {
        this.name = name;
        this.address = address;
        this.numberOfFollowers = numberOfFollowers;
        this.user = user;
    }
}

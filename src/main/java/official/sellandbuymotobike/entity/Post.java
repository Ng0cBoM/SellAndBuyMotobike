package official.sellandbuymotobike.entity;
import lombok.*;
import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name = "dbo_post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "state", nullable = false)
    private boolean state;

    @Column(name = "creation_date", nullable = false)
    private String creationDate;

    public Post(String title, String description, String address, boolean state, String creationDate) {
        this.title = title;
        this.description = description;
        this.address = address;
        this.state = state;
        this.creationDate = creationDate;
    }
}
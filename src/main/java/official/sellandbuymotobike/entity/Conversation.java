package official.sellandbuymotobike.entity;
import lombok.*;
import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name = "dbo_conversation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conversation implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @ManyToOne
    @JoinColumn(name = "user_id_1")
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user_id_2")
    private User user2;

}
package official.sellandbuymotobike.entity;

import lombok.*;
import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name = "dbo_message")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "time", nullable = false)
    private String time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private Conversation conversation;
}
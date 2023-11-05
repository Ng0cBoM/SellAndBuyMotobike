package official.sellandbuymotobike.entity.relationship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import official.sellandbuymotobike.entity.Motorbike;
import official.sellandbuymotobike.entity.Post;
import official.sellandbuymotobike.entity.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_post_motorbike")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPostMotorbike implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "motorbike_id")
    private Motorbike motorbike;

    public UserPostMotorbike(User user, Post post, Motorbike motorbike) {
        this.user = user;
        this.post = post;
        this.motorbike = motorbike;
    }
}
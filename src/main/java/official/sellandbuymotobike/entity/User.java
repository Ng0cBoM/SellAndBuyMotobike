package official.sellandbuymotobike.entity;

import lombok.*;
import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name = "dbo_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "number_of_followers", nullable = false)
    private int numberOfFollowers;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "creation_date", nullable = false)
    private String creationDate;

    public User(String email, String name, int numberOfFollowers, String password, String creationDate) {
        this.email = email;
        this.name = name;
        this.numberOfFollowers = numberOfFollowers;
        this.password = password;
        this.creationDate = creationDate;
    }
}
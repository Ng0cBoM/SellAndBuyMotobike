package official.sellandbuymotobike.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name = "dbo_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User  implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "phone",nullable = false)
    private String phone;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "creation_date",nullable = false)
    private String creationDate;

    public User(String name, String email, String phone, String username, String password, String creationDate) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.creationDate = creationDate;
    }
}

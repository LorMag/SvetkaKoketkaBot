package ssau.project.svetkakoketkabot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    private Long id;

    private String firstName;

    private String userName;

    private String registeredAt;


    public User(Long id, String firstName, String userName, String registeredAt) {
        this.id = id;
        this.firstName = firstName;
        this.userName = userName;
        this.registeredAt = registeredAt;
    }
}

package ssau.project.svetkakoketkabot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class FrogPhoto {
    @Id
    private Long id;

    private String url;

    private String text;
}

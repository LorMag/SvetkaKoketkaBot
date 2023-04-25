package ssau.project.svetkakoketkabot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "morning_photo")
public class MorningPhoto {
    @Id
    private Long id;

    private String url;

    public MorningPhoto(Long id, String url) {
        this.id = id;
        this.url = url;
    }
}

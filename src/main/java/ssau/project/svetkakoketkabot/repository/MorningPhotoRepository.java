package ssau.project.svetkakoketkabot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ssau.project.svetkakoketkabot.entity.MorningPhoto;

public interface MorningPhotoRepository extends CrudRepository<MorningPhoto, Long> {
    @Query(value = "select count(id) from morning_photo", nativeQuery = true)
    Long getCountRows();
}

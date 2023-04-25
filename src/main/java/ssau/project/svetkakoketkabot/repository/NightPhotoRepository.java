package ssau.project.svetkakoketkabot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ssau.project.svetkakoketkabot.entity.NightPhoto;

public interface NightPhotoRepository extends CrudRepository<NightPhoto, Long> {
    @Query(value = "select count(id) from night_photo", nativeQuery = true)
    Long getCountRows();
}

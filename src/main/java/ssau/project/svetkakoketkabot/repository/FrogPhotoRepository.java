package ssau.project.svetkakoketkabot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ssau.project.svetkakoketkabot.entity.FrogPhoto;

public interface FrogPhotoRepository extends CrudRepository<FrogPhoto, Long> {

    @Query(value = "select count(id) from frog_photo", nativeQuery = true)
    Long getCountRows();

}

package trelud.student_credentials.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trelud.student_credentials.pojo.Photo;
import trelud.student_credentials.pojo.Student;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
}

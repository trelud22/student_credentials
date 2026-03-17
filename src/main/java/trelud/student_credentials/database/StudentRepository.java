package trelud.student_credentials.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import trelud.student_credentials.dto.StudentDto;
import trelud.student_credentials.pojo.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<StudentDto> findAllByLastName(String lastName);

    @Query("SELECT max(s.id) FROM Student s")
    Long findMaxId();
}

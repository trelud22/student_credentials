package trelud.student_credentials.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trelud.student_credentials.pojo.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}

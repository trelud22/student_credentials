package trelud.student_credentials.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import trelud.student_credentials.pojo.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitDatabase {

    private final StudentRepository studentRepository;

    @PostConstruct
    public void createData(){
        try{
            InputStream is = this.getClass().getResourceAsStream("/student_credetials.json");

            ObjectMapper om = new ObjectMapper()
                    .registerModule(new JavaTimeModule());

            List<Student> students = om
                    .readerForListOf(Student.class)
                    .readValue(is);

            studentRepository.saveAll(students);
        }catch (IOException ioex){
            log.warn("File problem");
            log.debug("File problem " + ioex.getMessage());
            throw new RuntimeException(ioex);
        }
    }
}

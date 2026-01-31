package trelud.student_credentials.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trelud.student_credentials.database.StudentRepository;
import trelud.student_credentials.dto.StudentDto;
import trelud.student_credentials.pojo.Student;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public List<StudentDto> getAll(){
        return studentRepository.findAll()
                .stream().map(Student::getDto).toList();
    }

    public List<StudentDto> getAllByLastname(String lastname){
        return studentRepository.findAllByLastName(lastname);
    }
}

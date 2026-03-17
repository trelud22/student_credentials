package trelud.student_credentials.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trelud.student_credentials.database.StudentRepository;
import trelud.student_credentials.dto.StudentDto;
import trelud.student_credentials.pojo.Student;
import trelud.student_credentials.service.StudentService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/allStudentsDto")
    public ResponseEntity<List<StudentDto>> getAllStudentDtos(){
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/allStudents")
    public ResponseEntity<?> getAllStudentDtoByLastname(
            @RequestParam String lastname
    ){
        return ResponseEntity.ok(
                studentService.getAllByLastname(lastname)
        );
    }

    @GetMapping("/byMaxId")
    public ResponseEntity<StudentDto> getByMaxId(){
        return ResponseEntity.ok(studentService.getByMaxId());
    }
}

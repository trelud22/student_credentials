package trelud.student_credentials.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import trelud.student_credentials.database.PhotoRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PhotoController {

    private final PhotoRepository photoRepository;

    @GetMapping("/photos")
    public ResponseEntity<?> getAllStudents(){
        return ResponseEntity.ok(photoRepository.findAll());
    }
}

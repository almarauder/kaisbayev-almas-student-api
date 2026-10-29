package com.student.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

class StudentControllerTest {
    private final StudentRepository repo = mock(StudentRepository.class);
    private final StudentController controller = new StudentController(repo);

    @Test
    void createStudentKeepsKaisbayevAlmasData() {
        Student s = new Student("Almas", "Kaisbayev", "DevOps-01");
        when(repo.save(s)).thenReturn(s);
        assertEquals("Kaisbayev", controller.create(s).getSurname());
    }

    @Test
    void missingStudentReturns404() {
        when(repo.findById(999L)).thenReturn(Optional.empty());
        ResponseStatusException ex =
            assertThrows(ResponseStatusException.class, () -> controller.getOne(999L));
        assertEquals(404, ex.getStatusCode().value());
    }
}

package vignesh.springdataJPAexamples.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vignesh.springdataJPAexamples.entity.Course;
import vignesh.springdataJPAexamples.entity.Teacher;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseJava = Course
                .builder()
                .credit(5)
                .title("Java")
                .build();
        Course coursePython = Course.builder()
                .title("Python")
                .credit(4)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("whiz")
                .lastName("DBZS")
//                .courses(List.of(courseJava, coursePython))
                .build();

        teacherRepository.save(teacher);
    }
}
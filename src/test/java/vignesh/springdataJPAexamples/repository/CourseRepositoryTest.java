package vignesh.springdataJPAexamples.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vignesh.springdataJPAexamples.entity.Course;
import vignesh.springdataJPAexamples.entity.Teacher;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .lastName("DBZ")
                .firstName("Vegeta")
                .build();
        Course course = Course.builder()
                .credit(2)
                .title("HTML")
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

}
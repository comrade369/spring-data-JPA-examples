package vignesh.springdataJPAexamples.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    // pagination
    @Test
    public void findAllPagination() {
        Pageable firstPage = PageRequest.of(1, 3);
        List<Course> courses = courseRepository.findAll(firstPage).getContent();
        System.out.println("courses = " + courses);
        int totalPages = courseRepository.findAll(firstPage).getTotalPages();
        System.out.println("totalPages = " + totalPages);
        long totalElements = courseRepository.findAll(firstPage).getTotalElements();
        System.out.println("totalElements = " + totalElements);
    }

    // sorting
    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(1, 2, Sort.by("credit").descending());
        Pageable sortByTitleAndCredit = PageRequest.of(0, 2,
                Sort.by("title").descending().
                        and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);


    }

    @Test
    public void findByTitleContainingTest() {
        Pageable firstPage = PageRequest.of(0, 10);
        List<Course> courses = courseRepository.findByTitleContaining("a", firstPage).getContent();
        System.out.println("courses = " + courses);
    }

}
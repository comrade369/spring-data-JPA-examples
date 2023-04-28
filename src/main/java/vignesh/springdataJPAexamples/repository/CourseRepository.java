package vignesh.springdataJPAexamples.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vignesh.springdataJPAexamples.entity.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Custom pagination
    Page<Course> findByTitleContaining(String title, Pageable pageable);
}

package vignesh.springdataJPAexamples.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vignesh.springdataJPAexamples.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Custom methods.
    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    Student findByFirstNameOrLastName(String firstName, String lastName);

    // JPQL queries
    //  based on the class we created, not based on the tables on DB.

    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailId(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstByEmailId(String emailId);

    // Native query
    @Query(value = "select * from student_table s where s.email_address = ?1", nativeQuery = true)
    Student getStudentByEmailIdNative(String emailId);

    // Named params query
    @Query(value = "select * from student_table s where s.email_address = :emailId", nativeQuery = true)
    Student getStudentByEmailIdNativeNamedParam(@Param("emailId") String emailId);

    @Query(value = "update student_table s set s.first_name = ?1 where s.email_address = ?2", nativeQuery = true)
    @Transactional
    @Modifying
    int updateStudentNameByEmailId(String firstName, String emailId);

}

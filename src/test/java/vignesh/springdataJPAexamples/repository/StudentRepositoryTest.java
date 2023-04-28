package vignesh.springdataJPAexamples.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vignesh.springdataJPAexamples.entity.Guardian;
import vignesh.springdataJPAexamples.entity.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
//                .guardianEmail("goku@gmail.com")
//                .guardianMobile("9999999999")
//                .guardianName("Goku")
                .firstName("Gohan")
                .lastName("DBZ")
                .emailId("gohan@gmail.com")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("chichi@gmail.com")
                .mobile("9999988888")
                .name("ChiChi")
                .build();

        Student student = Student.builder()
                .emailId("gotan@gmail.com")
                .firstName("Gotan")
                .lastName("DBZ")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printStudentsByFirstName() {
        List<Student> students = studentRepository.findByFirstName("gotan");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentsByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("g");
        System.out.println("students = " + students);
    }

    @Test
    public void printAllStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println("students: " + students);
    }

    @Test
    public void printStudentById() {
        Student student = studentRepository.findById(2L).get();
        System.out.println("students: " + student);
    }

    @Test
    public void printStudentByLastName() {
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("chichi");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstAndLast() {
        Student student = studentRepository.findByFirstNameAndLastName("gohan", "dbz");
        System.out.println("students = " + student);
    }

    @Test
    public void printStudentByFirstOrLast() {
        Student student = studentRepository.findByFirstNameOrLastName("gotan", "");
        System.out.println("students = " + student);
    }

    @Test
    public void printGetStudentByEmailId() {
        Student student = studentRepository.getStudentByEmailId("gohan@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentFirstByEmailId() {
        String firstName = studentRepository.getStudentFirstByEmailId("gotan@gmail.com");
        System.out.println("firstName = " + firstName);
    }

    @Test
    public void printGetStudentByEmailIdNative() {
        Student student = studentRepository.getStudentByEmailIdNative("gotan@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentByEmailIdNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailIdNativeNamedParam("gohan@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId("gohan dbz", "gohan@gmail.com");
    }


}
package vignesh.springdataJPAexamples.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course_table",
        uniqueConstraints =
        @UniqueConstraint(name = "title_unique", columnNames = "title"))
public class Course {

    @Id
    @SequenceGenerator(name = "course_sequence"
            , sequenceName = "course_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private Long courseId;
    @Column(nullable = false)
    private String title;
    private Integer credit;

    // BI DIRECTIONAL MAPPING
    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;
}

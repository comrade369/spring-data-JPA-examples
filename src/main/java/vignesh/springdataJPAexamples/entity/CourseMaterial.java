package vignesh.springdataJPAexamples.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(name = "courseMaterial_sequence"
            , sequenceName = "courseMaterial_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courseMaterial_sequence")
    private Long courseMaterialId;
    private String url;

    // UNI DIRECTIONAL MAPPING
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    private Course course;
}

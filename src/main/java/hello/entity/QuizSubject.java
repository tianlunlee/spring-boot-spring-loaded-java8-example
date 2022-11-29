package hello.entity;

import com.mysql.cj.jdbc.Blob;

import javax.persistence.*;

@Entity
@Table(name="quizSubject")
public class QuizSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="quizSubject", nullable = false)
    private String quizSubject;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="timeLimit", nullable = false)
    private Integer timeLimit;

    @Lob
    private Byte[] quizImage;



    public Long getId() {
        return id;
    }
}

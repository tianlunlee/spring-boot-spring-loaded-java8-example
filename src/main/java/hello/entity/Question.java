package hello.entity;

import org.hibernate.annotations.Table;

import javax.persistence.*;

@Entity
@Table(appliesTo = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quizSubjectId", referencedColumnName = "id")
    private QuizSubject quizSubject;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="correctAnswer", nullable = false)
    private String correctAnswer;

    @Column(name="questionType", nullable = false)
    private String questionType;

    public Long getId() {
        return id;
    }
}

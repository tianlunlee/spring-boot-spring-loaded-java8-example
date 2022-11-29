package hello.entity;

import javax.persistence.*;

@Entity
@Table(name="Feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="rate", nullable = false)
    private int rate;

    @Column(name="comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "quizSubjectId", referencedColumnName = "id")
    private QuizSubject quizSubject;

    public QuizSubject getQuizSubject() {
        return quizSubject;
    }

    public void setQuizSubject(QuizSubject quizSubject) {
        this.quizSubject = quizSubject;
    }


    public Long getId() {
        return id;
    }


}

package hello.entity;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;

@Entity
@Table(name="submission")
public class Submission{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name="quizId", referencedColumnName = "id")
    private QuizSubject quizSubject;

    @Column(name = "takenDate")
    private Date takenDate;

    @Column(name = "startTime")
    private Time startTime;

    @Column(name = "endTime")
    private Time endTime;

    public Long getId() {
        return id;
    }
}

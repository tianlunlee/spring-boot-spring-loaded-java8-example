package hello.entity;

import javax.persistence.*;

@Entity
@Table(name="SubmissionDetails")
public class SubmissionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name="submissionId", referencedColumnName = "id")
    private Submission submission;

    @OneToOne
    @JoinColumn(name="questionId", referencedColumnName = "id")
    private Question question;

    public Long getId() {
        return id;
    }
}

package hello.entity;

import javax.persistence.*;

@Entity
@Table(name="Options")
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "questionId", referencedColumnName = "id")
    private Question question;

    public Long getId() {
        return id;
    }
}

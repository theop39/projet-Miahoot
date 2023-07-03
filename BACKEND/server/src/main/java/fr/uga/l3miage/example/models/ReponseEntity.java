package fr.uga.l3miage.example.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

//@Builder
@Data
@NoArgsConstructor
@Entity
public class ReponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReponse;

    @NotBlank
    private String label;

    //@Column(nullable = false)
    private Boolean estValide;

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_fk", referencedColumnName = "idQuestion")
    private QuestionEntity questionEntity;
    */
}


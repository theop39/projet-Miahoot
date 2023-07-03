package fr.uga.l3miage.example.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//@Builder

@Data
@NoArgsConstructor
@Entity
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuestion;

    @NotBlank // NotBlank = label ne peut pas être = à null ou empty ("" ou "   ")
    private String label;

    //@OrderBy("id ASC")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<ReponseEntity> reponses;

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "miahoot_fk", referencedColumnName = "idMiahoot")
    private MiahootEntity miahootEntity;
    */

}

package dsi.dsi.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pregunta")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pregunta {

    @Id
    @Column(name = "id_pregunta")
    int id;

    @Column(name = "pregunta")
    String pregunta;

    @ManyToOne
    @JoinColumn(name = "id_encuesta")
    Encuesta encuesta;
}

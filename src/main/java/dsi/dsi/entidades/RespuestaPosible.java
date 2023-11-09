package dsi.dsi.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "respuestaposible")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaPosible {

    @Id
    @Column(name = "id_respuestaposible")
    int id;

    @Column(name = "descripcion")
    String descripcion;


    @ManyToOne
    @JoinColumn(name = "id_pregunta")
    Pregunta pregunta;

}

package dsi.dsi.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private Encuesta encuesta;

    public boolean verificarRespuestas(List<String> respuestas){
        return respuestas.contains(pregunta);
    }

    public String getPregunta(){
        return pregunta;
    }


}

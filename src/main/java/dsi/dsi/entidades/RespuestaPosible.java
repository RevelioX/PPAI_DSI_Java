package dsi.dsi.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int id;

    @Column(name = "descripcion")
    private String descripcion;

    // @JsonIgnore
    // @ManyToOne
    // @JoinColumn(name = "id_pregunta")
    // private Pregunta pregunta;

    @Column(name = "valor")
    private int valor;


    public String mostrarDatos(){
       return getDescripcion();
    }

    public String getDescripcion() {
        return descripcion;
    }
}

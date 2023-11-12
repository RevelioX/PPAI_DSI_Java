package dsi.dsi.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "respuestacliente")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaCliente {

    @Id
    @Column(name = "id_respuestacliente")
    private int id;

    @Column(name = "fechaencuesta")
    private Date fechaEncuesta;

    @ManyToOne
    @JoinColumn(name = "respuestaseleccionada")
    private RespuestaPosible respuestaSeleccionada;


    public String mostrarDatosRTA(){
        return respuestaSeleccionada.mostrarDatos();
    }
}

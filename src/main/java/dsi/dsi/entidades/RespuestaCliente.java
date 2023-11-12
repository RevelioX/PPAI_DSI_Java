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
    int id;

    @Column(name = "fechaencuesta")
    Date fechaEncuesta;

    @ManyToOne
    @JoinColumn(name = "respuestaSeleccionada")
    private RespuestaPosible respuestaSeleccionada;


    public String mostrarDatosRTA(){
        return respuestaSeleccionada.mostrarDatos();
    }

    @OneToMany(mappedBy = "respuestaencuesta")
    private List<RespuestaCliente> respuestasClientes;
}

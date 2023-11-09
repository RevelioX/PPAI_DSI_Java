package dsi.dsi.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "llamada")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Llamada {

    @Id
    @Column(name = "id_llamada")
    int id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    Cliente cliente;

    @Column(name = "duracion")
    int duracion;

    @Column(name = "fecha_llamada")
    Date fechaLlamada;

    @OneToOne
    @JoinColumn(name = "respuestaencuesta")
    RespuestaCliente respuestaCliente;

    public boolean verificarPeriodo(long fechaInicio, long fechaFin) {
        return !(fechaLlamada.before(fechaInicio) || fechaLlamada.after(fechaFin));

    }
}

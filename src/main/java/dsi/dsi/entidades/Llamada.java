package dsi.dsi.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

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



    @OneToMany
    @JoinColumn(name = "respuestaencuesta")
    RespuestaCliente respuestaCliente;


    public String getNombreCliente() {
        return cliente.getNombre() + " " + cliente.getApellido();
    }
    public int getDuracion() {
        return duracion;
    }

    private List<RespuestaCliente> respuestasDeEncuesta;

    public Date getFechaLlamada() {
        return fechaLlamada;
    }

    public List<RespuestaCliente> getRespuestasCliente() {
        return (List<RespuestaCliente>) respuestaCliente;
    }

    public boolean verificarPeriodo(Date fechaInicio, Date fechaFin) {
        Date fechaLlamada = this.getFechaLlamada();
        return fechaLlamada.after(fechaInicio) && fechaLlamada.before(fechaFin);
    }

    public boolean verificarExistenciaDeRespuestas() {
        List<RespuestaCliente> respuestas = this.getRespuestasCliente();
        return respuestas != null && !respuestas.isEmpty();
    }

}

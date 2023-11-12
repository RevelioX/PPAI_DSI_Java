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
    List<RespuestaCliente> respuestaCliente;

    @OneToOne
    @JoinColumn(name = "cambioEstado")
    CambioEstado cambioEstado;


    public String getNombreCliente() {
        return cliente.getNombre() + " " + cliente.getApellido();
    }
    public int getDuracion() {
        return duracion;
    }

    public void mostarDatos() {
        String cliente = this.getCliente().getNombre();
        String estado = cambioEstado.esActivo();
        int duracion = getDuracion();
    }
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


    public List<String> buscarDescripcionesDeRespuestasCliente(){
        IteradorRespuestasDeCliente iteradorRespuestasDeCliente = new IteradorRespuestasDeCliente();
        iteradorRespuestasDeCliente.primero();
        List<String> respuestas = null;
        while(!iteradorRespuestasDeCliente.hasNext()){
            RespuestaCliente actual = iteradorRespuestasDeCliente.getActual();
            String descripcion = actual.mostrarDatosRTA();
            respuestas.add(descripcion);
            iteradorRespuestasDeCliente.next();
        }
        return respuestas;
    }

}

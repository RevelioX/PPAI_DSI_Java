package dsi.dsi.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "cambioestado")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CambioEstado {
    @Id
    @Column(name = "id_cambioestado")
    int id;

    @Column(name = "fechainicio")
    Date fechaInicio;

    @Column(name = "nombreestado")
    String nombreEstado;

    @ManyToOne
    @JoinColumn(name = "id_llamada")
    Llamada llamada;

    private Estado estado;
    public String getNombreEstado() {
            return estado.getNombre();
    }
}


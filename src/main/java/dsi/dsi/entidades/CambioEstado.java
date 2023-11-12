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
    private int id;

    @Column(name = "fechainicio")
    private Date fechaInicio;

    @OneToOne
    @Column(name = "nombreestado")
    private Estado nombreEstado;


    public String getNombreEstado() {
            return nombreEstado.getNombre();
    }

    public String esActivo(){
        return this.getNombreEstado();
    }

}

